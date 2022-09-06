package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLBooking;
import Models.Booking;

import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBooking extends JFrame {

	private static final long serialVersionUID = 2239918392069997136L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	public static JButton cancel;
	public static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooking frame = new ViewBooking();
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
	public ViewBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane forjiFrame = new JDesktopPane();
		contentPane.add(forjiFrame, BorderLayout.CENTER);
		forjiFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		forjiFrame.add(panel);
		
		JPanel box = new JPanel();
		panel.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane forTable = new JScrollPane(table);
		box.add(forTable);
		
		model = new DefaultTableModel();
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
		
		viewBooking();
		
		
		JPanel empty = new JPanel();
		FlowLayout flowLayout = (FlowLayout) empty.getLayout();
		flowLayout.setVgap(20);
		box.add(empty);
		
		JPanel btn = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) btn.getLayout();
		flowLayout_1.setHgap(50);
		flowLayout_1.setVgap(20);
		box.add(btn);
		
		JButton update = new JButton("Update Booking");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forjiFrame.add(new UpdateBooking()).setVisible(true);
			}
		});
		update.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn.add(update);

		JButton edit = new JButton("Cancel Booking");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int i = table.getSelectedRow();
				Object same = model.getValueAt(i,6);
				if((same.toString()).equals("Cancel")) {
					JOptionPane.showMessageDialog(null, "Already cancelled");
				}
				else {
					if(i == 0) {
						JOptionPane.showMessageDialog(null, "Select a row first");
					}
					else {
						id = Integer.parseInt(model.getValueAt(i, 0).toString());
						try {
							BLBooking blb= new BLBooking();
							blb.cancel();
							viewBooking();
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage());
						}
					}
				}
			}
		});
		edit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn.add(edit);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerHome hp = new CustomerHome();
				hp.setVisible(true);
				dispose();
			}
		});
		cancel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn.add(cancel);
		
	}
	
	public void viewBooking() {
		try {
			BLBooking book = new BLBooking();
			ArrayList<Booking> bookings = book.viewBooking();
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
			}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
