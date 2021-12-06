package salary;

import java.awt.event.*;
import javax.swing.*;  
public class UI_Employee extends JFrame
{  
	public UI_Employee(String num)
    {
	this.setTitle("员工界面");     
	getContentPane().setLayout(null);
	setSize(500, 350);
	setLocationRelativeTo(null);   //将容器的布局设为绝对布局
	setResizable(false);    //设置窗体不可改变大小
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setVisible(true); 
    ImageIcon img = new ImageIcon("page.jpg");
    JLabel jl_bg = new JLabel(img); //背景
    jl_bg.setBounds(0, 0, 500, 350); //设置位置和大小，先setLayout(null)一下。
    getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
    ((JPanel)this.getContentPane()).setOpaque(false); //设置透明
    
    
    final JButton button = new JButton();
    button.setText("查看个人信息");
    button.setBounds(150, 30, 200, 50);
    getContentPane().add(button);
    button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
    	dispose();
    	UI_Personal_information u=new UI_Personal_information(1,num);
    }
    });
    
    final JButton button1 = new JButton();
    button1.setText("查看工资信息");
    button1.setBounds(150, 130, 200, 50);
    getContentPane().add(button1);
    button1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {

    	dispose();
    	UI_Personal_information u=new UI_Personal_information(0,num);
    }
    });
    
    
    final JButton button4 = new JButton();
	button4.setText("注销");
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