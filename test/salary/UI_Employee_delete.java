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

public class UI_Employee_delete extends JFrame{
	public UI_Employee_delete() {
		super();
		setTitle("ɾ��Ա����Ϣ");     
		getContentPane().setLayout(null);
		setSize(450, 200);
		setLocationRelativeTo(null); 
		setResizable(false);    
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("page.jpg");
	    JLabel jl_bg = new JLabel(img); //����
	    jl_bg.setBounds(0,0,600,200); //����λ�úʹ�С����setLayout(null)һ�¡�
	    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��

		final JLabel label_1 = new JLabel();
		label_1.setText("������Ҫɾ����Ա����ţ�");
		label_1.setBounds(10, 50, 300, 30);
		getContentPane().add(label_1);
		
		final JTextField b1= new JTextField(10);
		b1.setBounds(260, 50, 80, 27);
		getContentPane().add(b1);
		
		
		final JButton button1 = new JButton();
		button1.setText("����");
		button1.setBounds(260, 100, 100, 30);
		getContentPane().add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	UI_Employee_management u=new UI_Employee_management();
				}
			});
		
		final JButton button2 = new JButton();
		button2.setText("ɾ��");
		button2.setBounds(80, 100, 100, 30);
		getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String b_1 = b1.getText();
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("���������ɹ���");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
					System.out.println("�������ݿ�ɹ���");
					Statement stmt_1=con.createStatement();
					Statement stmt_2=con.createStatement();
					String sql_1 = "select * FROM employee_file WHERE Ա�����='"+ b_1 +"'";
					String sql_2 = "DELETE FROM employee_file WHERE Ա�����='"+ b_1 +"'";
					ResultSet rs_1=stmt_1.executeQuery(sql_1);
					
					if (rs_1.next()) {
						int T = stmt_2.executeUpdate(sql_2);
						if(T>0) {
							JOptionPane.showMessageDialog(new JPanel(), "ɾ���ɹ�!", "��ʾ",JOptionPane.WARNING_MESSAGE);
							dispose();
							UI_Employee_management u=new UI_Employee_management();
						}
						else {							
							JOptionPane.showMessageDialog(new JPanel(), "ɾ��ʧ��!", "��ʾ",JOptionPane.WARNING_MESSAGE);	
							dispose();
							UI_Employee_management u=new UI_Employee_management();
						}
					}						
					else {
						
						JOptionPane.showMessageDialog(new JPanel(), "���ݿ���û�и�Ա����Ϣ", "����",JOptionPane.INFORMATION_MESSAGE);
						b1.setText("");
						}
					
					rs_1.close();	
					stmt_1.close();
					stmt_2.close();
			        con.close();
				
				}
				catch(Exception ee){
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��", "����",JOptionPane.INFORMATION_MESSAGE);
					}
				
				}
			});
		
	}
}
