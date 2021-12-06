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

public class UI_Salary_retrieve extends JFrame{
	
	public UI_Salary_retrieve() {
		super();
		this.setTitle("查询员工工资信息");     
		getContentPane().setLayout(null);
		setSize(430, 420);
		setLocationRelativeTo(null); 
		setResizable(false);    
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("page.jpg");
	    JLabel jl_bg = new JLabel(img); //背景
	    jl_bg.setBounds(0,0,430,420); //设置位置和大小，先setLayout(null)一下。
	    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)this.getContentPane()).setOpaque(false); //设置透明

		final JLabel label_1 = new JLabel();
		label_1.setText("查询的员工编号:");
		label_1.setBounds(10, 20, 170, 30);
		getContentPane().add(label_1);
		
		final JLabel label_7 = new JLabel();
		label_7.setText("查询的月份:");
		label_7.setBounds(10, 70, 150, 30);
		getContentPane().add(label_7);

		final JLabel label_2 = new JLabel();
		label_2.setText("姓名：");
		label_2.setBounds(10, 120, 100, 30);
		getContentPane().add(label_2);
		
		final JLabel label_3 = new JLabel();
		label_3.setText("基本工资：");
		label_3.setBounds(10, 170, 100, 30);
		getContentPane().add(label_3);
		
		final JLabel label_4 = new JLabel();
		label_4.setText("岗位补贴：");
		label_4.setBounds(10, 220, 100, 30);
		getContentPane().add(label_4);
		
		final JLabel label_5 = new JLabel();
		label_5.setText("工龄补贴：");
		label_5.setBounds(10, 270, 100, 30);
		getContentPane().add(label_5);
		
		final JLabel label_6 = new JLabel();
		label_6.setText("工资总金额：");
		label_6.setBounds(10, 320, 150, 30);
		getContentPane().add(label_6);
		
		
		

		final JTextField b1= new JTextField(10);
		b1.setBounds(170, 20, 130, 27);
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
		button1.setText("查询");
		button1.setBounds(310, 20, 100, 30);
		getContentPane().add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String b_1 = b1.getText();
				String b_2 = b2.getText();
//				dispose();
				
				if(!(b_1.equals(""))&& !(b_2.equals("")))
				{
					
					try{
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("加载驱动成功！");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
						System.out.println("连接数据库成功！");
						Statement stmt_1=con.createStatement();
						String sql_1 = "select * FROM salary_file WHERE 员工编号='"+ b_1 +"'"+"and 月份='"+ b_2 +"'";
						ResultSet rs_1=stmt_1.executeQuery(sql_1);
						
						if (rs_1.next()) {
//							b2.setText(rs_1.getString(2));
							b3.setText(rs_1.getString(2));
							b4.setText(rs_1.getString(3));
							b5.setText(rs_1.getString(4));
							b6.setText(rs_1.getString(5));
							b7.setText(rs_1.getString(6));
							} 
						else {
								JOptionPane.showMessageDialog(new JPanel(), "数据库中没有员工编号为 "+b_1+" 的 "+b_2+" 月份的工资信息!", "提示",JOptionPane.WARNING_MESSAGE);
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
				else {
					JOptionPane.showMessageDialog(null, "员工编号或月份未填写!", "提示",JOptionPane.INFORMATION_MESSAGE);
				}
		    	   
								
	
				
				
				}
			});
		
		
		final JButton button2 = new JButton();
		button2.setText("重置");
		button2.setBounds(310, 60, 100, 30);
		getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				b1.setText("");
				b2.setText("");
				b3.setText("");
				b4.setText("");
				b5.setText("");
				b6.setText("");
				b7.setText("");
				}
			});
		
						
		final JButton button3 = new JButton();
		button3.setText("返回");
		button3.setBounds(310, 100, 100, 30);
		getContentPane().add(button3);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				UI_Salary_management u=new UI_Salary_management();
				}
			});
		
		
					
	}
	
}
