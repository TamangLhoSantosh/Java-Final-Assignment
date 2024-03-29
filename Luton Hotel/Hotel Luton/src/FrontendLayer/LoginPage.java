package FrontendLayer;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BusinessLayer.BLLogin;
import Models.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage extends JInternalFrame {

	private static final long serialVersionUID = 2L;
	private static JTextField email;
	private static JPasswordField password;

	
	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 550, 300);
		
		JPanel panel1 = new JPanel();
		getContentPane().add(panel1, BorderLayout.SOUTH);
		
		JLabel not = new JLabel("Not Registered Yet???");
		panel1.add(not);
		
		JButton registerbtn = new JButton("Register Now");
		registerbtn.setFocusable(false);
		panel1.add(registerbtn);
		registerbtn.addActionListener(new ActionListener() {
			
			//opens register page
			public void actionPerformed(ActionEvent e) {
				Main.contentPane.removeAll();
				Main.contentPane.add(new RegisterPage()).setVisible(true);
			}
		});
		registerbtn.setBackground(Color.GREEN);
		
		JPanel panel2 = new JPanel();
		getContentPane().add(panel2, BorderLayout.NORTH);
		
		JLabel sign = new JLabel("Welcome To Hotel Luton");
		panel2.add(sign);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel emaillb = new JLabel("Email              :");
		emaillb.setBounds(80, 60, 94, 16);
		panel.add(emaillb);

		email = new JTextField();
		email.setBounds(250, 55, 185, 26);
		panel.add(email);
		email.setColumns(10);
		
		JLabel passwordlb = new JLabel("Password        :");
		passwordlb.setBounds(80, 100, 109, 16);
		panel.add(passwordlb);
		
		password = new JPasswordField();
		password.setBounds(250, 95, 185, 26);
		panel.add(password);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setFocusable(false);
		loginbtn.setBackground(Color.GREEN);
		loginbtn.setBounds(216, 142, 117, 29);
		loginbtn.addActionListener(new ActionListener() {
			
			//calls login method
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		panel.add(loginbtn);
		
	}
	
	/* 
	 * method that read data from form and sends to the models
	 * reads data from model to bl for validaation
	 * sends validated data to dl for comparing data with the information in database
	 */
	
	private static void login(){
		try {
			
			//creating and initializing new object
			Login log = new Login();
			log.setEmail(LoginPage.email.getText());
			log.setPassword(String.valueOf(password.getPassword()));

			//creating and initializing new object
			BLLogin blLogin = new BLLogin();
			blLogin.setLog(log);
			blLogin.login();
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
