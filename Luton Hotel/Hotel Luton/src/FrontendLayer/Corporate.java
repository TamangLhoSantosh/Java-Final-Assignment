package FrontendLayer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLCorporateCust;
import Models.CorporateCustomer;

public class Corporate extends JFrame {

	private static final long serialVersionUID = -915030940586408126L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	public static int ccid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Corporate frame = new Corporate();
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
	public Corporate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel box = new JPanel();
		contentPane.add(box, BorderLayout.NORTH);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		JPanel center = new JPanel();
		box.add(center);
		
		table = new JTable();
		JScrollPane forTable = new JScrollPane(table);
		center.add(forTable);
		
		model = new DefaultTableModel();
		
		JPanel btn = new JPanel();
		box.add(btn);
		
		JButton viewBooking = new JButton("View Booking");
		viewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBookingOfCust();
			}
		});
		viewBooking.setFocusable(false);
		viewBooking.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn.add(viewBooking);
		
		showCC();
	}

	//table identifier
	public void showCC() {

		Object[] colsName = new Object[7];
		colsName[0] = "Customer Id";
		colsName[1] = "Registration No";
		colsName[2] = "Company Name";
		colsName[3] = "Contact No";
		colsName[4] = "Address";
		colsName[5] = "Discount to be Provided";
		colsName[6] = "Discount Year";
		
		model.setColumnIdentifiers(colsName);
		table.setModel(model);
		
		viewAllCC();
	}

	//shows all corporate customer
	public void viewAllCC(){

		try {
			BLCorporateCust cc = new BLCorporateCust();
			ArrayList<CorporateCustomer> corporatec = cc.viewAllCC();
			model.setRowCount(0);
			for(CorporateCustomer ccustomer : corporatec) {
				String[] row = {
						Integer.toString(ccustomer.getCustomerId()),
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
	

	//searches specific corporate customer
	public void searchCorporateCustomer() {
		Object[] colsName = new Object[7];
		colsName[0] = "Customer Id";
		colsName[1] = "Registration No";
		colsName[2] = "Company Name";
		colsName[3] = "Contact No";
		colsName[4] = "Address";
		colsName[5] = "Discount to be Provided";
		colsName[6] = "Discount Year";
		
		model.setColumnIdentifiers(colsName);
		table.setModel(model);
		
		String[] keys, values;
		BLCorporateCust blcc = new BLCorporateCust();
		
		try {
			if(!(StaffHome.regno.getText().equals("") && StaffHome.compname.getText().equals(""))) {
				keys = new String[2];
				values = new String[2];
				keys[0] = "Registration_No"; values[0] = StaffHome.regno.getText();
				keys[1] = "Company_Name"; values[1] = StaffHome.compname.getText();
				blcc.searchCorporateCust(keys, values);
				searchCCTable();
			}
			else if(!(StaffHome.regno.getText().equals(""))) {
				keys = new String[1];
				values = new String[1];
				keys[0] = "Registration_No"; values[0] = StaffHome.regno.getText();
				blcc.searchCorporateCust(keys, values);
				searchCCTable();
			}
			else if (!(StaffHome.compname.getText().equals(""))) {
				keys = new String[1];
				values = new String[1];
				keys[1] = "Company_Name"; values[0] = StaffHome.compname.getText();
				blcc.searchCorporateCust(keys, values);
				searchCCTable(); 
			}
			else {
				viewAllCC();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	//shows specific corporate customer data
	public void searchCCTable() {

		try {
			BLCorporateCust ic = new BLCorporateCust();
			ArrayList<CorporateCustomer> ccust = ic.viewAllCC();
			model.setRowCount(0);
			for(CorporateCustomer cc : ccust) {
				String[] row = {
						Integer.toString(cc.getCustomerId()),
						Integer.toString(cc.getRegistrationNo()),
						cc.getCompanyName(),
						cc.getContact(),
						cc.getAddress(),
						Integer.toString(cc.getDiscountDiscussed()),
						cc.getDiscountYear()
				};
				model.addRow(row);
			}		
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}


	//views customer's booking details
	public void viewBookingOfCust() {	
		ccid = 0;
		int i = table.getSelectedRow();
		if(i < 0 ) {
			JOptionPane.showMessageDialog(null, "Select a row first");
		}
		else{
			ccid = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));;
			CorporateB cb = new CorporateB();
			cb.viewcTable();
			cb.setVisible(true);
		}
	}
}
