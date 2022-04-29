import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WithdrawFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	
	//my additions
	double balance = 1000.101; //For now! The data will be later taken from main menu
	String balanceS = String.valueOf(balance);
	private JLabel lblNewLabel_1;
	private JTextField balanceText;
	private static JLabel nonNegative;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawFrame frame = new WithdrawFrame();
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
	public WithdrawFrame() {
		setTitle("Withdraw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(55, 90, 278, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter the amount that you want to withdraw.");
		lblNewLabel.setBounds(55, 42, 346, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//The "ok" button
				//Subtracts the withdrawn amount from the balance
				//balance = balance ;
				String withdrawAmount;
				withdrawAmount = textField.getText();				
				double withdrawD = Double.parseDouble(withdrawAmount);
				nonNegative = new JLabel("");
				nonNegative.setBounds(10, 130, 300, 25);
				contentPane.add(nonNegative);
				nonNegative.setText(null);
				if (withdrawD < 0) {
					nonNegative.setText("Don't withdraw a negative amount!");
		        }
				else {
					balance = balance - withdrawD; //answer as double
					String newBalance = String.valueOf(balance);
					balanceText.setText(newBalance);
					nonNegative.setText("Balance updated");
				}
				

				
				
				
			}
		});

		JButton backButton = new JButton("Main Menu");

		backButton.setBounds(43, 221, 302, 35);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				dispose();
				// main frame should be here
				MainMenu panel = new MainMenu();
				panel.showWindow();
				}
		});
		contentPane.add(backButton);

		btnNewButton.setBounds(55, 172, 289, 41);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Your balance is:");
		lblNewLabel_1.setBounds(55, 24, 120, 26);
		contentPane.add(lblNewLabel_1);
		
		balanceText = new JTextField();
		balanceText.setBounds(170, 24, 130, 26);
		contentPane.add(balanceText);
		balanceText.setColumns(10);
		balanceText.setText(balanceS);
	}

}