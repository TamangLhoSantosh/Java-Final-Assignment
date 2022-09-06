package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextArea;

public class ContactUs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUs frame = new ContactUs();
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
	public ContactUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		validate();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/logo.jpeg"));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(logo);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerHome home = new CustomerHome();
				home.setVisible(true);
				dispose();
			}
		});
		panel_2.add(home);
		
		JButton gallery = new JButton("Gallery");
		gallery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gallery galler = new Gallery();
				galler.setVisible(true);
				dispose();
			}
		});
		panel_2.add(gallery);
		
		JButton aboutUs = new JButton("About Us");
		panel_2.add(aboutUs);
		aboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs abou = new AboutUs();
				abou.setVisible(true);
				dispose();
			}
		});
		
		JButton contactUs = new JButton("Contact Us");
		panel_2.add(contactUs);
		contactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ContactUs conU = new ContactUs();
			conU.setVisible(true);
			dispose();
			}
		});
		
		JButton profile = new JButton("Profile");
		panel_2.add(profile);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile pof = new Profile();
				pof.setVisible(true);
				dispose();
			}
		});
		
		JButton logout = new JButton("Log Out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(logout, "Are You Sure You Want To Log Out???", "LOGOUT",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					Main window = new Main();
					window.setVisible(true);
					dispose();
					
				}
			}
		});
		panel_2.add(logout);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JLabel contact = new JLabel("Contact Us");
		contact.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contact.setBounds(275, 70, 105, 25);
		panel_3.add(contact);
		
		JTextArea message = new JTextArea();
		message.setBounds(25, 170, 347, 246);
		panel_3.add(message);
		
		JLabel sendMessage = new JLabel("Send Us Your FeedBack");
		sendMessage.setBounds(25, 135, 150, 16);
		panel_3.add(sendMessage);
		
		JButton send = new JButton("Send");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(send, "Do You Want To Continue?","Send",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					CustomerHome home = new CustomerHome();
					home.setVisible(true);
					dispose();
					JOptionPane.showMessageDialog(null, "       Feedback received \nThank You For Your FeedBack");
				}
			}
		});
		send.setBounds(119, 428, 117, 29);
		panel_3.add(send);
		
		JLabel email = new JLabel("xyz@gmail.com");
		email.setBounds(470, 170, 100, 16);
		panel_3.add(email);
		
		JLabel orgEmail = new JLabel("xyz@gmail.org");
		orgEmail.setBounds(470, 220, 100, 16);
		panel_3.add(orgEmail);
		
		JLabel contactNo = new JLabel("+123 1234567890");
		contactNo.setBounds(470, 270, 125, 16);
		panel_3.add(contactNo);
		
		JLabel lblNewLabel = new JLabel("ABX, Luton");
		lblNewLabel.setBounds(470, 320, 75, 16);
		panel_3.add(lblNewLabel);
	}
}
