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

	// �������
		private JScrollPane scpDemo;
		private JTableHeader jth;
		private JTable tabDemo;
		
	public UI_Personal_information(int abc, String num) {
		super();
		if(abc==1) {
			this.setTitle("�鿴������Ϣ");
			this.setSize(960,400);
			this.setLayout(null);
			this.setLocationRelativeTo(null); 
			setResizable(false);    //���ô��岻�ɸı��С
			this.setVisible(true);  // ��ʾ����
			
			ImageIcon img = new ImageIcon("page.jpg");
		    JLabel jl_bg = new JLabel(img); //����
		    jl_bg.setBounds(0,0,960,400); //����λ�úʹ�С����setLayout(null)һ�¡�
		    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
		    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��
			
			// �������
			this.scpDemo = new JScrollPane();
			this.scpDemo.setBounds(20,30,900,220);
			add(this.scpDemo);   // ��������뵽������
			
			
			final JButton button4 = new JButton();
			button4.setText("����");
			button4.setBounds(750, 300, 200, 50);
			getContentPane().add(button4);
			button4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					dispose();
			    	    UI_Employee u=new UI_Employee(num);
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
						String sql = "select * from employee_file WHERE Ա�����='"+ num +"'";
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
						// �����ͷ
						String[] title = { "Ա�����", "����", "�Ա�", "���֤��", "��ְ����", "���ڲ���", "������λ", "����" , "����", "��סַ"};
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
		else {
			this.setTitle("�鿴������Ϣ");
			this.setSize(960,400);
			this.setLayout(null);
			this.setLocationRelativeTo(null); 
			this.setVisible(true);  // ��ʾ����
			
			ImageIcon img = new ImageIcon("page.jpg");
		    JLabel jl_bg = new JLabel(img); //����
		    jl_bg.setBounds(0,0,960,400); //����λ�úʹ�С����setLayout(null)һ�¡�
		    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
		    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��
			
			// �������
			this.scpDemo = new JScrollPane();
			this.scpDemo.setBounds(20,30,900,220);
			add(this.scpDemo);   // ��������뵽������
			
			
			final JButton button4 = new JButton();
			button4.setText("����");
			button4.setBounds(750, 300, 200, 50);
			getContentPane().add(button4);
			button4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					dispose();
			    	    UI_Employee u=new UI_Employee(num);
					}
				});
				    	   
			
			// ��������������Դ����ʾ���ݵľ��崦��������ע����
					try{
						// �������
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("�������ݿ������ɹ�");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
						System.out.println("�������ݿ�ɹ�");
						
						// ������ѯ����
						String sql = "select * from salary_file WHERE Ա�����='"+ num +"' order by �·�";
						Statement stmt=conn.createStatement();
						// ִ�в�ѯ
						ResultSet rs = stmt.executeQuery(sql);
						// �����ж�������¼
						int count = 0;
						while(rs.next()){
							count++;
							}
						rs = stmt.executeQuery(sql);
						// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
						// �����ͷ
						String[] title = { "Ա�����", "����", "��������", "��λ����", "���䲹��", "�����ܽ��", "�·�"};
						// ����JTable
						this.tabDemo = new JTable(info,title);
						// ��ʾ��ͷ
						this.jth = this.tabDemo.getTableHeader();
						// ��JTable���뵽���������������
						this.scpDemo.getViewport().add(tabDemo); 
						}
					catch(ClassNotFoundException cnfe){	
						JOptionPane.showMessageDialog(null,"����Դ����","����",JOptionPane.ERROR_MESSAGE);
					}
					catch(SQLException sqle){
						JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
						}
		}
		
				
		
		
		
		
		
	}
}
