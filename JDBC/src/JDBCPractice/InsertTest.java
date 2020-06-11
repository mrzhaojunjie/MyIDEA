package JDBCPractice;

import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

//使用PreparedStatement实现批量操作
//方式一：
// Connection conn = JDBCUtil.getConnection();
//  Statement st = conn.createStatement();
//  for(int i = 1;i <= 20000;i++){
//      String sql = "insert into goods(name) values('name_"+i+"')";   //每次都会开辟一个String的内存
//      st.excuteUpdate(sql);
// }
public class InsertTest{
    public static void main(String[] args){
        //testInsert1();
        testInsert3();
    }
    public static void testInsert1(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            String sql = "INSERT INTO goods(name) VALUES(?)";
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("所需时间为："+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourceUpdate(conn, ps);
        }
    }
    public static void testInsert2(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            String sql = "INSERT INTO goods(name) VALUES(?)";
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.addBatch(); //攒sql
                if (i % 500 == 0) {
                    ps.executeBatch();  //更新批量数据
                    ps.clearBatch();   //清理空间
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("所需时间为："+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourceUpdate(conn, ps);
        }
    }
    public static void testInsert3(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            String sql = "INSERT INTO goods(name) VALUES(?)";
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);  //取消自动提交  堆数据
            ps = conn.prepareStatement(sql);

            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.addBatch(); //攒sql
                if (i % 500 == 0) {
                    ps.executeBatch();  //更新一批
                    ps.clearBatch();   //清理空间
                }
            }
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("所需时间为："+(end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourceUpdate(conn, ps);
        }
    }
}
