package FrontendLayer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class SinglePage extends JFrame {

	private static final long serialVersionUID = 7678301654897951910L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglePage frame = new SinglePage();
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
	public SinglePage() {
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
		panel_2.add(logout);
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

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		
		JLabel logo = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/logo.jpeg"));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(logo);

		JScrollPane scroll = new JScrollPane();
		contentPane.add(scroll, BorderLayout.CENTER);
		
		JPanel center = new JPanel();
		scroll.setViewportView(center);
		
		JPanel box = new JPanel();
		center.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		JPanel panl = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panl.getLayout();
		flowLayout_2.setVgap(20);
		box.add(panl);
		
		JLabel name = new JLabel("Single Room");
		name.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		panl.add(name);
		
		JPanel panel1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel1.getLayout();
		flowLayout_1.setVgap(20);
		flowLayout_1.setHgap(40);
		box.add(panel1);

		JLabel pic1 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/1.jpeg"));
		panel1.add(pic1);

		JLabel pic2 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/11.jpeg"));
		panel1.add(pic2);

		JLabel pic3 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/28.jpeg"));
		panel1.add(pic3);

		JLabel pic4 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/10.jpeg"));
		panel1.add(pic4);
		
		JPanel pan = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pan.getLayout();
		flowLayout.setVgap(20);
		box.add(pan);
		
		JLabel single = new JLabel("Room Features");
		single.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		pan.add(single);
		
		JPanel panel2 = new JPanel();
		box.add(panel2);

		JLabel bedding = new JLabel();
		bedding.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bedding.setText("Bed Max Occupancy : 1");
		panel2.add(bedding);
		
		JLabel empty = new JLabel(" ");
		box.add(empty);

		JPanel panel3 = new JPanel();
		box.add(panel3);
		
		JLabel bathroom = new JLabel();
		bathroom.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		bathroom.setText("Marble Bathroom With Lighted Makeup Mirror, Rob and Slippers");
		panel3.add(bathroom);
		
		JLabel empty1 = new JLabel(" ");
		box.add(empty1);

		JPanel panel4 = new JPanel();
		box.add(panel4);
		
		JLabel furniture = new JLabel();
		furniture.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		furniture.setText("A Room Contains Sofa, Chair, Mini-refrigerator Table and Alarm Clock");
		panel4.add(furniture);
		
		JLabel empty2 = new JLabel(" ");
		box.add(empty2);

		JPanel panel5 = new JPanel();
		box.add(panel5);
		
		JLabel tv = new JLabel();
		tv.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		tv.setText("TV features: Remote control, 42in/107cm, and LED screen");
		panel5.add(tv);
		
		JLabel empty3 = new JLabel(" ");
		box.add(empty3);

		JPanel panel6 = new JPanel();
		box.add(panel6);
		
		JLabel telephone = new JLabel();
		telephone.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		telephone.setText("Telephone With Outside Line Connection");
		panel6.add(telephone);
		
		JLabel empty4 = new JLabel(" ");
		box.add(empty4);

		JPanel panel7 = new JPanel();
		box.add(panel7);
		
		JLabel roomFeatures = new JLabel();
		roomFeatures.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		roomFeatures.setText("Room Features: 18sqm/245sq, Air-conditioned, and SoundProof");
		panel7.add(roomFeatures);
		
		JLabel empty5 = new JLabel(" ");
		box.add(empty5);

		JPanel panel8 = new JPanel();
		box.add(panel8);
		
		JLabel wifi = new JLabel();
		wifi.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		wifi.setText("High Speed Internet Connection");
		panel8.add(wifi);

		JLabel empty6 = new JLabel(" ");
		box.add(empty6);

		JPanel panel9 = new JPanel();
		box.add(panel9);
		
		JLabel rate = new JLabel();
		rate.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		rate.setText("USD 30 Per Night");
		panel9.add(rate);
		

		JPanel center3 = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) center3.getLayout();
		flowLayout2.setHgap(200);
		flowLayout2.setVgap(50);
		box.add(center3);
				
		JButton bookNow = new JButton("BOOK NOW");
		bookNow.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		bookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingleBooking sb = new SingleBooking();
				sb.setVisible(true);
				dispose();
			}
		});
		center3.add(bookNow);
		
		JButton viewBooking = new JButton("View Bookings");
		viewBooking.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		viewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		center3.add(viewBooking);
		
		JButton cancel = new JButton("Cancel Booking");
		cancel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		center3.add(cancel);
	}

}
