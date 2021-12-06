package salary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class UI_Personal_information extends JFrame {

	// 定义组件
		private JScrollPane scpDemo;
		private JTableHeader jth;
		private JTable tabDemo;
		
	public UI_Personal_information(int abc, String num) {
		super();
		if(abc==1) {
			this.setTitle("查看个人信息");
			this.setSize(960,400);
			this.setLayout(null);
			this.setLocationRelativeTo(null); 
			setResizable(false);    //设置窗体不可改变大小
			this.setVisible(true);  // 显示窗体
			
			ImageIcon img = new ImageIcon("page.jpg");
		    JLabel jl_bg = new JLabel(img); //背景
		    jl_bg.setBounds(0,0,960,400); //设置位置和大小，先setLayout(null)一下。
		    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
		    ((JPanel)this.getContentPane()).setOpaque(false); //设置透明
			
			// 创建组件
			this.scpDemo = new JScrollPane();
			this.scpDemo.setBounds(20,30,900,220);
			add(this.scpDemo);   // 将组件加入到窗体中
			
			
			final JButton button4 = new JButton();
			button4.setText("返回");
			button4.setBounds(750, 300, 200, 50);
			getContentPane().add(button4);
			button4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					dispose();
			    	    UI_Employee u=new UI_Employee(num);
					}
				});
				    	   
			
			// 以下是连接数据源和显示数据的具体处理方法，请注意下
					try{
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("加载数据库驱动成功");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
						System.out.println("连接数据库成功");
						
						// 建立查询条件
						String sql = "select * from employee_file WHERE 员工编号='"+ num +"'";
						Statement stmt=con.createStatement();
						// 执行查询
						ResultSet rs = stmt.executeQuery(sql);
						// 计算有多少条记录
						int count = 0;
						while(rs.next()){
							count++;
							}
						rs = stmt.executeQuery(sql);
						// 将查询获得的记录数据，转换成适合生成JTable的数据形式
						Object[][] info = new Object[count][10];
						int n = 0;
						while(rs.next()){
							info[n][0] = rs.getString(1);
							info[n][1] = rs.getString(2);
							info[n][2] = rs.getString(3);
							info[n][3] = rs.getString(4);
							info[n][4] = rs.getString(5);
							info[n][5] = rs.getString(6);
							info[n][6] = rs.getString(7);
							info[n][7] = rs.getString(8);
							info[n][8] = rs.getString(9);
							info[n][9] = rs.getString(10);
							n++;
							}
						// 定义表头
						String[] title = { "员工编号", "姓名", "性别", "身份证号", "入职日期", "所在部门", "工作岗位", "民族" , "籍贯", "现住址"};
						// 创建JTable
						Font font = new Font("宋体", Font.PLAIN, 12);//创建1个字体实例
						this.tabDemo = new JTable(info,title);
						this.tabDemo.setFont(font);//设置JLabel的字体
						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.scpDemo.getViewport().add(tabDemo); 
					
						stmt.close();
				        con.close();
					}
					catch(ClassNotFoundException cnfe){	
						JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
					}
					catch(SQLException sqle){
						JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
						}
													
		}
		else {
			this.setTitle("查看工资信息");
			this.setSize(960,400);
			this.setLayout(null);
			this.setLocationRelativeTo(null); 
			this.setVisible(true);  // 显示窗体
			
			ImageIcon img = new ImageIcon("page.jpg");
		    JLabel jl_bg = new JLabel(img); //背景
		    jl_bg.setBounds(0,0,960,400); //设置位置和大小，先setLayout(null)一下。
		    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
		    ((JPanel)this.getContentPane()).setOpaque(false); //设置透明
			
			// 创建组件
			this.scpDemo = new JScrollPane();
			this.scpDemo.setBounds(20,30,900,220);
			add(this.scpDemo);   // 将组件加入到窗体中
			
			
			final JButton button4 = new JButton();
			button4.setText("返回");
			button4.setBounds(750, 300, 200, 50);
			getContentPane().add(button4);
			button4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					dispose();
			    	    UI_Employee u=new UI_Employee(num);
					}
				});
				    	   
			
			// 以下是连接数据源和显示数据的具体处理方法，请注意下
					try{
						// 获得连接
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("加载数据库驱动成功");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
						System.out.println("连接数据库成功");
						
						// 建立查询条件
						String sql = "select * from salary_file WHERE 员工编号='"+ num +"' order by 月份";
						Statement stmt=conn.createStatement();
						// 执行查询
						ResultSet rs = stmt.executeQuery(sql);
						// 计算有多少条记录
						int count = 0;
						while(rs.next()){
							count++;
							}
						rs = stmt.executeQuery(sql);
						// 将查询获得的记录数据，转换成适合生成JTable的数据形式
						Object[][] info = new Object[count][7];
						int n = 0;
						while(rs.next()){
							info[n][0] = rs.getString(1);
							info[n][1] = rs.getString(2);
							info[n][2] = rs.getString(3);
							info[n][3] = rs.getString(4);
							info[n][4] = rs.getString(5);
							info[n][5] = rs.getString(6);
							info[n][6] = rs.getString(7);
							n++;
							}
						// 定义表头
						String[] title = { "员工编号", "姓名", "基本工资", "岗位补贴", "工龄补贴", "工资总金额", "月份"};
						// 创建JTable
						this.tabDemo = new JTable(info,title);
						// 显示表头
						this.jth = this.tabDemo.getTableHeader();
						// 将JTable加入到带滚动条的面板中
						this.scpDemo.getViewport().add(tabDemo); 
						}
					catch(ClassNotFoundException cnfe){	
						JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
					}
					catch(SQLException sqle){
						JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
						}
		}
		
				
		
		
		
		
		
	}
}
