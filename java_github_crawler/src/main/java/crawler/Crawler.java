package crawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dao.Project;
import dao.ProjectDao;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Crawler {

    private HashSet<String> urlBlackList = new HashSet<>();

    private Gson gson = new GsonBuilder().create();
    //创建OKHttpClient对象
    private OkHttpClient okHttpClient = new OkHttpClient();

    {
        //黑名单  非GitHub项目
        urlBlackList.add("https://github.com/events");
        urlBlackList.add("https://github.community");
        urlBlackList.add("https://github.com/about");
        urlBlackList.add("https://github.com/pricing");
        urlBlackList.add("https://github.com/contact");
    }

    public static void main(String[] args) throws IOException {
        Crawler crawler = new Crawler();

        long startTime = System.currentTimeMillis();
        //获取页面
        String html = crawler.getPage("https://github.com/akullpp/awesome-java/blob/master/README.md");
        long endTime = System.currentTimeMillis();
        System.out.println("获取入口页面用时  " + (endTime - startTime) +"ms");
        //  System.out.println(respBody);
        List<Project> projects = crawler.parseProjectList(html);

        System.out.println("解析项目列表用时  " + (System.currentTimeMillis() - endTime) + "ms");

        endTime = System.currentTimeMillis();
        for(int i = 0;i < projects.size();i++){
           try {
               Project project = projects.get(i);
               System.out.println("crawing   "+project.getName()+"...");
               String repoName = crawler.getRepoName(project.getUrl());
               String jsonString = crawler.getRepoInfo(repoName);
               crawler.parseRepoInfo(jsonString,project);

               System.out.println("crawing   "+project.getName()+"  Done!");
           } catch (Exception e){
               e.printStackTrace();
           }
        }

        System.out.println("解析所有项目用时  " + (System.currentTimeMillis() - endTime) +"ms");
        endTime = System.currentTimeMillis();
        ProjectDao projectDao = new ProjectDao();
        for(int i = 0;i < projects.size();i++){
            //保存项目到数据库
            Project project = projects.get(i);
            projectDao.save(project);
        }

        System.out.println("存储数据库用时  "+ (System.currentTimeMillis() - endTime) + "ms");
        endTime = System.currentTimeMillis();
        System.out.println("整个项目总用时  "+ (endTime - startTime) + "ms");

    }

    public List<Project> parseProjectList(String html) {
        ArrayList<Project> result = new ArrayList<>();
        //使用Jsop分析页面结构  获取li标签
        //创建Document对象,将html字符串转换成Document对象
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByTag("li");
        for (Element li : elements) {
            Elements allLink = li.getElementsByTag("a");
            if (allLink.size() == 0) {
                //li标签中没有a标签
                continue;
            }
            //一个li里边有一个a标签
            Element link = allLink.get(0);
            String url = link.attr("href");
            if (!url.startsWith("https://github.com") || urlBlackList.contains(url)) {
                //不是github项目直接跳过
                continue;
            }
            Project project = new Project();
            project.setName(link.text());
            project.setUrl(link.attr("href"));
            project.setDescription(li.text());
            result.add(project);
        }
        return result;
    }


    //通过url获取页面信息
    public String getPage(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        //创建Call对象（一次网络访问操作）
        Call call = okHttpClient.newCall(request);
        //发送请求并获取response对象
        Response response = call.execute();
        if (!response.isSuccessful()) {
            System.out.println("请求失败");
            return null;
        }
        return response.body().string();
    }

    //通过github提供的API获取指定仓库信息
    public String getRepoInfo(String repoName) throws IOException {
        String userName = "mrzhaojunjie";
        String password = "bittechnology0";

        //身份认证  将用户名和密码加密并放到HTTP请求中
        String credential = Credentials.basic(userName, password);
        String url = "https://api.github.com/repos/" + repoName;
        Request request = new Request.Builder().url(url).header("Authorization", credential).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (!response.isSuccessful()) {
            System.out.println("访问Github API 失败！url = " + url);
            return null;
        }
        return response.body().string();
    }

    public String getRepoName(String url) {
        int lastOne = url.lastIndexOf("/");
        int lastTwo = url.lastIndexOf("/", lastOne - 1);
        if (lastOne == -1 || lastTwo == -1) {

            System.out.println("当前url不合法!非标准项目url" + url);
            return null;
        }
        return url.substring(lastTwo + 1);
    }

    public void parseRepoInfo(String jsonString, Project project) {
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> hashMap = gson.fromJson(jsonString, type);
        // hashMap 中的 key 的名字都是源于 Github API 的返回值.
        Double starCount = (Double)hashMap.get("stargazers_count");
        project.setStarCount(starCount.intValue());
        Double forkCount = (Double)hashMap.get("forks_count");
        project.setForkCount(forkCount.intValue());
        Double openedIssueCount = (Double)hashMap.get("open_issues_count");
        project.setOpenedIssueCount(openedIssueCount.intValue());
    }
}
