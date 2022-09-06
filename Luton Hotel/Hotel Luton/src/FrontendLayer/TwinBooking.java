package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLayer.BLBooking;
import Models.Booking;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TwinBooking extends JFrame {

	private static final long serialVersionUID = 1569830586242158904L;
	private JPanel contentPane;
	private static JTextField arrivalDate;
	private static JTextField departureDate;
	private static JRadioButton single;
	private static JRadioButton doub;
	private static JRadioButton twin;
	private String roomType;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwinBooking frame = new TwinBooking();
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
	public TwinBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel box = new JPanel();
		panel.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		JPanel book = new JPanel();
		box.add(book);
		
		JLabel bookRoom = new JLabel();
		bookRoom.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		bookRoom.setText("Book A Room Now");
		book.add(bookRoom);
		
		JPanel empty4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) empty4.getLayout();
		flowLayout_2.setVgap(10);
		box.add(empty4);
		
		JPanel arrival = new JPanel();
		box.add(arrival);
		arrival.setLayout(new BorderLayout(0, 0));
		
		JLabel arrivalDatelb = new JLabel("Arrival Date");
		arrivalDatelb.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		arrival.add(arrivalDatelb, BorderLayout.WEST);
		
		JPanel empty1 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) empty1.getLayout();
		flowLayout1.setHgap(0);
		arrival.add(empty1);
		
		arrivalDate = new JTextField();
		arrivalDate.setColumns(15);
		arrival.add(arrivalDate, BorderLayout.EAST);
		
		JPanel empty = new JPanel();
		FlowLayout flowLayout = (FlowLayout) empty.getLayout();
		flowLayout.setVgap(10);
		box.add(empty);

		JPanel departure = new JPanel();
		box.add(departure);
		departure.setLayout(new BorderLayout(0, 0));
		
		JLabel departureDatelb = new JLabel("Departure Date");
		departureDatelb.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		departure.add(departureDatelb, BorderLayout.WEST);
		
		JPanel empty2 = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) empty2.getLayout();
		flowLayout2.setHgap(0);
		departure.add(empty2);;
		
		departureDate = new JTextField();
		departureDate.setColumns(15);
		departure.add(departureDate, BorderLayout.EAST);
		
		JPanel empty3 = new JPanel();;
		FlowLayout flowLayout3 = (FlowLayout) empty3.getLayout();
		flowLayout3.setVgap(10);
		box.add(empty3);

		JPanel center = new JPanel();
		box.add(center);
		
		JLabel roomPreference = new JLabel();
		roomPreference.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		roomPreference.setText("Room Preference");
		center.add(roomPreference);
		
		JPanel check = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) check.getLayout();
		flowLayout_1.setVgap(10);
		box.add(check);
		
		single = new JRadioButton("Single Room");
		single.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		check.add(single);
		
		doub = new JRadioButton("Double Room");
		doub.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		check.add(doub);
		
		twin = new JRadioButton("Twin Room");
		twin.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		twin.setSelected(true);
		check.add(twin);
		
		ButtonGroup radio= new ButtonGroup();
		radio.add(single);
		radio.add(doub);
		radio.add(twin);
		
		JPanel empty5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) empty5.getLayout();
		flowLayout_3.setVgap(10);
		box.add(empty5);
		
		JPanel btn = new JPanel();
		box.add(btn);
		
		JButton bookr = new JButton("Book");
		bookr.setFocusable(false);
		bookr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booking();
			}
		});
		bookr.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btn.add(bookr);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFocusable(false);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerHome home = new CustomerHome();
				home.setVisible(true);
				dispose();
			}
		});
		cancel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btn.add(cancel);
		
	}
	/*
	 * method reads the data from the form
	 * sends to bl for validation
	 * sends to bl for insertion
	 */
	private void booking() {
		try {

			if(single.isSelected()) {
				roomType = "Single Room";
			}
			else if(doub.isSelected()) {
				roomType = "Double Room";
			}
			else if(twin.isSelected()) {
				roomType = "Twin Room";
			}
			//creating and initializing new object
			Booking book = new Booking();
			book.setArrivalDate(arrivalDate.getText());
			book.setDepartureDate(departureDate.getText());
			book.setRoomType(roomType);
			
			//creating and initializing new object
			BLBooking blBook = new BLBooking();
			blBook.setBook(book);
			blBook.book();
			dispose();
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

}
