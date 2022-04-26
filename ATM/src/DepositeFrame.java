import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DepositeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtTf;
	private JTextField balanceText;
	
	//my additions
	double balance = 1000.101;
	String balanceS = String.valueOf(balance);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositeFrame frame = new DepositeFrame();
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
	public DepositeFrame() {
		setTitle("Deposite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the amount that you want to deposite.");
		lblNewLabel.setBounds(32, 49, 367, 42);
		contentPane.add(lblNewLabel);
		
		txtTf = new JTextField();
		txtTf.setBounds(43, 92, 287, 35);
		contentPane.add(txtTf);
		txtTf.setColumns(10);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.setBounds(43, 181, 302, 35);
		btnNewButton.addActionListener(new ActionListener() {
		
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				//adds deposited amount to the balance 
				
				//balance = balance ;
				
				String depositeAmount;
				depositeAmount = txtTf.getText();				
				double depositeD = Double.parseDouble(depositeAmount);
				balance = balance + depositeD; //answer as double
				String newBalance = String.valueOf(balance);
				balanceText.setText(newBalance);
				
				
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Your balance is:");
		lblNewLabel_1.setBounds(32, 32, 112, 16);
		contentPane.add(lblNewLabel_1);
		
		balanceText = new JTextField();
		balanceText.setBounds(159, 27, 130, 26);
		contentPane.add(balanceText);
		balanceText.setColumns(10);
		balanceText.setText(balanceS);
	}
}