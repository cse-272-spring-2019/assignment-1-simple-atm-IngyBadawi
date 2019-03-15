import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
public class withdrawAndDeposit extends JFrame {
	
	private double value;
	
	

	private JFrame frame3=new JFrame();
	Account a=new Account(10000);
	LoggedIn l=new LoggedIn(a);
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	private JPanel contentPane;
	boolean checkValidNumber(String s) {
		for(int i=0;i<s.length();i++) if(s.charAt(i)<'0' || s.charAt(i)>'9') return false; return true;
	}
	
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
	public withdrawAndDeposit() {};

	public withdrawAndDeposit(Account a,boolean state) {
		
		LoggedIn frame2=new LoggedIn(a);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		URL link = withdrawAndDeposit.class.getResource("bkgd.png");
		ImageIcon pic = new ImageIcon(link);
		
	
	
	JTextField f=new JTextField("");
	f.setBounds(153, 48, 375, 76);
	contentPane.add(f);
	
	JButton btn1 = new JButton("1");
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"1");
		}
	});
	btn1.setBounds(163, 201, 89, 23);
	contentPane.add(btn1);
	
	JButton btn2 = new JButton("2");
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"2");
		}
	});
	btn2.setBounds(297, 201, 89, 23);
	contentPane.add(btn2);
	
	JButton btn3 = new JButton("3");
	btn3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"3");
		}
	});
	btn3.setBounds(431, 201, 89, 23);
	contentPane.add(btn3);
	
	JButton btn4 = new JButton("4");
	btn4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"4");
		}
	});
	btn4.setBounds(163, 254, 89, 23);
	contentPane.add(btn4);
	
	JButton btn5 = new JButton("5");
	btn5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"5");
		}
	});
	btn5.setBounds(297, 254, 89, 23);
	contentPane.add(btn5);
	
	JButton btn6 = new JButton("6");
	btn6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"6");
		}
	});
	btn6.setBounds(431, 254, 89, 23);
	contentPane.add(btn6);
	
	JButton btn7 = new JButton("7");
	btn7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"7");
		}
	});
	btn7.setBounds(163, 307, 89, 23);
	contentPane.add(btn7);
	
	JButton btn8 = new JButton("8");
	btn8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"8");
		}
	});
	btn8.setBounds(297, 307, 89, 23);
	contentPane.add(btn8);
	
	JButton btn9 = new JButton("9");
	btn9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"9");
		}
	});
	btn9.setBounds(431, 307, 89, 23);
	contentPane.add(btn9);
	
	JButton btn0 = new JButton("0");
	btn0.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setText(f.getText()+"0");
		}
	});
	btn0.setBounds(297, 360, 89, 23);
	contentPane.add(btn0);
	
	JButton enter=new JButton("ENTER");
	enter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			boolean works = checkValidNumber(f.getText());
			boolean flag=false;
			if(works) {
				 value = Double.parseDouble(f.getText());
				 if(state==false) {
					 if(value>a.getBalance()) {
						 JOptionPane.showMessageDialog(null,  "Amount greater than account balance, please try again later." );
						 f.setText("");
					 }
					 else { a.withdraw(value);
					
					 }
				 }
				 else { a.deposit(value);
				
				 }
				 flag=true;
			}
			else {
				JOptionPane.showMessageDialog(null,  "Invalid Value, Try again" );
				f.setText("");
			}
			
			if(flag) close();
			
			
		}
	});
	enter.setBounds(163, 405, 357, 46);
	contentPane.add(enter);
	frame3.getRootPane().setDefaultButton(enter);
	
	
	JLabel lblEnterAmount = new JLabel();
	if(state==false) lblEnterAmount.setText("Please enter the amount of money you want to withdraw "); 
	else lblEnterAmount.setText("Please enter the amount of money you want to deposit ");
	lblEnterAmount.setFont(new Font("Rockwell", Font.PLAIN, 17));
	lblEnterAmount.setBounds(62, 133, 466, 57);
	contentPane.add(lblEnterAmount);
	
		JLabel lb=new JLabel(pic);
		lb.setBounds(0,0,770,500);
		contentPane.add(lb);
	
	
	}

}
