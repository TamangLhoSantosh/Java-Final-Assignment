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

import DatabaseLayer.DLLogin;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel3;
	private JPanel box1; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		validate();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel2 = new JPanel();
		panel.add(panel2, BorderLayout.EAST);

		JButton home = new JButton("Home");
		home.setFocusable(false);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerHome home = new CustomerHome();
				home.setVisible(true);
				dispose();
			}
		});
		panel2.add(home);
		
		JButton gallery = new JButton("Gallery");
		gallery.setFocusable(false);
		gallery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gallery galler = new Gallery();
				galler.setVisible(true);
				dispose();
			}
		});
		panel2.add(gallery);
		
		JButton aboutUs = new JButton("About Us");
		aboutUs.setFocusable(false);
		aboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs abou = new AboutUs();
				abou.setVisible(true);
				dispose();
			}
		});
		panel2.add(aboutUs);
		
		JButton contactUs = new JButton("Contact Us");
		contactUs.setFocusable(false);
		contactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ContactUs conU = new ContactUs();
			conU.setVisible(true);
			dispose();
			}
		});
		panel2.add(contactUs);
		
		JButton profile = new JButton("Profile");
		profile.setFocusable(false);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile pof = new Profile();
				pof.setVisible(true);
				dispose();
			}
		});
		panel2.add(profile);
		
		JButton logout = new JButton("Log Out");
		logout.setFocusable(false);
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
		panel2.add(logout);
		
		JPanel panel1 = new JPanel();
		panel.add(panel1, BorderLayout.WEST);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/logo.jpeg"));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(logo);

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout(0, 0));
		contentPane.add(center, BorderLayout.CENTER);
		
		JPanel pageName = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pageName.getLayout();
		flowLayout.setVgap(20);
		center.add(pageName, BorderLayout.NORTH);
		
		JLabel user = new JLabel("User Profile");
		user.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		pageName.add(user);
		
		panel3 = new JPanel();
		FlowLayout fl_panel3 = (FlowLayout) panel3.getLayout();
		fl_panel3.setHgap(40);
		center.add(panel3, BorderLayout.CENTER);
		
		box1 = new JPanel();
		box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
		panel3.add(box1);
		
		validateUser();
		
	}

	public void validateUser() {
		
		if(DLLogin.ccid == 0) {
			JLabel namelb = new JLabel("Name");
			namelb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(namelb);
			
			JPanel empty1 = new JPanel();
			FlowLayout flowLayout1 = (FlowLayout) empty1.getLayout();
			flowLayout1.setVgap(10);
			box1.add(empty1);
			
			JLabel dateoblb = new JLabel("Date Of Birth");
			dateoblb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(dateoblb);

			JPanel empty2 = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) empty2.getLayout();
			flowLayout2.setVgap(10);
			box1.add(empty2);
			
			JLabel contactlb = new JLabel("Contact No");
			contactlb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(contactlb);

			JPanel empty3 = new JPanel();
			FlowLayout flowLayout3 = (FlowLayout) empty3.getLayout();
			flowLayout3.setVgap(10);
			box1.add(empty3);
			
			JLabel addresslb = new JLabel("Address");
			addresslb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(addresslb);

			JPanel empty4 = new JPanel();
			FlowLayout flowLayout4 = (FlowLayout) empty4.getLayout();
			flowLayout4.setVgap(10);
			box1.add(empty4);
			
			JLabel postalb = new JLabel("Postal Code");
			postalb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(postalb);

			JPanel empty5 = new JPanel();
			FlowLayout flowLayout5 = (FlowLayout) empty5.getLayout();
			flowLayout5.setVgap(10);
			box1.add(empty5);
			
			JLabel creditlb = new JLabel("Credit Card No");
			creditlb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(creditlb);

			JPanel empty6 = new JPanel();
			FlowLayout flowLayout6 = (FlowLayout) empty6.getLayout();
			flowLayout6.setVgap(10);
			box1.add(empty6);
			
			JLabel explb = new JLabel("Expiry Date");
			explb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(explb);

			JPanel empty7 = new JPanel();
			FlowLayout flowLayout7 = (FlowLayout) empty7.getLayout();
			flowLayout7.setVgap(10);
			box1.add(empty7);
			
			JPanel box2 = new JPanel();
			box2.setLayout(new BoxLayout(box2, BoxLayout.Y_AXIS));
			panel3.add(box2);
			
			JLabel name = new JLabel(DLLogin.fullName);
			name.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(name);

			JPanel empty8 = new JPanel();
			FlowLayout flowLayout8 = (FlowLayout) empty8.getLayout();
			flowLayout8.setVgap(10);
			box2.add(empty8);
			
			JLabel dateob = new JLabel(DLLogin.dateOB);
			dateob.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(dateob);

			JPanel empty9 = new JPanel();
			FlowLayout flowLayout9 = (FlowLayout) empty9.getLayout();
			flowLayout9.setVgap(10);
			box2.add(empty9);
			
			JLabel contact =new JLabel(DLLogin.contact);
			contact.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(contact);

			JPanel empty10 = new JPanel();
			FlowLayout flowLayout10 = (FlowLayout) empty10.getLayout();
			flowLayout10.setVgap(10);
			box2.add(empty10);
			
			JLabel address = new JLabel(DLLogin.address);
			address.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(address);

			JPanel empty11 = new JPanel();
			FlowLayout flowLayout11 = (FlowLayout) empty11.getLayout();
			flowLayout11.setVgap(10);
			box2.add(empty11);
			
			JLabel postal = new JLabel(DLLogin.pcode);
			postal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(postal);

			JPanel empty12 = new JPanel();
			FlowLayout flowLayout12 = (FlowLayout) empty12.getLayout();
			flowLayout12.setVgap(10);
			box2.add(empty12);
			
			JLabel credit = new JLabel(DLLogin.creditc);
			credit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(credit);

			JPanel empty13 = new JPanel();
			FlowLayout flowLayout13 = (FlowLayout) empty13.getLayout();
			flowLayout13.setVgap(10);
			box2.add(empty13);
			
			JLabel exp = new JLabel(DLLogin.exDate);
			exp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(exp);

			JPanel empty14 = new JPanel();
			FlowLayout flowLayout14 = (FlowLayout) empty14.getLayout();
			flowLayout14.setVgap(10);
			box2.add(empty14);
			
		}
		else {
			JLabel namelb = new JLabel("Registration No");
			namelb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(namelb);
			
			JPanel empty1 = new JPanel();
			FlowLayout flowLayout1 = (FlowLayout) empty1.getLayout();
			flowLayout1.setVgap(10);
			box1.add(empty1);
			
			JLabel dateoblb = new JLabel("Company Name");
			dateoblb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(dateoblb);

			JPanel empty2 = new JPanel();
			FlowLayout flowLayout2 = (FlowLayout) empty2.getLayout();
			flowLayout2.setVgap(10);
			box1.add(empty2);
			
			JLabel contactlb = new JLabel("Contact No");
			contactlb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(contactlb);

			JPanel empty3 = new JPanel();
			FlowLayout flowLayout3 = (FlowLayout) empty3.getLayout();
			flowLayout3.setVgap(10);
			box1.add(empty3);
			
			JLabel addresslb = new JLabel("Address");
			addresslb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(addresslb);

			JPanel empty4 = new JPanel();
			FlowLayout flowLayout4 = (FlowLayout) empty4.getLayout();
			flowLayout4.setVgap(10);
			box1.add(empty4);
			
			JLabel postalb = new JLabel("Dicount Discount");
			postalb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(postalb);

			JPanel empty5 = new JPanel();
			FlowLayout flowLayout5 = (FlowLayout) empty5.getLayout();
			flowLayout5.setVgap(10);
			box1.add(empty5);
			
			JLabel creditlb = new JLabel("Valid Till");
			creditlb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box1.add(creditlb);

			JPanel empty6 = new JPanel();
			FlowLayout flowLayout6 = (FlowLayout) empty6.getLayout();
			flowLayout6.setVgap(10);
			box1.add(empty6);
			
			JPanel box2 = new JPanel();
			box2.setLayout(new BoxLayout(box2, BoxLayout.Y_AXIS));
			panel3.add(box2);
			
			JLabel name = new JLabel(Integer.toString(DLLogin.regNo));
			name.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(name);

			JPanel empty8 = new JPanel();
			FlowLayout flowLayout8 = (FlowLayout) empty8.getLayout();
			flowLayout8.setVgap(10);
			box2.add(empty8);
			
			JLabel dateob = new JLabel(DLLogin.compName);
			dateob.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(dateob);

			JPanel empty9 = new JPanel();
			FlowLayout flowLayout9 = (FlowLayout) empty9.getLayout();
			flowLayout9.setVgap(10);
			box2.add(empty9);
			
			JLabel contact =new JLabel(DLLogin.contact);
			contact.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(contact);

			JPanel empty10 = new JPanel();
			FlowLayout flowLayout10 = (FlowLayout) empty10.getLayout();
			flowLayout10.setVgap(10);
			box2.add(empty10);
			
			JLabel address = new JLabel(DLLogin.address);
			address.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(address);

			JPanel empty11 = new JPanel();
			FlowLayout flowLayout11 = (FlowLayout) empty11.getLayout();
			flowLayout11.setVgap(10);
			box2.add(empty11);
			
			JLabel postal = new JLabel(Integer.toString(DLLogin.discountd));
			postal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(postal);

			JPanel empty12 = new JPanel();
			FlowLayout flowLayout12 = (FlowLayout) empty12.getLayout();
			flowLayout12.setVgap(10);
			box2.add(empty12);
			
			JLabel credit = new JLabel(DLLogin.discounty);
			credit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			box2.add(credit);

			JPanel empty13 = new JPanel();
			FlowLayout flowLayout13 = (FlowLayout) empty13.getLayout();
			flowLayout13.setVgap(10);
			box2.add(empty13);
					}
	}
}
