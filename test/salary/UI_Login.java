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
	setTitle("���ʹ������ϵͳ");     
	getContentPane().setLayout(null);   //getContentPane()ȡ��Frame��ContentPane����ʼ��һ�����������������������һЩ�ؼ�
	setSize(500, 350);
	setResizable(false);    //���ô��岻�ɸı��С
	setLocationRelativeTo(null);   
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ImageIcon img = new ImageIcon("page.jpg");
    JLabel jl_bg = new JLabel(img); //����
    jl_bg.setBounds(0, 0, 500, 350); //����λ�úʹ�С����setLayout(null)һ�¡�
    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��

	final JLabel label_1 = new JLabel();   //final �Է��κμ̳����޸����ĺ���
	label_1.setText("�˺ţ�");
	label_1.setBounds(130, 60, 70, 27);
	getContentPane().add(label_1);

	final JLabel label_2 = new JLabel();
	label_2.setText("���룺");
	label_2.setBounds(130, 110, 70, 27);
	getContentPane().add(label_2);

	final JTextField zh= new JTextField(10);
	zh.setBounds(180, 60, 180, 27);
	getContentPane().add(zh);
		
	final JPasswordField mm= new JPasswordField(15);
	mm.setBounds(180, 110, 180, 27);
	getContentPane().add(mm);

	final JButton button = new JButton();
	button.setText("��¼");
	button.setBounds(110, 200, 100, 30);
	getContentPane().add(button);
	button.addActionListener(new ActionListener(){   //������һ��ʵ����ActionListener�ӿڵĶ�
		public void actionPerformed(ActionEvent e) {
			loginTip(zh, mm);
			}
		});

	final JButton button_1 = new JButton();
	button_1.setText("�˳�");
	button_1.setBounds(310, 200, 100, 30);
	getContentPane().add(button_1);
	button_1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			dispose();   //����Դ����
			System.exit(0);
			}
		});
}


private void loginTip(JTextField zh,JPasswordField mm){
	String user = zh.getText();
	String password = mm.getText();
	String num ="";

	if(user.equals("")){
		JOptionPane.showMessageDialog(null,"�˺Ų���Ϊ��","����",JOptionPane.WARNING_MESSAGE);
		mm.setText("");
		return;
		}
	if(password.equals("")){
		JOptionPane.showMessageDialog(null,"���벻��Ϊ��","����",JOptionPane.WARNING_MESSAGE);
		zh.setText("");
		return;
		}
	try{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("���������ɹ���");
		//���ӣ����ݿ����
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
		System.out.println("�������ݿ�ɹ���");
		//ִ��SQL�Ķ���
		Statement stmt_1=con.createStatement();
		Statement stmt_2=con.createStatement();

		String sql_1 = "select * FROM user_file WHERE �˺�='"+ user +"' and ���� ='"+password +"'" ;
		String sql_2 = "select * FROM user_file WHERE �˺�='"+ user +"' and Ȩ��='1' ";
		ResultSet rs_1=stmt_1.executeQuery(sql_1);
		ResultSet rs_2=stmt_2.executeQuery(sql_2);
		if (rs_1.next()) {
			// TODO�� �������У��ɹ�����ʾ�ɹ���¼��ʾ�����رյ�¼����
			
			JOptionPane.showMessageDialog(this, "�ɹ���¼", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			
			if (rs_2.next()) {
				// TODO�� �������У��ɹ�����ʾϵͳ����Ա����
				rs_1.close();
				rs_2.close();
				stmt_1.close();
				stmt_2.close();
		        con.close();
				
				UI_Administrator ui_2=new UI_Administrator();
				System.out.println("��ϵͳ����Ա����");
				
			}
			else {
				// TODO�� ������ʾԱ������
				rs_1.close();
				stmt_1.close();
				stmt_2.close();
				Statement stmt_3=con.createStatement();
				String sql_3 = "select Ա����� FROM user_file WHERE �˺�='"+ user +"'";
				ResultSet rs_3=stmt_3.executeQuery(sql_3);
				while (rs_3.next()){
					num=rs_3.getString("Ա�����");
				}
				stmt_3.close();
				con.close();
				UI_Employee u=new UI_Employee(num);
				System.out.println("��Ա������");
				
			}
			
			} 
		else {
			JOptionPane.showMessageDialog(this, "�ʺŻ��������!", "����",JOptionPane.WARNING_MESSAGE);
			mm.setText("");
			zh.requestFocus(); // �����ѡ��
			}
		}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("�������ݿ�ʧ�ܣ�");
		}
	}

}