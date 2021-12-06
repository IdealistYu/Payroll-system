package salary;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.JTableHeader;  
public class UI_Employee_management extends JFrame {
	// �������
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;
	// ���췽��
	public UI_Employee_management(){
		super();
		this.setTitle("Ա����Ϣ����");
		this.setSize(960,600);
		this.setLayout(null);
		this.setLocationRelativeTo(null); 
		setResizable(false);    //���ô��岻�ɸı��С
		this.setVisible(true);  // ��ʾ����
		
		ImageIcon img = new ImageIcon("page.jpg");
	    JLabel jl_bg = new JLabel(img); //����
	    jl_bg.setBounds(0,0,960,700); //����λ�úʹ�С����setLayout(null)һ�¡�
	    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��
		
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(20,100,900,350);
		add(this.scpDemo);   // ��������뵽������
		
		final JButton button0 = new JButton("���Ա����Ϣ");
		button0.setBounds(90,20,200,50);
		getContentPane().add(button0);
		button0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
				UI_Employee_create t=new UI_Employee_create();
				}
			});
		
		final JButton button1 = new JButton();
		button1.setText("ɾ��Ա����Ϣ");
		button1.setBounds(290, 20, 200, 50);
		getContentPane().add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				UI_Employee_delete u=new UI_Employee_delete();
				}
			    });
			    
		final JButton button2 = new JButton();
		button2.setText("��ѯԱ����Ϣ");
		button2.setBounds(490, 20, 200, 50);
		getContentPane().add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				UI_Employee_retrieve u=new UI_Employee_retrieve();
				}
			});
			    
		final JButton button3 = new JButton();
		button3.setText("�޸�Ա����Ϣ");
		button3.setBounds(690, 20, 200, 50);
		getContentPane().add(button3);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				UI_Employee_update u=new UI_Employee_update();
				}
			});
		
		final JButton button4 = new JButton();
		button4.setText("����������");
		button4.setBounds(750, 500, 200, 50);
		getContentPane().add(button4);
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				UI_Administrator u=new UI_Administrator();
				}
			});
			    
			   
		
			   
		
		// ��������������Դ����ʾ���ݵľ��崦��������ע����
				try{
					// �������
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("�������ݿ������ɹ�");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
					System.out.println("�������ݿ�ɹ�");
					
					// ������ѯ����
					String sql = "select * from employee_file order by Ա�����";
					Statement stmt=con.createStatement();
					// ִ�в�ѯ
					ResultSet rs = stmt.executeQuery(sql);
					// �����ж�������¼
					int count = 0;
					while(rs.next()){
						count++;
						}
					rs = stmt.executeQuery(sql);
					// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
					Object[][] info = new Object[count][11];
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
						info[n][10] = rs.getString(11);
						n++;
						}
					// �����ͷ
					String[] title = { "Ա�����", "����", "�Ա�", "���֤��", "��ְ����", "���ڲ���", "������λ", "����" , "����", "��סַ", "Ȩ��"};
					// ����JTable
					Font font = new Font("����", Font.PLAIN, 12);//����1������ʵ��
					this.tabDemo = new JTable(info,title);
					this.tabDemo.setFont(font);//����JLabel������
					// ��ʾ��ͷ
					this.jth = this.tabDemo.getTableHeader();
					// ��JTable���뵽���������������
					this.scpDemo.getViewport().add(tabDemo); 
					
					stmt.close();
			        con.close();
					}
				catch(ClassNotFoundException cnfe){	
					JOptionPane.showMessageDialog(null,"����Դ����","����",JOptionPane.ERROR_MESSAGE);
				}
				catch(SQLException sqle){
					JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
					}
	}	
}

