package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLBooking;
import Models.Booking;

public class StaffHome extends JFrame {

	private static final long serialVersionUID = 7212976220638932482L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffHome frame = new StaffHome();
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
	public StaffHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);

		table = new JTable();
		JScrollPane forTable = new JScrollPane(table);
		panel.add(forTable);
		model = new DefaultTableModel();
		
		showTable();
	}
	
	public void showTable() {
		
		Object[] colsName = new Object[8];
		colsName[0] = "Booking Id";
		colsName[1] = "Booking Date";
		colsName[2] = "Room Type";
		colsName[3] = "Arrival Date";
		colsName[4] = "Departure Date";
		colsName[5] = "Booking Verifired";
		colsName[6] = "Booking Status";
		colsName[7] = "Room Id";
		
		model.setColumnIdentifiers(colsName);
		table.setModel(model);
		
		viewAllBooking();

	}
	
	public void viewAllBooking() {

		try {
			BLBooking book = new BLBooking();
			ArrayList<Booking> bookings = book.viewAllBooking();
			model.setRowCount(0);
			for(Booking booking : bookings) {
				String[] row = {
						Integer.toString(booking.getBookingId()),
						booking.getBookingDate(),
						booking.getRoomType(),
						booking.getArrivalDate(),
						booking.getBookingDate(),
						booking.getBookingVerified(),
						booking.getBookingStatus()		
				};
				model.addRow(row);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

}
