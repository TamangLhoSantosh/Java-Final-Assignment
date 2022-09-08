package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLRoom;
import Models.AllModel;
import javax.swing.BoxLayout;

public class CorporateB extends JFrame {

	private static final long serialVersionUID = -6036925219849591897L;
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
					CorporateB frame = new CorporateB();
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
	public CorporateB() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,200,800,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel center = new JPanel();
		contentPane.add(center);
		
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		center.add(box);
		
		table = new JTable();
		JScrollPane forTable = new JScrollPane(table);
		box.add(forTable);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JPanel cent = new JPanel();
		box.add(cent);
		
		JButton billing = new JButton("Generate Bill");
		billing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billing();
			}
		});
		billing.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		billing.setFocusable(false);
		cent.add(billing);
		
	}

	//creating table identifier
	public void viewiTable() {

			model = new DefaultTableModel();
			Object[] colsName = new Object[8];
			colsName[0] = "Booking Id";
			colsName[1] = "Customer Id";
			colsName[2] = "Customer Name";
			colsName[3] = "Room No";
			colsName[4] = "Room Type";
			colsName[5] = "Arrival Date";
			colsName[6] = "Departure Date";	
			colsName[7] = "Booking Status";

			model.setColumnIdentifiers(colsName);
			table.setModel(model);
			
			viewiData();
		}
	
	//showing data of individual customer
	public void viewiData() {
		try {
			
		BLRoom room = new BLRoom();
		ArrayList<AllModel> roomsdetails = room.viewiData();
		model.setRowCount(0);
		for(AllModel am : roomsdetails) {
			String[] row = {
					Integer.toString(am.getBookingId()),
					Integer.toString(am.getIcustomerId()),
					am.getName(),
					Integer.toString(am.getRoomNo()),
					am.getRoomType(),
					am.getArrivalDate(),
					am.getDepartureDate(),
					am.getBookingStatus()
				};
				model.addRow(row);
			}
		
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	//table column identifier
	public void viewcTable() {
		
		model = new DefaultTableModel();
		Object[] colsName = new Object[8];
		colsName[0] = "Booking Id";
		colsName[1] = "Customer Id";
		colsName[2] = "Company Name";
		colsName[3] = "Room No";
		colsName[4] = "Room Type";
		colsName[5] = "Arrival Date";
		colsName[6] = "Departure Date";
		colsName[7] = "Booking Status";
		
		model.setColumnIdentifiers(colsName);
		table.setModel(model);
		
		viewcData();
	}
	
	//showing data of corporate customer
	public void viewcData() {

		try {
			
		BLRoom room = new BLRoom();
		ArrayList<AllModel> roomsdetails = room.viewcData();
		model.setRowCount(0);
		for(AllModel am : roomsdetails) {
			String[] row = {
					Integer.toString(am.getBookingId()),
					Integer.toString(am.getCcustomerId()),
					am.getCompname(),
					Integer.toString(am.getRoomNo()),
					am.getRoomType(),
					am.getArrivalDate(),
					am.getDepartureDate(),
					am.getBookingStatus()
				};
				model.addRow(row);
			}
		
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	//genreting bill
	public void billing() {
		int i = table.getSelectedRow();
		if(i < 0 ) {
			JOptionPane.showMessageDialog(null, "Select a row first");
		}
		else{
			Billing bill = new Billing();
			bill.bill();
			bill.setVisible(true);
		}
	}
}
