package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/logo.jpeg"));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(logo);
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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
	}
}
