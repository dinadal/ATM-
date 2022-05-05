import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DepositeFrame extends JFrame {

	public JFrame frame;
	private JTextField JLabDisplay;
	private JPanel contentPane;
	private JTextField txtTf;
	private JTextField balanceText;
	private static JLabel nonNegative;
	
	//my additions
	double balance = Login.balance;  //For now! The data will be later taken from main menu
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
		setBounds(100, 100, 605, 589);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		

		JLabel lblNewLabel = new JLabel("Enter the amount that you want to deposite.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 67, 317, 26);
		contentPane.add(lblNewLabel);
		
		/**
		txtTf = new JTextField();
		txtTf.setBounds(123, 116, 262, 61);
		contentPane.add(txtTf);
		txtTf.setColumns(10);
		*/
		

		/**JPanel panel = new JPanel();
		panel.setBounds(10, 205, 571, 336);
		contentPane.add(panel);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabDisplay = new JTextField();
		JLabDisplay.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		JLabDisplay.setBounds(6, 22, 188, 133);
		panel.add(JLabDisplay);
		JLabDisplay.setColumns(10);
		*/
		
		JLabDisplay = new JTextField();
		JLabDisplay.setBounds(153, 95, 209, 78);
		contentPane.add(JLabDisplay);
		JLabDisplay.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		JLabDisplay.setColumns(10);
		

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(405, 107, 159, 56);
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				//adds deposited amount to the balance 
				
				//balance = balance ;
				String depositeAmount;
				depositeAmount = JLabDisplay.getText();				
				double depositeD = Double.parseDouble(depositeAmount);
				nonNegative = new JLabel("");
				nonNegative.setBounds(10, 130, 300, 25);
				contentPane.add(nonNegative);
				nonNegative.setText(null);
				if (depositeD < 0) {
					nonNegative.setText("Don't deposit a negative amount!");
		        }
				else {
					balance = balance + depositeD; //answer as double
					String newBalance = String.valueOf(balance);
					balanceText.setText(newBalance);
					nonNegative.setText("Balance updated");
				}
				
			}
		});
		

		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Your balance is:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 14, 154, 42);
		contentPane.add(lblNewLabel_1);
		
		balanceText = new JTextField();
		balanceText.setEditable(false);
		balanceText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		balanceText.setBounds(186, 11, 159, 45);
		contentPane.add(balanceText);
		balanceText.setColumns(10);
		balanceText.setText(balanceS);
		JButton backButton = new JButton("Main Menu");

		backButton.setBounds(405, 17, 159, 41);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				dispose();
				// main frame should be here
				MainMenu panel = new MainMenu();
				panel.frame.setVisible(true);
				}
		});

		contentPane.add(backButton);
		
		/**
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(231, 69, 154, 30);
		contentPane.add(panel_1);
		*/
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 205, 571, 336);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		//frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/**
		txtTf = new JTextField();
		panel_1.add(txtTf);
		txtTf.setColumns(10);
		*/
		JButton btnNewButton_1 = new JButton(" ");
		btnNewButton_1.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/1.jpeg")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "1";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1.setBounds(54, 25, 101, 64);
		panel.add(btnNewButton_1);
		

		
		JButton btnNewButton_1_1 = new JButton(" ");
		btnNewButton_1_1.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/2.jpeg")));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "2";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_1.setBounds(188, 25, 101, 64);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton(" ");
		btnNewButton_1_2.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/3.jpeg")));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "3";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_2.setBounds(319, 25, 101, 64);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton(" ");
		btnNewButton_1_3.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/4.jpeg")));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "4";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_3.setBounds(54, 101, 101, 64);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton(" ");
		btnNewButton_1_4.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/5.jpeg")));
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "5";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_4.setBounds(188, 101, 101, 64);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton(" ");
		btnNewButton_1_5.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/6.jpeg")));
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "6";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_5.setBounds(319, 101, 101, 64);
		panel.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_6 = new JButton(" ");
		btnNewButton_1_6.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/7.jpeg")));
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "7";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_6.setBounds(54, 176, 101, 64);
		panel.add(btnNewButton_1_6);
		
		JButton btnNewButton_1_7 = new JButton(" ");
		btnNewButton_1_7.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/8.jpeg")));
		btnNewButton_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "8";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_7.setBounds(188, 176, 101, 64);
		panel.add(btnNewButton_1_7);
		
		JButton btnNewButton_1_8 = new JButton(" ");
		btnNewButton_1_8.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/9.jpeg")));
		btnNewButton_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "9";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_8.setBounds(319, 176, 101, 64);
		panel.add(btnNewButton_1_8);
		
		JButton btnNewButton_1_10 = new JButton(" ");
		btnNewButton_1_10.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/10.jpeg")));
		btnNewButton_1_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "10";
				JLabDisplay.setText(enterNumber);
			}
		});
		btnNewButton_1_10.setBounds(188, 251, 101, 64);
		panel.add(btnNewButton_1_10);
		
		JButton jBtnCancel = new JButton("AC");
		jBtnCancel.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/cancel.jpeg"));
		jBtnCancel.setBounds(430, 101, 101, 64);
		panel.add(jBtnCancel);
		//
		
	}
}
