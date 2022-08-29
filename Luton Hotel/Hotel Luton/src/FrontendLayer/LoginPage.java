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
	public static JTextField email;
	public static JPasswordField password;

	
	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setBackground(Color.CYAN);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 550, 300);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Not Registered Yet???");
		panel_2.add(lblNewLabel);
		
		JButton registerbtn = new JButton("Register Now");
		panel_2.add(registerbtn);
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.contentPane.removeAll();
				Main.contentPane.add(new RegisterPage()).setVisible(true);
			}
		});
		registerbtn.setBackground(Color.GREEN);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel sign = new JLabel("Welcome To Hotel Luton");
		panel_1.add(sign);
		
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
		
		JButton loginbtn_1 = new JButton("Login");
		loginbtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		loginbtn_1.setBackground(Color.GREEN);
		loginbtn_1.setBounds(216, 142, 117, 29);
		panel.add(loginbtn_1);
		
	}
	private static void Login(){
		try {
			Login log = new Login();
			log.setEmail(LoginPage.email.getText());
			log.setPassword(String.valueOf(password.getPassword()));
			BLLogin blLogin = new BLLogin();
			blLogin.ValidateLogin(log);
			blLogin.login(log);
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
