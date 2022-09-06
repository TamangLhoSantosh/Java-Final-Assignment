package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import BusinessLayer.BLCorporateCust;
import BusinessLayer.BLLogin;
import Models.CorporateCustomer;
import Models.Login;

import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CorporateRegister extends JInternalFrame {

	//declaring variables
	private static final long serialVersionUID = 4L;
	private static JTextField discountYear;
	private static JTextField address;
	private static JTextField registrationNo;
	private static JTextField discountDiscussed;
	private static JTextField companyName;
	private static JTextField contact;
	private static JTextField email;
	private static JPasswordField confirmPassword;
	private static JPasswordField password;

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
		
		JLabel registrationNolb = new JLabel("Registration No              :");
		registrationNolb.setBounds(80, 20, 172, 16);
		panel_1.add(registrationNolb);
		
		JLabel contactlb = new JLabel("Contact                           :");
		contactlb.setBounds(80, 110, 172, 16);
		panel_1.add(contactlb);
		
		JLabel discountDiscussedlb = new JLabel("Discount Discussed        :");
		discountDiscussedlb.setBounds(80, 200, 162, 16);
		panel_1.add(discountDiscussedlb);
		
		JLabel companyNamelb = new JLabel("Company Name              :");
		companyNamelb.setBounds(80, 65, 172, 16);
		panel_1.add(companyNamelb);
		
		JLabel addresslb = new JLabel("Address                           :");
		addresslb.setBounds(80, 155, 172, 16);
		panel_1.add(addresslb);
		
		JLabel discountYearlb = new JLabel("Discount Year                 :");
		discountYearlb.setBounds(80, 245, 172, 16);
		panel_1.add(discountYearlb);
		
		JLabel emaillb = new JLabel("Email                              :");
		emaillb.setBounds(80, 290, 172, 16);
		panel_1.add(emaillb);
		
		JLabel passwordlb = new JLabel("Password                       :");
		passwordlb.setBounds(80, 335, 172, 16);
		panel_1.add(passwordlb);
		
		JLabel confirmPasswordlb = new JLabel("Confirm Password          :");
		confirmPasswordlb.setBounds(80, 380, 172, 16);
		panel_1.add(confirmPasswordlb);
		
		registrationNo = new JTextField();
		registrationNo.setBounds(250, 15, 185, 26);
		panel_1.add(registrationNo);
		registrationNo.setColumns(10);
		
		discountYear = new JTextField();
		discountYear.setBounds(250, 240, 185, 26);
		panel_1.add(discountYear);
		discountYear.setColumns(10);
		
		address = new JTextField();
		address.setBounds(250, 150, 185, 26);
		panel_1.add(address);
		address.setColumns(10);
		
		discountDiscussed = new JTextField();
		discountDiscussed.setBounds(250, 195, 185, 26);
		panel_1.add(discountDiscussed);
		discountDiscussed.setColumns(10);
		
		companyName = new JTextField();
		companyName.setBounds(250, 60, 185, 26);
		panel_1.add(companyName);
		companyName.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(250, 100, 185, 26);
		panel_1.add(contact);
		contact.setColumns(10);
		
		email = new JTextField();
		email.setBounds(250, 285, 185, 26);
		panel_1.add(email);
		email.setColumns(10);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(250, 375, 185, 26);
		panel_1.add(confirmPassword);
		
		password = new JPasswordField();
		password.setBounds(250, 330, 185, 26);
		panel_1.add(password);
		
		JButton register = new JButton("Register");
		register.setFocusable(false);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//invokes the register method
				register();
			}
		});
		register.setBounds(216, 420, 117, 29);
		panel_1.add(register);
		
		JButton already = new JButton("Already Have An Account??? Login Now");
		already.setFocusable(false);
		already.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//opens login page
				Main.contentPane.removeAll();
				Main.contentPane.add(new LoginPage()).setVisible(true);
			}
		});
		already.setBounds(135, 454, 270, 29);
		panel_1.add(already);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton regasin = new JButton("Register As Individual");
		regasin.setFocusable(false);
		regasin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//open registerpage
				Main.contentPane.removeAll();
				Main.contentPane.add(new RegisterPage()).setVisible(true);
			}
		});
		panel_2.add(regasin);	
	}
	
	/*
	 * reads data entered
	 * sends to bl for validation
	 * sends to bl for insertion
	 */
	private static void register() {
		try {
			
			//creating and initializing new object
			CorporateCustomer ccus = new CorporateCustomer();
			int no = Integer.parseInt(registrationNo.getText());
			ccus.setRegistrationNo(no);
			ccus.setCompanyName(CorporateRegister.companyName.getText());
			ccus.setContact(CorporateRegister.contact.getText());
			ccus.setAddress(CorporateRegister.address.getText());
			ccus.setDiscountDiscussed(Integer.parseInt(discountDiscussed.getText()));
			ccus.setDiscountYear(CorporateRegister.discountYear.getText());
			
			//creating and initializing new object
			Login log = new Login();
			log.setEmail(email.getText());
			log.setPassword(String.valueOf(password.getPassword()));
			String conPass = String.valueOf(confirmPassword.getPassword());
			
			//creating link with bl
			BLCorporateCust corporatec = new BLCorporateCust();
			BLLogin blLogin = new BLLogin();

			//validating data entered
			corporatec.setCorporateCust(ccus);
			blLogin.registerValidation(log, conPass);
			
			//sending data for insertion
			blLogin.register();
			corporatec.register();
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
