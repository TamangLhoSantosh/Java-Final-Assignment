package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CorporateRegister extends JInternalFrame {

	private static final long serialVersionUID = 4L;
	private JTextField registrationNoText;
	private JTextField companyNameText;
	private JTextField contactText;
	private JTextField addressText;
	private JTextField discountDiscussedText;
	private JTextField discountYearText;
	private JTextField emailText;
	private JPasswordField passwordText;
	private JPasswordField confirmPasswordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorporateRegister frame = new CorporateRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CorporateRegister() {
		setClosable(true);
		setBounds(100, 100, 550, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel corporarteRegister = new JLabel("Corporate Registeration");
		panel.add(corporarteRegister);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel registrationNo = new JLabel("Registration No              :");
		registrationNo.setBounds(80, 20, 172, 16);
		panel_1.add(registrationNo);
		
		JLabel contact = new JLabel("Contact                           :");
		contact.setBounds(80, 110, 172, 16);
		panel_1.add(contact);
		
		JLabel discountDiscussed = new JLabel("Discount Discussed        :");
		discountDiscussed.setBounds(80, 155, 162, 16);
		panel_1.add(discountDiscussed);
		
		JLabel companyName = new JLabel("Company Name              :");
		companyName.setBounds(80, 65, 172, 16);
		panel_1.add(companyName);
		
		JLabel address = new JLabel("Address                           :");
		address.setBounds(80, 200, 172, 16);
		panel_1.add(address);
		
		JLabel discountYear = new JLabel("Discount Year                 :");
		discountYear.setBounds(80, 245, 172, 16);
		panel_1.add(discountYear);
		
		JLabel email = new JLabel("Email                              :");
		email.setBounds(80, 290, 172, 16);
		panel_1.add(email);
		
		JLabel password = new JLabel("Password                       :");
		password.setBounds(80, 335, 172, 16);
		panel_1.add(password);
		
		JLabel confirmPassword = new JLabel("Confirm Password          :");
		confirmPassword.setBounds(80, 380, 172, 16);
		panel_1.add(confirmPassword);
		
		registrationNoText = new JTextField();
		registrationNoText.setBounds(250, 240, 185, 26);
		panel_1.add(registrationNoText);
		registrationNoText.setColumns(10);
		
		companyNameText = new JTextField();
		companyNameText.setBounds(250, 150, 185, 26);
		panel_1.add(companyNameText);
		companyNameText.setColumns(10);
		
		contactText = new JTextField();
		contactText.setBounds(250, 15, 185, 26);
		panel_1.add(contactText);
		contactText.setColumns(10);
		
		addressText = new JTextField();
		addressText.setBounds(250, 195, 185, 26);
		panel_1.add(addressText);
		addressText.setColumns(10);
		
		discountDiscussedText = new JTextField();
		discountDiscussedText.setBounds(250, 60, 185, 26);
		panel_1.add(discountDiscussedText);
		discountDiscussedText.setColumns(10);
		
		discountYearText = new JTextField();
		discountYearText.setBounds(250, 100, 185, 26);
		panel_1.add(discountYearText);
		discountYearText.setColumns(10);
		
		emailText = new JTextField();
		emailText.setBounds(250, 285, 185, 26);
		panel_1.add(emailText);
		emailText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(250, 375, 185, 26);
		panel_1.add(passwordText);
		
		confirmPasswordText = new JPasswordField();
		confirmPasswordText.setBounds(250, 330, 185, 26);
		panel_1.add(confirmPasswordText);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		register.setBounds(216, 410, 117, 29);
		panel_1.add(register);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Register As Individual");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.contentPane.removeAll();
				Main.contentPane.add(new RegisterPage()).setVisible(true);
			}
		});
		panel_2.add(btnNewButton);
		
	}
}
