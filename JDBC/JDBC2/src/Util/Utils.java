package Util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
    //获取链接的操作
    public static Connection getConnection(){
        Connection connection = null;
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("booksmanagementsystem");
        DataSource dataSource = mysqlDataSource;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭资源的操作
    public static void closeResourceUpdate(Connection connection, Statement ps){

        try{
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResourceQuery(Connection connection, Statement ps,ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
