package salary;
import java.sql.*;

public class DbUtil {
public static void main(String[] args) {
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/gz_db";
    String user="root"; 
    String password="772110";  //����

    try {
        //1.��������
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("���������ɹ���");
    }catch(Exception e) {
        e.printStackTrace();
        System.out.println("��������ʧ�ܣ�");
    }
    try {  
        //2.����
        ct=DriverManager.getConnection( url,user,password);
        System.out.println("�������ݿ�ɹ���");
    }catch(Exception e) {
        e.printStackTrace();
        System.out.println("�������ݿ�ʧ�ܣ�");
    }

    /* ����������ݵ����ݿ���  */
    try {
        //�����Ӷ���Ļ����ϴ����Ự����
        Statement stmt = ct.createStatement();
        //д��ѯ���ݵ�SQL���
        String sql = "select * from employee_file";
        rs=stmt.executeQuery(sql);
        System.out.println("id"+"\t"+"name"+"\t"+"quanxian");
        //).executeQuery��������ѯ���ݿⲢ����һ����ѯ�����ResultSet
        while(rs.next()){
        	System.out.println(rs.getInt("num")+"\t"+rs.getString("name")+"\t"+rs.getString("quanxian"));
        	}
        stmt.close();
        ct.close();
    }catch(SQLException ex) {
        ex.printStackTrace();
        System.out.println("ʧ��");
   
    
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
