package dao;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//这个类负责针对Project对象进行数据操作
public class ProjectDao {
    public void save(Project project){
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;

        String sql = "insert into project_table values(?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,project.getName());
            ps.setString(2,project.getUrl());
            ps.setString(3,project.getDescription());
            ps.setInt(4,project.getStarCount());
            ps.setInt(5,project.getForkCount());
            ps.setInt(6,project.getOpenedIssueCount());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            ps.setString(7,simpleDateFormat.format(System.currentTimeMillis()));
            int ret = ps.executeUpdate();
            if(ret != 1){
                System.out.println("数据库执行插入错误");
                return;
            }
            System.out.println("数据插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResource(connection,ps,null);
        }
    }

    public List<Project> selectProjectByDate(String date) {
        List<Project> projects = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select name,url,starCount,forkCount,openedIssueCount " +
                "from project_table where date = ? order by starCount desc";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setName(rs.getString("name"));
                project.setUrl(rs.getString("url"));
                project.setStarCount(rs.getInt("starCount"));
                project.setForkCount(rs.getInt("forkCount"));
                project.setOpenedIssueCount(rs.getInt("openedIssueCount"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResource(connection,ps,rs);
        }
        return projects;

    }

    public static void main(String[] args) {
        ProjectDao projectDao = new ProjectDao();
        List<Project> projects = projectDao.selectProjectByDate("20201007");
        System.out.println(projects);
    }

}
