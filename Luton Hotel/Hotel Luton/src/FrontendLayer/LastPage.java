package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LastPage extends JFrame {

	private static final long serialVersionUID = -7220655015178383598L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LastPage frame = new LastPage();
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
	public LastPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 510, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel center = new JPanel();
		center.setBounds(0, 0, 510, 360);
		panel.add(center);
		center.setLayout(null);
		
		JLabel message1 = new JLabel("Thank You For");
		message1.setBounds(180, 75, 139, 25);
		center.add(message1);
		message1.setBackground(new Color(51, 51, 255));
		message1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
				JLabel message2 = new JLabel("Chosing");
				message2.setBounds(210, 115, 78, 25);
				center.add(message2);
				message2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				
		JLabel message3 = new JLabel("Hotel Luton");
		message3.setBounds(190, 155, 111, 25);
		center.add(message3);
		message3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton home = new JButton("Go To Home");
		home.setBackground(Color.WHITE);
		home.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		home.setBounds(170, 230, 150, 29);
		center.add(home);
		
		JLabel pic = new JLabel(new ImageIcon("/Users/xic/Desktop/Java Final Assignment/Luton Hotel/Hotel Luton/bin/Background.jpeg"));
		pic.setBounds(5, 5, 488, 315);
		center.add(pic);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//opening nest page
				CustomerHome homep = new CustomerHome();
				homep.setVisible(true);
				dispose();
			}
		});
	}

}
