package salary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI_Salary_create extends JFrame {
	
	public UI_Salary_create() {
		super();
		this.setTitle("添加员工工资信息");     
		getContentPane().setLayout(null);
		setSize(400, 450);
		setLocationRelativeTo(null); 
		setResizable(false);    
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("page.jpg");
	    JLabel jl_bg = new JLabel(img); //背景
	    jl_bg.setBounds(0,0,400,450); //设置位置和大小，先setLayout(null)一下。
	    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)this.getContentPane()).setOpaque(false); //设置透明

		final JLabel label_1 = new JLabel();
		label_1.setText("输入员工编号：");
		label_1.setBounds(10, 20, 150, 30);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("姓名：");
		label_2.setBounds(10, 70, 100, 30);
		getContentPane().add(label_2);
		
		final JLabel label_3 = new JLabel();
		label_3.setText("基本工资：");
		label_3.setBounds(10, 120, 100, 30);
		getContentPane().add(label_3);
		
		final JLabel label_4 = new JLabel();
		label_4.setText("岗位补贴：");
		label_4.setBounds(10, 170, 100, 30);
		getContentPane().add(label_4);
		
		final JLabel label_5 = new JLabel();
		label_5.setText("工龄补贴：");
		label_5.setBounds(10, 220, 100, 30);
		getContentPane().add(label_5);
		
		final JLabel label_6 = new JLabel();
		label_6.setText("工资总金额：");
		label_6.setBounds(10, 270, 150, 30);
		getContentPane().add(label_6);
		
		final JLabel label_7 = new JLabel();
		label_7.setText("月份：");
		label_7.setBounds(10, 320, 100, 30);
		getContentPane().add(label_7);
		

		final JTextField b1= new JTextField(10);
		b1.setBounds(140, 20, 160, 27);
		getContentPane().add(b1);

		final JTextField b2= new JTextField(15);
		b2.setBounds(120, 70, 180, 27);
		getContentPane().add(b2);
		
		final JTextField b3= new JTextField(15);
		b3.setBounds(120, 120, 180, 27);
		getContentPane().add(b3);
		
		final JTextField b4= new JTextField(15);
		b4.setBounds(120, 170, 180, 27);
		getContentPane().add(b4);
		
		final JTextField b5= new JTextField(15);
		b5.setBounds(120, 220, 180, 27);
		getContentPane().add(b5);

		
		final JTextField b6= new JTextField(15);
		b6.setBounds(120, 270, 180, 27);
		getContentPane().add(b6);
		
		final JTextField b7= new JTextField(15);
		b7.setBounds(120, 320, 180, 27);
		getContentPane().add(b7);
		

		
		
		
		final JButton button1 = new JButton();
		button1.setText("确定");
		button1.setBounds(50, 360, 100, 30);
		getContentPane().add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String b_1 = b1.getText();
				String b_2 = b2.getText();
				String b_3 = b3.getText();
				String b_4 = b4.getText();
				String b_5 = b5.getText();
				String b_6 = b6.getText();
				String b_7 = b7.getText();
//				dispose();
		    	   
								
				try{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("加载驱动成功！");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
					System.out.println("连接数据库成功！");
					Statement stmt_1=con.createStatement();
					Statement stmt_2=con.createStatement();
					String sql_1 = "select * FROM salary_file WHERE 员工编号='"+ b_1 +"'"+"and 月份='"+ b_7 +"'";
					String sql_2 = "insert into salary_file values('"+b_1+"','"+b_2+"','"+b_3+"','"+b_4+"','"+b_5+"','"+b_6+"','"+b_7+"')";
					ResultSet rs_1=stmt_1.executeQuery(sql_1);
					
					if(!(b_1.equals(""))&& !(b_2.equals(""))&& !(b_3.equals(""))&& !(b_4.equals(""))&& !(b_5.equals(""))&& !(b_6.equals(""))&& !(b_7.equals("")))
					{
						if (rs_1.next()) {
							
							JOptionPane.showMessageDialog(null, "数据库中 "+b_7+" 月已有该员工的工资信息", "警告",JOptionPane.INFORMATION_MESSAGE);
							
							
							} 
						else {
							int T = stmt_2.executeUpdate(sql_2);
							if(T>0) {
								JOptionPane.showMessageDialog(null, "添加成功!", "提示",JOptionPane.WARNING_MESSAGE);
								dispose();
								UI_Salary_management u=new UI_Salary_management();
							}
							else {
								JOptionPane.showMessageDialog(null, "添加失败", "提示",JOptionPane.INFORMATION_MESSAGE);
								dispose();
								UI_Salary_management u=new UI_Salary_management();
							}
							}			
					}
					else {
						JOptionPane.showMessageDialog(null, "有选项未填", "提示",JOptionPane.INFORMATION_MESSAGE);
					}
					
					rs_1.close();
					stmt_1.close();
			        con.close();
					}
				catch(Exception ee){
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "数据库连接失败", "警告",JOptionPane.INFORMATION_MESSAGE);
					}

				}
			});
		
		
		final JButton button3 = new JButton();
		button3.setText("查询");
		button3.setBounds(310, 20, 80, 30);
		getContentPane().add(button3);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String b_1 = b1.getText();
//				dispose();
		    	   
								
				try{
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("加载驱动成功！");
					//连接，数据库对象
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
					System.out.println("连接数据库成功！");
					Statement stmt_1=con.createStatement();
					String sql_1 = "select * FROM salary_file WHERE 员工编号='"+ b_1 +"'";
					ResultSet rs_1=stmt_1.executeQuery(sql_1);
					
					if (rs_1.next()) {
						b2.setText(rs_1.getString(2));
						b3.setText(rs_1.getString(3));
						} 
					else {
							JOptionPane.showMessageDialog(new JPanel(), "数据库中没有该员工信息!", "提示",JOptionPane.WARNING_MESSAGE);
							dispose();
							UI_Salary_management u=new UI_Salary_management();
						}
					
					rs_1.close();
					stmt_1.close();
			        con.close();
					}
				catch(Exception ee){
					ee.printStackTrace();
					System.out.println("连接数据库失败！");
					}
				
				
				}
			});
		
						
		final JButton button2 = new JButton();
		button2.setText("返回");
		button2.setBounds(230, 360, 100, 30);
		getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	UI_Salary_management u=new UI_Salary_management();
				}
			});
		
		
					
	}
	
}
