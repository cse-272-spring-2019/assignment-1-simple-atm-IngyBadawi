import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class MainView {

	private JFrame frame;
	private JTextField textField;
	Account a=new Account(10000);
	private static String card = "12345";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainView() {
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		URL link = MainView.class.getResource("bkgd.png");
		ImageIcon pic = new ImageIcon(link);
		
		JLabel lblEnterCardNumber = new JLabel("Please enter the card number");
		lblEnterCardNumber.setFont(new Font("Rockwell", Font.PLAIN, 27));
		lblEnterCardNumber.setBounds(62, 54, 427, 51);
		frame.getContentPane().add(lblEnterCardNumber);
		
		textField = new JTextField();
		textField.setBounds(62, 144, 310, 51);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		
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
		frame.getContentPane().add(exit);
		

		frame.getRootPane().setDefaultButton( btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				if(s.equals(card)) {
					frame.setVisible(false);
					
					LoggedIn frame2=new LoggedIn(a);
					frame2.setVisible(true);
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,  "Incorrect card number, please try again " );
					textField.setText("");
				}
			}
		});
		btnSubmit.setBounds(221, 294, 181, 61);
		frame.getContentPane().add(btnSubmit);
		
		JLabel label = new JLabel(pic);
		label.setBounds(0, 0, 684, 473);
		frame.getContentPane().add(label);
	}
}
