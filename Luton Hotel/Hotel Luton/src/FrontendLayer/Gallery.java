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
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class Gallery extends JFrame {

	private static final long serialVersionUID = 2815684303146843264L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gallery frame = new Gallery();
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
	public Gallery() {
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
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		JPanel galleryPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) galleryPane.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		contentPane.add(galleryPane);

		JLabel single_1 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/1.jpeg"));
		galleryPane.add(single_1);

		JLabel single_2= new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/2.jpeg"));
		galleryPane.add(single_2);

		JLabel single_3 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/3.jpeg"));
		galleryPane.add(single_3);

		JLabel single_4 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/4.jpeg"));
		galleryPane.add(single_4);

		JLabel single_5 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/6.jpeg"));
		galleryPane.add(single_5);

		JLabel single_6 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/7.jpeg"));
		galleryPane.add(single_6);

		JLabel single_7 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/8.jpeg"));
		galleryPane.add(single_7);

		JLabel single_8 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/9.jpeg"));
		galleryPane.add(single_8);

		JLabel single_9 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/11.jpeg"));
		galleryPane.add(single_9);

		JLabel single_10 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/12.jpeg"));
		galleryPane.add(single_10);

		JLabel single_11 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/13.jpeg"));
		galleryPane.add(single_11);

		JLabel single_12 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/14.jpeg"));
		galleryPane.add(single_12);

		JLabel single_13 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/15.jpeg"));
		galleryPane.add(single_13);

		JLabel single_14 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/16.jpeg"));
		galleryPane.add(single_14);

		JLabel single_15 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/18.jpeg"));
		galleryPane.add(single_15);

		JLabel single_16 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/19.jpeg"));
		galleryPane.add(single_16);

		JLabel single_17 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/20.jpeg"));
		galleryPane.add(single_17);

		JLabel single_18 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/24.jpeg"));
		galleryPane.add(single_18);

		JLabel single_19 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/22.jpeg"));
		galleryPane.add(single_19);

		JLabel single_20 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/21.jpeg"));
		galleryPane.add(single_20);

		JLabel single_21 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/10.jpeg"));
		galleryPane.add(single_21);

		JLabel single_22 = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/5.jpeg"));
		galleryPane.add(single_22);
	}

}
