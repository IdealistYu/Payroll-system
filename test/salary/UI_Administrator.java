package salary;

import java.awt.event.*;  
import javax.swing.*;  
public class UI_Administrator extends JFrame
{  
	public UI_Administrator()
    { 
	setTitle("ϵͳ����Ա����");     
	getContentPane().setLayout(null);
	setSize(500, 400);
	setLocationRelativeTo(null); 
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setVisible(true); 
    setResizable(false);    //���ô��岻�ɸı��С
    ImageIcon img = new ImageIcon("page.jpg");
    JLabel jl_bg = new JLabel(img); //����
    jl_bg.setBounds(0, 0, 500, 400); //����λ�úʹ�С����setLayout(null)һ�¡�
    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
    ((JPanel)this.getContentPane()).setOpaque(false); //����͸��


    
    final JButton button = new JButton();
    button.setText("����Ա����Ϣ");
    button.setBounds(150, 30, 200, 50);
    getContentPane().add(button);
    button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
    	dispose();
    	UI_Employee_management UI2=new UI_Employee_management();
    }
    });
    
    
    final JButton button1 = new JButton();
    button1.setText("����Ա��������Ϣ");
    button1.setBounds(150, 120, 200, 50);
    getContentPane().add(button1);
    button1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
    	dispose();
    	UI_Salary_management UI2=new UI_Salary_management();
    }
    });
    
    
    final JButton button2 = new JButton();
    button2.setText("ͳ�Ʒ���");
    button2.setBounds(150, 210, 200, 50);
    getContentPane().add(button2);
    button2.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
    	dispose();
    	UI_Salary_statistic u=new UI_Salary_statistic();
    }
    });


        final JButton button4 = new JButton();
        button4.setText("ע��");
        button4.setBounds(150, 300, 200, 50);
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


