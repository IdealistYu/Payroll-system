package salary;

import java.awt.event.*;
import javax.swing.*;  
public class UI_Employee extends JFrame
{  
	public UI_Employee(String num)
    {
	this.setTitle("Ա������");     
	getContentPane().setLayout(null);
	setSize(500, 350);
	setLocationRelativeTo(null);   //�������Ĳ�����Ϊ���Բ���
	setResizable(false);    //���ô��岻�ɸı��С
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setVisible(true); 
    ImageIcon img = new ImageIcon("page.jpg");
    JLabel jl_bg = new JLabel(img); //����
    jl_bg.setBounds(0, 0, 500, 350); //����λ�úʹ�С����setLayout(null)һ�¡�
    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��
    
    
    final JButton button = new JButton();
    button.setText("�鿴������Ϣ");
    button.setBounds(150, 30, 200, 50);
    getContentPane().add(button);
    button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
    	dispose();
    	UI_Personal_information u=new UI_Personal_information(1,num);
    }
    });
    
    final JButton button1 = new JButton();
    button1.setText("�鿴������Ϣ");
    button1.setBounds(150, 130, 200, 50);
    getContentPane().add(button1);
    button1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {

    	dispose();
    	UI_Personal_information u=new UI_Personal_information(0,num);
    }
    });
    
    
    final JButton button4 = new JButton();
	button4.setText("ע��");
	button4.setBounds(150, 230, 200, 50);
	getContentPane().add(button4);
	button4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			dispose();
            UI_Login d= null;
            try {
                d = new UI_Login();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
            d.setVisible(true);
			}
		});
    
    }  
}