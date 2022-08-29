package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterPage extends JInternalFrame {

	private static final long serialVersionUID = 3L;
	private JTextField fName;
	private JTextField lName;
	private JTextField dateOfBirth;
	private JTextField contact;
	private JTextField address;
	private JTextField postaCode;
	private JTextField creditCard;
	private JTextField expiryDate;
	private JTextField email;
	private JPasswordField confirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setClosable(true);
		setBounds(150,150, 550, 450);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel individuallregisterlabel = new JLabel("Individual Registration");
		panel_1.add(individuallregisterlabel);
		individuallregisterlabel.setBackground(Color.WHITE);
				
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.white);
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Register As Corporate");
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.contentPane.removeAll();
				Main.contentPane.add(new CorporateRegister()).setVisible(true);
			}
		});
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel fNLabel = new JLabel("First Name");
		fNLabel.setBounds(10, 25, 68, 16);
		panel.add(fNLabel);
		
		fName = new JTextField();
		fName.setBounds(100, 20, 130, 26);
		panel.add(fName);
		fName.setColumns(10);
		
		JLabel lNLabel = new JLabel("Last Name");
		lNLabel.setBounds(270, 25, 66, 16);
		panel.add(lNLabel);
		
		lName = new JTextField();
		lName.setBounds(366, 20, 130, 26);
		panel.add(lName);
		lName.setColumns(10);
		
		JLabel dobLabel = new JLabel("Date Of Birth");
		dobLabel.setBounds(10, 70, 81, 16);
		panel.add(dobLabel);
		
		dateOfBirth = new JTextField();
		dateOfBirth.setBounds(100, 65, 130, 26);
		panel.add(dateOfBirth);
		dateOfBirth.setColumns(10);
		
		JLabel contactLabel = new JLabel("Contact No");
		contactLabel.setBounds(270, 70, 81, 16);
		panel.add(contactLabel);
		
		contact = new JTextField();
		contact.setBounds(366, 65, 130, 26);
		panel.add(contact);
		contact.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 115, 51, 16);
		panel.add(addressLabel);
		
		address = new JTextField();
		address.setBounds(100, 110, 130, 26);
		panel.add(address);
		address.setColumns(10);
		
		JLabel postalCodeLabel = new JLabel("Postal Code");
		postalCodeLabel.setBounds(270, 115, 81, 16);
		panel.add(postalCodeLabel);
		
		postaCode = new JTextField();
		postaCode.setBounds(366, 110, 130, 26);
		panel.add(postaCode);
		postaCode.setColumns(10);
		
		JLabel creditCardLabel = new JLabel("Credit Card");
		creditCardLabel.setBounds(10, 160, 71, 16);
		panel.add(creditCardLabel);
		
		creditCard = new JTextField();
		creditCard.setBounds(100, 155, 130, 26);
		panel.add(creditCard);
		creditCard.setColumns(10);
		
		JLabel expiryDateLabel = new JLabel("Expiry Date");
		expiryDateLabel.setBounds(270, 160, 81, 16);
		panel.add(expiryDateLabel);
		
		expiryDate = new JTextField();
		expiryDate.setBounds(366, 155, 130, 26);
		panel.add(expiryDate);
		expiryDate.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 205, 34, 16);
		panel.add(emailLabel);
		
		email = new JTextField();
		email.setBounds(100, 200, 130, 26);
		panel.add(email);
		email.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 250, 61, 16);
		panel.add(passwordLabel);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setBounds(249, 250, 114, 16);
		panel.add(confirmPasswordLabel);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(100, 245, 130, 26);
		panel.add(password);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(366, 245, 130, 26);
		panel.add(confirmPassword);
		
		JButton registerbtn = new JButton("Register");
		registerbtn.setBounds(215, 290, 95, 29);
		panel.add(registerbtn);
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
}
