import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;



public class LoggedIn extends JFrame {
	private JFrame frame2=new JFrame();
	private JPanel contentPane;
	private boolean state=false;
	private JLabel lbl= new JLabel();
	boolean flag2=true;
	private JButton exit_1;
	
	
	

	boolean checkValidNumber(String s) {
		for(int i=0;i<s.length();i++) if(s.charAt(i)<'0' || s.charAt(i)>'9') return false; return true;
	}

	public LoggedIn(Account a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		URL link = LoggedIn.class.getResource("bkgd.png");
		ImageIcon pic = new ImageIcon(link);
	    
	    
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setText("");
				withdrawAndDeposit frame3=new withdrawAndDeposit(a,state);
				frame3.setVisible(true);
			}
		});
		lbl.setBounds(44, 65, 595, 92);
		contentPane.add(lbl);
		
			    lbl.setFont(new Font("Rockwell", Font.PLAIN, 20));
		btnWithdraw.setBounds(162, 187, 336, 46);
		contentPane.add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				state=true;
				lbl.setText("");
				withdrawAndDeposit frame3=new withdrawAndDeposit(a,state);
				state=false;
				frame3.setVisible(true);			
				}
		});
		btnDeposit.setBounds(162, 244, 336, 46);
		contentPane.add(btnDeposit);
		
		JButton btnBalInq= new JButton("Balance Inquiry");
		btnBalInq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setText("");
				a.balanceInquiry();
				lbl.setText("Your balance is now "+Double.toString(a.getBalance()));
			}
		});
		btnBalInq.setBounds(162, 301, 336, 46);
		contentPane.add(btnBalInq);
		
		JButton btnPrev= new JButton("Previous Transaction");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a.getHistory().size()==0||a.getPosition()==0) {
					flag2=false;
					JOptionPane.showMessageDialog(null, "There are no previous transactions");
				} 
				a.prevTransaction();
				Transaction element=new Transaction();
				if(flag2)
				{element=a.getHistory().get(a.getPosition());
				int test=investigateHistory(element);
				if(test==0) lbl.setText("You have withdrawn an amount of "+element.getAmount());
				if(test==1) lbl.setText("You have deposited an amount of "+element.getAmount());
				if(test==2) lbl.setText("You have inquired about your balance, it was "+element.getAmount());
				}
				flag2=true;
			}
		});
		btnPrev.setBounds(162,358 , 159, 46);
		contentPane.add(btnPrev);
		
		JButton btnNext= new JButton("Next Transaction");
		btnNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(a.getHistory().size()==0||a.getPosition()==a.getHistory().size()-1||a.getPosition()==4||a.getHistory().size()==5) {
					flag2=false;
					JOptionPane.showMessageDialog(null, "There are no next transactions");
				}
				a.nextTransaction();
				Transaction element=new Transaction();
				if(flag2)
				{element=a.getHistory().get(a.getPosition());
				int test=investigateHistory(element);
				if(test==0) lbl.setText("You have withdrawn an amount of "+element.getAmount());
				if(test==1) lbl.setText("You have deposited an amount of "+element.getAmount());
				if(test==2) lbl.setText("You have inquired about your balance, it was "+element.getAmount());
			}
				flag2=true;
			}
		});
		btnNext.setBounds(339, 358, 159, 46);
		contentPane.add(btnNext);
		
		JButton exit = new JButton();
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("resized.png")));
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.setBounds(515, 405, 159, 46);
		contentPane.add(exit);
		
		JLabel label = new JLabel(pic);
		label.setBounds(0, 0, 770, 500);
		contentPane.add(label);
	}
	
	
	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

	public int investigateHistory(Transaction t) {
		return t.getType();
	}
}
