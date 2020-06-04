package Transation;

import Util.Utils;

import java.lang.reflect.Field;
import java.sql.*;

public class TransationTest {
    public static void main(String[] args) {
        testUpedate();
    }

    //通用增删改 1.0 未考虑数据库事务
    public static int update(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Utils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Utils.closeResourceUpdate(conn,ps);
        }
        return 0;
    }
    //通用增删改 2.0 考虑数据库事务

    public static int update2(Connection conn,String sql,Object...args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Utils.closeResourceUpdate(null,ps);
        }
        return 0;
    }
    public static void testUpedate(){
        Connection conn = null;
        try {
            conn = Utils.getConnection();
            //取消数据自动提交
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update2(conn,sql1,"AA");
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update2(conn,sql2,"BB");
            System.out.println("转账成功");
            conn.commit();
        }catch (Exception e){  //抛出异常后回滚数据
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                conn.setAutoCommit(true);   //将数据库的自动提交设置回来，防止连接池重复调用时造成的错误，默认是true
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Utils.closeResourceUpdate(conn,null);
        }



    }
    public static void testTransationSelect() throws Exception{
        Connection conn = Utils.getConnection();
        //获取数据库隔离级别
        conn.getTransactionIsolation();
        //设置数据库隔离级别为读已提交
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        conn.setAutoCommit(false);
        String sql = "select user,password,balance from user_table where user = ?";
        User user = getInstance(conn,User.class,sql,"CC");
        System.out.println(user);

    }
    public static void testTransationUpdate() throws Exception {
        Connection conn = Utils.getConnection();
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        update2(conn,sql,5000,"CC");

    }
    public static <T> T getInstance(Connection conn,Class<T> clazz,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Utils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //拿到结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //拿到元数据的列数
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //拿到结果集中的列中的值
                    Object columnValue = rs.getObject(i + 1);
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);
                    //通过反射将对象指定名columnName的属性赋值为指定的值columnValue；
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResourceQuery(null, ps, rs);
        }
        return null;
    }
}
