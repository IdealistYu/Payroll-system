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

public class UI_Salary_statistic extends JFrame{

	// 定义组件
			private JScrollPane scpDemo;
			private JTableHeader jth;
			private JTable tabDemo;
			private JButton btnShow;
			// 构造方法
			public UI_Salary_statistic(){
				super();
				this.setTitle("员工工资统计分析");
				this.setSize(800,400);
				this.setLayout(null);
				this.setLocationRelativeTo(null); 
				setResizable(false);    //设置窗体不可改变大小
				this.setVisible(true);  // 显示窗体
				
				ImageIcon img = new ImageIcon("page.jpg");
			    JLabel jl_bg = new JLabel(img); //背景
			    jl_bg.setBounds(0,0,800,400); //设置位置和大小，先setLayout(null)一下。
			    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
			    ((JPanel)this.getContentPane()).setOpaque(false); //设置透明
				
				// 创建组件
				this.scpDemo = new JScrollPane();
				this.scpDemo.setBounds(20,30,750,250);
				add(this.scpDemo);   // 将组件加入到窗体中		
				
				final JButton button4 = new JButton();
				button4.setText("返回主界面");
				button4.setBounds(580, 300, 200, 50);
				getContentPane().add(button4);
				button4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						dispose();
						
						UI_Administrator u=new UI_Administrator();
						}
					});
					    
					   
				
						try{
							// 获得连接
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("加载数据库驱动成功");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
							System.out.println("连接数据库成功");
							
							// 建立查询条件
							String sql = "select 月份,max(工资总金额),min(工资总金额),max(工资总金额)-min(工资总金额),AVG(工资总金额),SUM(工资总金额)  from salary_file  group by 月份 order by 月份";
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
							Object[][] info = new Object[count][6];
							int n = 0;
							while(rs.next()){
								info[n][0] = rs.getString(1);
								info[n][1] = rs.getString(2);
								info[n][2] = rs.getString(3);
								info[n][3] = rs.getString(4);
								info[n][4] = rs.getString(5);
								info[n][5] = rs.getString(6);
								n++;
								}
							// 定义表头
							String[] title = { "月份", "最高工资", "最低工资", "最高 - 最低", "该月所有人平均工资", "所发工资总金额"};
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
	
}
