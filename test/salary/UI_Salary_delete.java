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

public class UI_Salary_delete extends JFrame{
	
	public UI_Salary_delete() {
		super();
		setTitle("ɾ��Ա����Ϣ");     
		getContentPane().setLayout(null);
		setSize(450, 230);
		setLocationRelativeTo(null); 
		setResizable(false);    
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("page.jpg");
	    JLabel jl_bg = new JLabel(img); //����
	    jl_bg.setBounds(0,0,450,350); //����λ�úʹ�С����setLayout(null)һ�¡�
	    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��

		final JLabel label_1 = new JLabel();
		label_1.setText("������Ҫɾ����Ա����ţ�");
		label_1.setBounds(10, 50, 250, 30);
		getContentPane().add(label_1);
		
		final JTextField b1= new JTextField(10);
		b1.setBounds(250, 50, 130, 27);
		getContentPane().add(b1);
		
		final JLabel label_2 = new JLabel();
		label_2.setText("������Ҫɾ�����·ݣ�");
		label_2.setBounds(10, 100, 200, 30);
		getContentPane().add(label_2);
		
		final JTextField b2= new JTextField(10);
		b2.setBounds(200, 100, 180, 27);
		getContentPane().add(b2);
		
		
		final JButton button1 = new JButton();
		button1.setText("����");
		button1.setBounds(260, 150, 100, 30);
		getContentPane().add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	UI_Salary_management u=new UI_Salary_management();
				}
			});
		
		final JButton button2 = new JButton();
		button2.setText("ɾ��");
		button2.setBounds(80, 150, 100, 30);
		getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String b_1 = b1.getText();
				String b_2 = b2.getText();
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("���������ɹ���");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
					System.out.println("�������ݿ�ɹ���");
					Statement stmt_1=con.createStatement();
					Statement stmt_2=con.createStatement();
					String sql_1 = "select * FROM salary_file WHERE Ա�����='"+ b_1 +"' and �·�='"+b_2+"'";
					String sql_2 = "DELETE FROM salary_file WHERE Ա�����='"+ b_1 +"'and �·�='"+b_2+"'";
					ResultSet rs_1=stmt_1.executeQuery(sql_1);
					
					if (rs_1.next()) {
						int T = stmt_2.executeUpdate(sql_2);
						if(T>0) {
							JOptionPane.showMessageDialog(null, "�ɹ�ɾ��Ա��"+b_1+"�� "+b_2+" �·ݵĹ�����Ϣ", "��ʾ",JOptionPane.WARNING_MESSAGE);
							dispose();
							UI_Salary_management u=new UI_Salary_management();
						}
						else {							
							JOptionPane.showMessageDialog(null, "ɾ��ʧ��!(Ա����Ų����ڻ����·ݲ�����)", "��ʾ",JOptionPane.WARNING_MESSAGE);	
							dispose();
							UI_Salary_management u=new UI_Salary_management();
						}
					}						
					else {
						
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��! (Ա����Ų����ڻ����·ݲ�����)", "����",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						UI_Salary_delete u=new UI_Salary_delete();
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
