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

	// �������
			private JScrollPane scpDemo;
			private JTableHeader jth;
			private JTable tabDemo;
			private JButton btnShow;
			// ���췽��
			public UI_Salary_statistic(){
				super();
				this.setTitle("Ա������ͳ�Ʒ���");
				this.setSize(800,400);
				this.setLayout(null);
				this.setLocationRelativeTo(null); 
				setResizable(false);    //���ô��岻�ɸı��С
				this.setVisible(true);  // ��ʾ����
				
				ImageIcon img = new ImageIcon("page.jpg");
			    JLabel jl_bg = new JLabel(img); //����
			    jl_bg.setBounds(0,0,800,400); //����λ�úʹ�С����setLayout(null)һ�¡�
			    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
			    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��
				
				// �������
				this.scpDemo = new JScrollPane();
				this.scpDemo.setBounds(20,30,750,250);
				add(this.scpDemo);   // ��������뵽������		
				
				final JButton button4 = new JButton();
				button4.setText("����������");
				button4.setBounds(580, 300, 200, 50);
				getContentPane().add(button4);
				button4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						dispose();
						
						UI_Administrator u=new UI_Administrator();
						}
					});
					    
					   
				
						try{
							// �������
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("�������ݿ������ɹ�");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gz_db","root","772110");
							System.out.println("�������ݿ�ɹ�");
							
							// ������ѯ����
							String sql = "select �·�,max(�����ܽ��),min(�����ܽ��),max(�����ܽ��)-min(�����ܽ��),AVG(�����ܽ��),SUM(�����ܽ��)  from salary_file  group by �·� order by �·�";
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
							// �����ͷ
							String[] title = { "�·�", "��߹���", "��͹���", "��� - ���", "����������ƽ������", "���������ܽ��"};
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
