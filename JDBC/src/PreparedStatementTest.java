import Util.JDBCUtils;
import bean.Books;
import bean.Manager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementTest {
    public static void main(String[] args) {
        String sql = "SELECT emp_id managerId,emp_name managerName,emp_sex managerSex FROM manager WHERE emp_id=?";
        Manager instance = getInstance(Manager.class, sql, 5);
        System.out.println(instance);
        String sql1 = "SELECT shangjiazhe_id id,books_name name,author_name authorName FROM books WHERE shangjiazhe_id=?";
        List<Books> list = getForList(Books.class, sql1, 3);
        list.forEach(System.out::println);
    }
    public static <T> List<T> getForList(Class<T> clazz,String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while(rs.next()){
                T t = clazz.newInstance();
                for(int i = 0;i < columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResourceQuery(conn,ps,rs);
        }
        return null;
    }
    //使用PreparedStatement实现不同表的通用查找
    public static <T> T getInstance(Class<T> clazz,String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.closeResourceQuery(conn, ps, rs);
        }
        return null;
    }

}
