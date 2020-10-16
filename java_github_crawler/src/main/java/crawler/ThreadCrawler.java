package crawler;

import dao.Project;
import dao.ProjectDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCrawler extends Crawler {
    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();
        ThreadCrawler threadCrawler = new ThreadCrawler();
        String html = threadCrawler.getPage("https://github.com/akullpp/awesome-java/blob/master/README.md");

        List<Project> projects = threadCrawler.parseProjectList(html);
        long startCallAPI = System.currentTimeMillis();

        List<Future<?>> taskResults = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (Project project : projects) {
            Future<?> taskResult = executorService.submit(new CrawlerTask(project,threadCrawler));
            taskResults.add(taskResult);
        }

        for (Future<?> taskResult : taskResults) {
            try {
                //调用get方法就阻塞，阻塞到任务执行完毕get才返回
                taskResult.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //结束线程池
        executorService.shutdown();

        long finishCallAPI = System.currentTimeMillis();
        System.out.println("调用API的时间："+ (finishCallAPI - startCallAPI) + "ms");
        ProjectDao projectDao = new ProjectDao();
        for (Project project : projects) {
            projectDao.save(project);
        }

        System.out.println("整体程序执行时间: "+ (System.currentTimeMillis() - startTime) + "ms");
    }

    static class CrawlerTask implements Runnable{

        private Project project;
        private ThreadCrawler threadCrawler;

        public CrawlerTask(Project project, ThreadCrawler threadCrawler) {
            this.project = project;
            this.threadCrawler = threadCrawler;
        }

        @Override
        public void run() {

            try {
                System.out.println("crawing  "+ project.getName() + "...");
                String repoName = threadCrawler.getRepoName(project.getUrl());
                String jsonString = threadCrawler.getRepoInfo(repoName);
                //解析项目数据
                threadCrawler.parseRepoInfo(jsonString,project);
                System.out.println("crawing  "+ project.getName() + "Done!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
