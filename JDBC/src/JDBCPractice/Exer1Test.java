package JDBCPractice;

import Util.JDBCUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exer1Test {
    public static void main(String[] args) {
       // testInsert();
        String sql = "insert into manager(emp_name,emp_sex) values(?,?)";
        update(sql,"猪猪侠","男");
    }
    public static void testInsert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入上架者的ID");
        int i = scanner.nextInt();
        System.out.println("请输入书名");
        String name = scanner.next();
        System.out.println("请输入作者");
        String authorName = scanner.next();
        String sql = "INSERT INTO books(shangjiazhe_id,books_name,author_name) VALUES(?,?,?)";
        int insertCount = update(sql,i,name,authorName);
        if(insertCount > 0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
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
}
