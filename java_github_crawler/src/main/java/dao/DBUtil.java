package dao;



import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//单例类管理数据库
public class DBUtil {
    private static String URL = "jdbc:mysql://127.0.0.1:3306/java_github_crawler?characterEncoding=utf8&&useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    private static volatile DataSource dataSource = null;

    private static DataSource getDataSource(){
        //懒汉式
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    dataSource = new MysqlDataSource();

                    MysqlDataSource mysqlDataSource = (MysqlDataSource) dataSource;
                    mysqlDataSource.setURL(URL);
                    mysqlDataSource.setUser(USERNAME);
                    mysqlDataSource.setPassword(PASSWORD);
                }
            }
        }

        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeResource(Connection conn, PreparedStatement ps,ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
