package JDBCPractice;

import Util.JDBCUtils;
import bean.Student;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Exer2Test {
    public static void main(String[] args) {

        //queryWithIDCardOrExamCard();
        testDeleteByExamCard();
    }

    public static void insertTest(String sql){
        Scanner scanner = new Scanner(System.in);
        System.out.println("四六级");
        int type = scanner.nextInt();
        System.out.println("身份证号");
        String idCard = scanner.next();
        System.out.println("准考证号");
        String examCard = scanner.next();
        System.out.println("考生姓名");
        String name = scanner.next();
        System.out.println("考生住址");
        String location = scanner.next();
        System.out.println("考试成绩");
        int grade = scanner.nextInt();
        int result = insertMessage(sql, type, idCard, examCard, name, location, grade);
        if(result > 0){
            System.out.println("添加成功!");
        }else{
            System.out.println("添加失败!");
        }

    }
    public static int insertMessage(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResourceUpdate(conn,ps);
        }
        return 0;
    }
    public static void queryWithIDCardOrExamCard(){
        System.out.println("请选择您要查询的方式");
        System.out.println("a.通过身份证号查询");
        System.out.println("b.通过准考证号查询");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();
        if("a".equalsIgnoreCase(selection)){
            System.out.print("请输入您的身份证号：");
            String idCard = scanner.next();
            String sql = "SELECT FlowID flowID,`Type` `type`,IDCard,ExamCard examCard,StudentName `name`,Location location,Grade grade FROM examstudent WHERE IDCard = ?";
            Student student = getInstance(Student.class, sql, idCard);
            System.out.println("您所查询到的信息如下：");
            System.out.println(student);
        }else if("b".equalsIgnoreCase(selection)){
            System.out.print("请输入您的准考证号：");
            String examCard = scanner.next();
            String sql ="SELECT FlowID flowID,`Type` `type`,IDCard,ExamCard examCard,StudentName `name`,Location location,Grade grade FROM examstudent WHERE ExamCard = ?";
            Student student = getInstance(Student.class, sql, examCard);
            System.out.println("您所查询到的信息如下：");
            System.out.println(student);
        }else{
            System.out.println("您的输入有误，请重新执行操作！");
        }

    }
    public static void testDeleteByExamCard(){
        System.out.println("请输入考生准考证号");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.next();
        String sql = "SELECT FlowID flowID,`Type` `type`,IDCard,ExamCard examCard,StudentName `name`,Location location,Grade grade FROM examstudent WHERE ExamCard = ?";
        Student student = getInstance(Student.class, sql, examCard);
        if(student == null){
            System.out.println("查无此人请重新输入");
        }else{
            String sql1 = "DELETE FROM examstudent WHERE ExamCard = ?";
            int update = update(sql1, examCard);
            if(update > 0){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        }
    }
    public static int update(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps =  null;
        try{
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResourceUpdate(conn,ps);
        }
        return 0;
    }
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
