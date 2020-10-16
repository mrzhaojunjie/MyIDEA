package dao;

public class Project {
    //项目名字  a标签的内容
    private String name;

    //项目主页链接，a标签中的href
    private String url;
    //项目描述信息
    private String description;

    //统计到的数据
    //根据项目url进入项目页面查看这三个属性
    private int starCount;
    private int forkCount;
    private int openedIssueCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public int getForkCount() {
        return forkCount;
    }

    public void setForkCount(int forkCount) {
        this.forkCount = forkCount;
    }

    public int getOpenedIssueCount() {
        return openedIssueCount;
    }

    public void setOpenedIssueCount(int openedIssueCount) {
        this.openedIssueCount = openedIssueCount;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", starCount=" + starCount +
                ", forkCount=" + forkCount +
                ", openedIssueCount=" + openedIssueCount +
                '}';
    }
}
