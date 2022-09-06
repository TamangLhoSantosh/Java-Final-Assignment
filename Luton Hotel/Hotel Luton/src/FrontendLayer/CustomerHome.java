package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Font;
public class CustomerHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerHome frame = new CustomerHome();
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
	public CustomerHome() {
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
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);

		JButton home = new JButton("Home");
		home.setFocusable(false);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerHome home = new CustomerHome();
				home.setVisible(true);
				dispose();
			}
		});
		panel_2.add(home);
		
		JButton gallery = new JButton("Gallery");
		gallery.setFocusable(false);
		gallery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gallery galler = new Gallery();
				galler.setVisible(true);
				dispose();
			}
		});
		panel_2.add(gallery);
		
		JButton aboutUs = new JButton("About Us");
		aboutUs.setFocusable(false);
		aboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs abou = new AboutUs();
				abou.setVisible(true);
				dispose();
			}
		});
		panel_2.add(aboutUs);
		
		JButton contactUs = new JButton("Contact Us");
		contactUs.setFocusable(false);
		contactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ContactUs conU = new ContactUs();
			conU.setVisible(true);
			dispose();
			}
		});
		panel_2.add(contactUs);
		
		JButton profile = new JButton("Profile");
		profile.setFocusable(false);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile pof = new Profile();
				pof.setVisible(true);
				dispose();
			}
		});
		panel_2.add(profile);
		
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
		panel_2.add(logout);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/logo.jpeg"));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(logo);

		JScrollPane scroll = new JScrollPane();
		contentPane.add(scroll, BorderLayout.CENTER);
		
		
		JPanel center = new JPanel();
		FlowLayout flowLayout = (FlowLayout) center.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		scroll.setViewportView(center);
		
		JPanel box = new JPanel();
		center.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		JLabel pic = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/17.jpeg"));
		pic.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.add(pic);
		
		JPanel centre = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) centre.getLayout();
		flowLayout_1.setVgap(40);
		box.add(centre);
		
		JLabel welcome = new JLabel("Welcome To Hotel Luton");
		welcome.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		centre.add(welcome);
		
		
		JPanel center1 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) center1.getLayout();
		flowLayout1.setHgap(100);
		flowLayout1.setVgap(20);
		box.add(center1);
		
		JButton singleRoom = new JButton(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/11.jpeg"));
		singleRoom.setFocusable(false);
		center1.add(singleRoom);
		singleRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinglePage singlep = new SinglePage();
				singlep.setVisible(true);
				dispose();
			}
		});
		
		JButton doubleRoom = new JButton(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/3.jpeg"));
		doubleRoom.setFocusable(false);
		center1.add(doubleRoom);
		doubleRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoublePage doublep = new DoublePage();
				doublep.setVisible(true);
				dispose();
			}
		});
		
		JButton twinRoom = new JButton(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/8.jpeg"));
		twinRoom.setFocusable(false);
		center1.add(twinRoom);
		twinRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwinPage twin = new TwinPage();
				twin.setVisible(true);
				dispose();
			}
		});
		
		JPanel center2 = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) center2.getLayout();
		flowLayout2.setHgap(185);
		flowLayout2.setVgap(10);
		box.add(center2);
		
		JButton singleBtn = new JButton("Single Room");
		singleBtn.setFocusable(false);
		singleBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		singleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinglePage sng = new SinglePage();
				sng.setVisible(true);
				dispose();
			}
		});
		center2.add(singleBtn);
		
		JButton doubleBtn = new JButton("Double Room");
		doubleBtn.setFocusable(false);
		doubleBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		doubleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoublePage dou = new DoublePage();
				dou.setVisible(true);
				dispose();
			}
		});
		center2.add(doubleBtn);
		
		JButton twinBtn = new JButton("Twin Room");
		twinBtn.setFocusable(false);
		twinBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		twinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwinPage twi = new TwinPage();
				twi.setVisible(true);
				dispose();
			}
		});
		center2.add(twinBtn);
		
		JPanel center3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) center3.getLayout();
		flowLayout_2.setHgap(200);
		flowLayout_2.setVgap(50);
		box.add(center3);
				
		JButton bookNow = new JButton("BOOK NOW");
		bookNow.setFocusable(false);
		bookNow.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		bookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingPage bp = new BookingPage();
				bp.setVisible(true);
				dispose();
			}
		});
		center3.add(bookNow);
		
		JButton viewBooking = new JButton("View Bookings");
		viewBooking.setFocusable(false);
		viewBooking.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		viewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooking vb = new ViewBooking();
				vb.setVisible(true);
				dispose();
			}
		});
		center3.add(viewBooking);
		
		JButton cancel = new JButton("Cancel Booking");
		cancel.setFocusable(false);
		cancel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		center3.add(cancel);
	}
}
