package salary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class UI_Login extends JFrame{
	public static void main(String args[]) {
				try {
					UI_Login dl = new UI_Login();
					dl.setVisible(true);
					}
				catch (Exception e) {
					e.printStackTrace();
					}
				}
		
public UI_Login() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
	super();
	Font vFont = new Font("Dialog", Font.PLAIN, 20);

	UIManager.put("ToolTip.font", vFont);

	UIManager.put("Table.font", vFont);

	//UIManager.put("TableHeader.font", vFont);

	UIManager.put("TextField.font", vFont);

	UIManager.put("ComboBox.font", vFont);

	UIManager.put("TextField.font", vFont);

	//UIManager.put("PasswordField.font", vFont);

	UIManager.put("TextArea.font", vFont);

	UIManager.put("TextPane.font", vFont);

	UIManager.put("EditorPane.font", vFont);

	UIManager.put("FormattedTextField.font", vFont);

	UIManager.put("Button.font", vFont);

	UIManager.put("CheckBox.font", vFont);

	UIManager.put("RadioButton.font", vFont);

	UIManager.put("ToggleButton.font", vFont);

	UIManager.put("ProgressBar.font", vFont);

	UIManager.put("DesktopIcon.font", vFont);

	UIManager.put("TitledBorder.font", vFont);

	UIManager.put("Label.font", vFont);

	UIManager.put("List.font", vFont);

	UIManager.put("TabbedPane.font", vFont);

	UIManager.put("MenuBar.font", vFont);

	UIManager.put("Menu.font", vFont);

	UIManager.put("MenuItem.font", vFont);

	UIManager.put("PopupMenu.font", vFont);

	UIManager.put("CheckBoxMenuItem.font", vFont);

	UIManager.put("RadioButtonMenuItem.font", vFont);

	UIManager.put("Spinner.font", vFont);

	UIManager.put("Tree.font", vFont);

	UIManager.put("ToolBar.font", vFont);

	UIManager.put("OptionPane.messageFont", vFont);

	UIManager.put("OptionPane.buttonFont", vFont);
	String lookAndFeel =UIManager.getSystemLookAndFeelClassName();
	UIManager.setLookAndFeel(lookAndFeel);
	setTitle("工资管理管理系统");     
	getContentPane().setLayout(null);   //getContentPane()取得Frame的ContentPane，初始化一个容器，用来在容器上添加一些控件
	setSize(500, 350);
	setResizable(false);    //设置窗体不可改变大小
	setLocationRelativeTo(null);   
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ImageIcon img = new ImageIcon("page.jpg");
    JLabel jl_bg = new JLabel(img); //背景
    jl_bg.setBounds(0, 0, 500, 350); //设置位置和大小，先setLayout(null)一下。
    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
    ((JPanel)this.getContentPane()).setOpaque(false); //设置透明

	final JLabel label_1 = new JLabel();   //final 以防任何继承类修改它的含义
	label_1.setText("账号：");
	label_1.setBounds(130, 60, 70, 27);
	getContentPane().add(label_1);

	final JLabel label_2 = new JLabel();
	label_2.setText("密码：");
	label_2.setBounds(130, 110, 70, 27);
	getContentPane().add(label_2);

	final JTextField zh= new JTextField(10);
	zh.setBounds(180, 60, 180, 27);
	getContentPane().add(zh);
		
	final JPasswordField mm= new JPasswordField(15);
	mm.setBounds(180, 110, 180, 27);
	getContentPane().add(mm);

	final JButton button = new JButton();
	button.setText("登录");
	button.setBounds(110, 200, 100, 30);
	getContentPane().add(button);
	button.addActionListener(new ActionListener(){   //声明了一个实现了ActionListener接口的对
		public void actionPerformed(ActionEvent e) {
			loginTip(zh, mm);
			}
		});

	final JButton button_1 = new JButton();
	button_1.setText("退出");
	button_1.setBounds(310, 200, 100, 30);
	getContentPane().add(button_1);
	button_1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			dispose();   //将资源销毁
			System.exit(0);
			}
		});
}


private void loginTip(JTextField zh,JPasswordField mm){
	String user = zh.getText();
	String password = mm.getText();
	String num ="";

	if(user.equals("")){
		JOptionPane.showMessageDialog(null,"账号不能为空","警告",JOptionPane.WARNING_MESSAGE);
		mm.setText("");
		return;
		}
	if(password.equals("")){
		JOptionPane.showMessageDialog(null,"密码不能为空","警告",JOptionPane.WARNING_MESSAGE);
		zh.setText("");
		return;
		}
	try{
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("加载驱动成功！");
		//连接，数据库对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
		System.out.println("连接数据库成功！");
		//执行SQL的对象
		Statement stmt_1=con.createStatement();
		Statement stmt_2=con.createStatement();

		String sql_1 = "select * FROM user_file WHERE 账号='"+ user +"' and 密码 ='"+password +"'" ;
		String sql_2 = "select * FROM user_file WHERE 账号='"+ user +"' and 权限='1' ";
		ResultSet rs_1=stmt_1.executeQuery(sql_1);
		ResultSet rs_2=stmt_2.executeQuery(sql_2);
		if (rs_1.next()) {
			// TODO： 如果数据校验成功，显示成功登录提示，并关闭登录界面
			
			JOptionPane.showMessageDialog(this, "成功登录", "提示",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			
			if (rs_2.next()) {
				// TODO： 如果数据校验成功，显示系统管理员界面
				rs_1.close();
				rs_2.close();
				stmt_1.close();
				stmt_2.close();
		        con.close();
				
				UI_Administrator ui_2=new UI_Administrator();
				System.out.println("打开系统管理员界面");
				
			}
			else {
				// TODO： 否则，显示员工界面
				rs_1.close();
				stmt_1.close();
				stmt_2.close();
				Statement stmt_3=con.createStatement();
				String sql_3 = "select 员工编号 FROM user_file WHERE 账号='"+ user +"'";
				ResultSet rs_3=stmt_3.executeQuery(sql_3);
				while (rs_3.next()){
					num=rs_3.getString("员工编号");
				}
				stmt_3.close();
				con.close();
				UI_Employee u=new UI_Employee(num);
				System.out.println("打开员工界面");
				
			}
			
			} 
		else {
			JOptionPane.showMessageDialog(this, "帐号或密码错误!", "警告",JOptionPane.WARNING_MESSAGE);
			mm.setText("");
			zh.requestFocus(); // 密码框选中
			}
		}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("连接数据库失败！");
		}
	}

}