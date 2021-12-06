package salary;
import java.sql.*;

public class DbUtil {
public static void main(String[] args) {
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/gz_db";
    String user="root"; 
    String password="772110";  //密码

    try {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("加载驱动成功！");
    }catch(Exception e) {
        e.printStackTrace();
        System.out.println("加载驱动失败！");
    }
    try {  
        //2.连接
        ct=DriverManager.getConnection( url,user,password);
        System.out.println("连接数据库成功！");
    }catch(Exception e) {
        e.printStackTrace();
        System.out.println("连接数据库失败！");
    }

    /* 尝试添加数据到数据库中  */
    try {
        //在连接对象的基础上创建会话对象
        Statement stmt = ct.createStatement();
        //写查询数据的SQL语句
        String sql = "select * from employee_file";
        rs=stmt.executeQuery(sql);
        System.out.println("id"+"\t"+"name"+"\t"+"quanxian");
        //).executeQuery可用来查询数据库并返回一个查询结果集ResultSet
        while(rs.next()){
        	System.out.println(rs.getInt("num")+"\t"+rs.getString("name")+"\t"+rs.getString("quanxian"));
        	}
        stmt.close();
        ct.close();
    }catch(SQLException ex) {
        ex.printStackTrace();
        System.out.println("失败");
   
    
//    String s4="select id,name,password from tbNames"; 
//    Class.forName(driver); 
//    Connection conn = DriverManager.getConnection(url,dbUser,dbPwd); 
//    Statement stmt=conn.createStatement(); 
//    ResultSet rs = stmt.executeQuery(s4); 
//    while(rs.next){ 
//    int id=rs.getInt(1); 
//    String name = rs.getString(2); 
//    String pwd=rs.getString(3); 
//    System.out.println(id+name+pwd);                     } 

        }
    }
}
