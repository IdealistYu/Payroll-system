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

public class UI_Employee_create extends JFrame{
	public UI_Employee_create() {
		super();
		this.setTitle("���Ա����Ϣ");     
		getContentPane().setLayout(null);
		setSize(400, 650);
		setLocationRelativeTo(null); 
		setResizable(false);    
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("page.jpg");
	    JLabel jl_bg = new JLabel(img); //����
	    jl_bg.setBounds(0,0,400,700); //����λ�úʹ�С����setLayout(null)һ�¡�
	    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��

		final JLabel label_1 = new JLabel();
		label_1.setText("Ա����ţ�");
		label_1.setBounds(10, 20, 100, 30);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("������");
		label_2.setBounds(10, 70, 100, 30);
		getContentPane().add(label_2);
		
		final JLabel label_3 = new JLabel();
		label_3.setText("�Ա�");
		label_3.setBounds(10, 120, 100, 30);
		getContentPane().add(label_3);
		
		final JLabel label_4 = new JLabel();
		label_4.setText("���֤�ţ�");
		label_4.setBounds(10, 170, 100, 30);
		getContentPane().add(label_4);
		
		final JLabel label_5 = new JLabel();
		label_5.setText("��ְ���ڣ�");
		label_5.setBounds(10, 220, 100, 30);
		getContentPane().add(label_5);
		
		final JLabel label_6 = new JLabel();
		label_6.setText("���ڲ��ţ�");
		label_6.setBounds(10, 270, 100, 30);
		getContentPane().add(label_6);
		
		final JLabel label_7 = new JLabel();
		label_7.setText("������λ��");
		label_7.setBounds(10, 320, 100, 30);
		getContentPane().add(label_7);
		
		final JLabel label_8 = new JLabel();
		label_8.setText("���壺");
		label_8.setBounds(10, 370, 100, 30);
		getContentPane().add(label_8);
		
		final JLabel label_9 = new JLabel();
		label_9.setText("���᣺");
		label_9.setBounds(10, 420, 100, 30);
		getContentPane().add(label_9);
		
		final JLabel label_10 = new JLabel();
		label_10.setText("��סַ��");
		label_10.setBounds(10, 470, 100, 30);
		getContentPane().add(label_10);

		final JLabel label_11 = new JLabel();
		label_11.setText("Ȩ�ޣ�");
		label_11.setBounds(10, 520, 100, 30);
		getContentPane().add(label_11);

		final JTextField b1= new JTextField(10);
		b1.setBounds(120, 20, 180, 27);
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
		
		final JTextField b8= new JTextField(15);
		b8.setBounds(120, 370, 180, 27);
		getContentPane().add(b8);
		
		final JTextField b9= new JTextField(15);
		b9.setBounds(120, 420, 180, 27);
		getContentPane().add(b9);
		
		final JTextField b10= new JTextField(15);
		b10.setBounds(120, 470, 180, 27);
		getContentPane().add(b10);
		
		final JTextField b11= new JTextField(15);
		b11.setBounds(120, 520, 180, 27);
		getContentPane().add(b11);
		
		
		
		final JButton button1 = new JButton();
		button1.setText("ȷ��");
		button1.setBounds(50, 560, 100, 30);
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
				String b_8 = b8.getText();
				String b_9 = b9.getText();
				String b_10 = b10.getText();
				String b_11 = b11.getText();
//				dispose();
		    	   
								
				try{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("���������ɹ���");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
					System.out.println("�������ݿ�ɹ���");
					Statement stmt_1=con.createStatement();
					Statement stmt_2=con.createStatement();
					String sql_1 = "select * FROM employee_file WHERE Ա�����='"+ b_1 +"'";
					String sql_2 = "insert into employee_file values('"+b_1+"','"+b_2+"','"+b_3+"','"+b_4+"','"+b_5+"','"+b_6+"','"+b_7+"','"
					                                        +b_8+"','"+b_9+"','"+b_10+"','"+b_11+"')";
					ResultSet rs_1=stmt_1.executeQuery(sql_1);
					
					if(!(b_1.equals(""))&& !(b_2.equals(""))&& !(b_3.equals(""))&& !(b_4.equals(""))&& !(b_5.equals(""))&& !(b_6.equals(""))
							&& !(b_7.equals(""))&& !(b_8.equals(""))&& !(b_9.equals(""))&& !(b_10.equals(""))&& !(b_11.equals("")))
					  {
						if (rs_1.next()) {
							
							JOptionPane.showMessageDialog(new JPanel(), "���ݿ������и�Ա����Ϣ", "����",JOptionPane.INFORMATION_MESSAGE);

							
							
							} 
						else {
							int T = stmt_1.executeUpdate(sql_2);
							if(T>0) {
								JOptionPane.showMessageDialog(new JPanel(), "��ӳɹ�!", "��ʾ",JOptionPane.WARNING_MESSAGE);
								dispose();
								UI_Employee_management u=new UI_Employee_management();
							}
							else {
								JOptionPane.showMessageDialog(new JPanel(), "���ʧ��", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
								dispose();
								UI_Employee_management u=new UI_Employee_management();
							}
							}
					  }
					else {
						JOptionPane.showMessageDialog(null, "��ѡ��δ��", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
					  }
					
					}
				catch(Exception ee){
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��", "����",JOptionPane.INFORMATION_MESSAGE);
					}
				
				
				}
			});
		
		
						
		final JButton button2 = new JButton();
		button2.setText("����");
		button2.setBounds(230, 560, 100, 30);
		getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	UI_Employee_management u=new UI_Employee_management();
				}
			});
		
		
					
	}
}





