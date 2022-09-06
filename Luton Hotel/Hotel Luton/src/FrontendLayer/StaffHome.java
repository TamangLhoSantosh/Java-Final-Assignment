package FrontendLayer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLBooking;
import BusinessLayer.BLCorporateCust;
import BusinessLayer.BLIndividualCust;
import Models.Booking;
import Models.CorporateCustomer;
import Models.IndividualCustomer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffHome extends JFrame {

	private static final long serialVersionUID = 9024790994297089147L;
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
		
		JPanel box = new JPanel();
		panel.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		JPanel Label = new JPanel();
		FlowLayout fl_Label = (FlowLayout) Label.getLayout();
		fl_Label.setVgap(15);
		fl_Label.setHgap(60);
		box.add(Label);
		
		JPanel searchIC = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) searchIC.getLayout();
		flowLayout_1.setHgap(25);
		flowLayout_1.setVgap(15);
		box.add(searchIC);
		
		JLabel fnamelb = new JLabel("First Name");
		fnamelb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		searchIC.add(fnamelb);
		
		JTextField fname = new JTextField();
		fname.setColumns(15);
		searchIC.add(fname);
		
		JLabel lnamelb = new JLabel("Last Name");
		lnamelb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		searchIC.add(lnamelb);
		
		JTextField lname = new JTextField();
		lname.setColumns(15);
		searchIC.add(lname);

		JLabel empty1 =new JLabel();
		searchIC.add(empty1);
		
		JLabel addresslb = new JLabel();
		searchIC.add(addresslb);
		
		JTextField address = new JTextField();
		address.setColumns(15);
		searchIC.add(address);
		
		JButton search = new JButton("Search Individual");
		search.setFocusable(false);
		search.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		searchIC.add(search);
		
		JPanel searchCC = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) searchCC.getLayout();
		flowLayout_2.setVgap(15);
		flowLayout_2.setHgap(25);
		box.add(searchCC);
		
		JLabel regnolb = new JLabel("Registration No");
		regnolb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		searchCC.add(regnolb);
		
		JTextField regno = new JTextField();
		regno.setColumns(15);
		searchCC.add(regno);
		
		JLabel empty2 = new JLabel();
		searchCC.add(empty2);
		
		JLabel compnamelb = new JLabel();
		compnamelb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		compnamelb.setText("Company Name");
		searchCC.add(compnamelb);
		
		JTextField compname =new JTextField();
		compname.setColumns(15);
		searchCC.add(compname);
		
		JButton search1 = new JButton("Search Corporate");
		search1.setFocusable(false);
		search1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		searchCC.add(search1);

		table = new JTable();
		JScrollPane forTable = new JScrollPane(table);
		box.add(forTable);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JPanel btn = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btn.getLayout();
		flowLayout.setHgap(100);
		flowLayout.setVgap(15);
		box.add(btn);
		
		JButton showICbtn= new JButton("Individual Customers");
		showICbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIC();
			}
		});
		showICbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		showICbtn.setFocusable(false);
		btn.add(showICbtn);
		
		JButton showCCbtn = new JButton("Corporate Customers");
		showCCbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCC();
			}
		});
		showCCbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		showCCbtn.setFocusable(false);
		model = new DefaultTableModel();
		btn.add(showCCbtn);
		
		showBookingTable();
	}

	public void showBookingTable() {
		
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
			}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public void showIC() {
		
		Object[] colsName = new Object[5];
		colsName[0] = "First Name";
		colsName[1] = "Last Name";
		colsName[2] = "Date of Birth";
		colsName[3] = "Contact No";
		colsName[4] = "Address";
		
		model.setColumnIdentifiers(colsName);
		table.setModel(model);
		
		viewAllIC();
	}
	
	public void viewAllIC() {

		try {
			BLIndividualCust ic = new BLIndividualCust();
			ArrayList<IndividualCustomer> individualc = ic.viewAllIC();
			model.setRowCount(0);
			for(IndividualCustomer icustomer : individualc) {
				String[] row = {
						icustomer.getfName(),
						icustomer.getlName(),		
						icustomer.getDateOfBirth(),
						icustomer.getContact(),
						icustomer.getAddress()
				};
				model.addRow(row);
			}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	public void showCC() {
		
		Object[] colsName = new Object[6];
		colsName[0] = "Registration No";
		colsName[1] = "Company Name";
		colsName[2] = "Contact No";
		colsName[3] = "Address";
		colsName[4] = "Discount to be Provided";
		colsName[5] = "Discount Year";
		
		model.setColumnIdentifiers(colsName);
		table.setModel(model);
		
		viewAllCC();
	}

	public void viewAllCC(){

		try {
			BLCorporateCust cc = new BLCorporateCust();
			ArrayList<CorporateCustomer> corporatec = cc.viewAllCC();
			model.setRowCount(0);
			for(CorporateCustomer ccustomer : corporatec) {
				String[] row = {
						Integer.toString(ccustomer.getRegistrationNo()),
						ccustomer.getCompanyName(),
						ccustomer.getContact(),
						ccustomer.getAddress(),
						Integer.toString(ccustomer.getDiscountDiscussed()),
						ccustomer.getDiscountYear()
				};
				model.addRow(row);
			}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}
}
