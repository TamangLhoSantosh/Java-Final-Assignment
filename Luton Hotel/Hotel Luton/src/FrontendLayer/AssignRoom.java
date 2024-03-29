package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BLBooking;
import BusinessLayer.BLRoom;
import Models.Room;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignRoom extends JFrame {

	private static final long serialVersionUID = -3732355350714645086L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton assign;
	public static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignRoom frame = new AssignRoom();
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
	public AssignRoom() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		center.add(box);
		
		JLabel aRoom = new JLabel("Assign Room");
		aRoom.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		box.add(aRoom);
		
		JPanel empty = new JPanel();
		FlowLayout flowLayout = (FlowLayout) empty.getLayout();
		flowLayout.setVgap(10);
		box.add(empty);
		
		JPanel room = new JPanel();
		box.add(room);
		
		JLabel roomType = new JLabel("Room Type");
		roomType.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		room.add(roomType);
		
		JPanel empty1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) empty1.getLayout();
		flowLayout_1.setHgap(30);
		room.add(empty1);
		
		JLabel rType = new JLabel(StaffHome.rType);
		rType.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		room.add(rType);
		
		JPanel empty2 = new JPanel();
		box.add(empty2);
		
		table = new JTable();
		JScrollPane forTable = new JScrollPane(table);
		box.add(forTable);
		model = new DefaultTableModel();		
		showRoom();

		JPanel empty3 =new JPanel();
		box.add(empty3);
		
		JPanel btn = new JPanel();
		box.add(btn);
		
		assign = new JButton("Assign Room");
		assign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assign();
			}
		});
		assign.setAlignmentX(Component.CENTER_ALIGNMENT);
		assign.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		assign.setFocusable(false);
		btn.add(assign);
		
	}
	
	//showing the required title
	public void showRoom() {
		model = new DefaultTableModel();
		
		Object[] colsName = new Object[5];
		colsName[0] = "Room No";
		colsName[1] = "Room Type";
		colsName[2] = "Floor No";
		colsName[3] = "Rate";
		colsName[4] = "Avalability";

		
		model.setColumnIdentifiers(colsName);
		table.setModel(model);
		
		viewRoom();
	}
	
	//showing only required room
	public void viewRoom() {

		try {
			BLRoom room = new BLRoom();
			ArrayList<Room> rooms = room.viewRoom();
			model.setRowCount(0);
			for(Room rm : rooms) {
				String[] row = {
						Integer.toString(rm.getRoomNo()),
						rm.getRoomType(),
						Integer.toString(rm.getRoomNo()),
						Integer.toString(rm.getRoomNo()),
						rm.getAvailability()
				};
				model.addRow(row);
			}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	
	//assigning room to a booking
	public void assign() {
		int i = table.getSelectedRow();
		try {

			if(i < 0) {
				JOptionPane.showMessageDialog(null, "Select a row first");
			}
			else {
				if(JOptionPane.showConfirmDialog(assign, "Are You Sure You Want To Assign This Room???", "Assign Room",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					id = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
					BLBooking blb = new BLBooking();
					blb.assign();
					
					BLRoom blr = new BLRoom();
					blr.assign();
					showRoom();
				}
				
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}
