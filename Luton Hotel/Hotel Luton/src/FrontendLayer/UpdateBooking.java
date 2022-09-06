package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLayer.BLBooking;
import Models.Booking;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateBooking extends JFrame {

	private static final long serialVersionUID = 3457623487757272771L;
	private JPanel contentPane;
	private JTextField arrivalDate;
	private JTextField departureDate;
	private JTextField roomType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBooking frame = new UpdateBooking();
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
	public UpdateBooking() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JPanel box = new JPanel();
		panel.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		JPanel center = new JPanel();
		box.add(center);
		
		JPanel box1 = new JPanel();
		center.add(box1);
		box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
		
		JLabel arrivaldlb = new JLabel("Arrival Date");
		arrivaldlb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		box1.add(arrivaldlb);
		
		JPanel empty1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) empty1.getLayout();
		flowLayout_2.setVgap(10);
		box1.add(empty1);
		
		JLabel departuredlb = new JLabel("Departure Date");
		departuredlb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		box1.add(departuredlb);
		
		JPanel empty2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) empty2.getLayout();
		flowLayout_1.setVgap(10);
		box1.add(empty2);
		
		JLabel roomTypelb = new JLabel("Room Type");
		roomTypelb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		box1.add(roomTypelb);
		
		JPanel box2 = new JPanel();
		center.add(box2);
		FlowLayout fl_box2 = (FlowLayout) box2.getLayout();
		fl_box2.setHgap(30);
		
		JPanel box3 = new JPanel();
		center.add(box3);
		box3.setLayout(new BoxLayout(box3, BoxLayout.Y_AXIS));
		
		arrivalDate = new JTextField(ViewBooking.aDate);
		arrivalDate.setColumns(15);
		box3.add(arrivalDate);
		
		JPanel empty3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) empty3.getLayout();
		flowLayout_3.setVgap(10);
		box3.add(empty3);
		
		departureDate = new JTextField(ViewBooking.dDate);
		departureDate.setColumns(15);
		box3.add(departureDate);
		
		JPanel empty4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) empty4.getLayout();
		flowLayout_4.setVgap(10);
		box3.add(empty4);
		
		roomType = new JTextField(ViewBooking.rType);
		roomType.setColumns(15);
		box3.add(roomType);
		
		JPanel empty5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) empty5.getLayout();
		flowLayout.setVgap(20);
		box.add(empty5);
		
		JPanel btn = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) btn.getLayout();
		flowLayout_5.setHgap(50);
		box.add(btn);
		
		JButton update = new JButton("Update Booking");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		update.setFocusable(false);
		update.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn.add(update);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setFocusable(false);
		cancel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn.add(cancel);
	}
	
	//updating the booking
	public void update() {
		try {
			Booking book = new Booking();
			book.setArrivalDate(arrivalDate.getText());
			book.setDepartureDate(departureDate.getText());
			book.setRoomType(roomType.getText());
			
			BLBooking blupdate = new BLBooking();
			blupdate.setBook(book);
			blupdate.update();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
	}

}
