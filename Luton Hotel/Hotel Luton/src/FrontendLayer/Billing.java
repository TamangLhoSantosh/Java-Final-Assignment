package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLayer.BLRoom;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;

public class Billing extends JFrame {

	private static final long serialVersionUID = 1281733966151634453L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing frame = new Billing();
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
	public Billing() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pan = new JPanel();
		contentPane.add(pan, BorderLayout.CENTER);
		
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		pan.add(box);
		
		JPanel panel = new JPanel();
		box.add(panel);
		
		JLabel title = new JLabel("Invoice");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(title);
		
		JPanel empty = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) empty.getLayout();
		flowLayout_3.setVgap(15);
		box.add(empty);
		
		JPanel desc = new JPanel();
		box.add(desc);
		
		JLabel night = new JLabel("Night Stayed");
		night.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		desc.add(night);
		
		JPanel empty1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) empty1.getLayout();
		flowLayout.setHgap(30);
		desc.add(empty1);
		
		JLabel day = new JLabel();
		day.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		desc.add(day);
		
		JPanel empty2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) empty2.getLayout();
		flowLayout_2.setVgap(15);
		box.add(empty2);
		
		JPanel total = new JPanel();
		box.add(total);
		
		JLabel totalCost = new JLabel("Total");
		totalCost.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		total.add(totalCost);
		
		JPanel empty3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) empty3.getLayout();
		flowLayout_1.setHgap(30);
		total.add(empty3);
		
		JLabel money = new JLabel();
		money.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		total.add(money);
	}

	public void billIC(){
		try {
			BLRoom blr = new BLRoom();
			blr.billIC();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void billCC() {
		try {
			BLRoom blr = new BLRoom();
			blr.billCC();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
