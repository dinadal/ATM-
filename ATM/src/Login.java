import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Login {


	JFrame frame; //frame for login interface
	private JTextField jLabDisplay; //Hidden label for later uses
	private JTextField userText; //Account number from user
	private JTextField passwordText; //Password from user
	static String name; //name of the user
	private JTextField loginLab; //Text field for incorrect login
	static String accNum_from_file; //Account number from data stored in the text file
	static String password_form_file; //Password from data stored in the text file
	boolean user_found = false; //Checks if the user logged in with the correct info
	static double balance = 0; //balance


	//Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the application.
		public Login() {
			initialize();
		}
		
	//Initialize the contents of the frame.
	private void initialize() {
		//Setting the size of the frame
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Setting the size of the panel
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(22, 6, 172, 188);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Account number button
		JButton btnAccNum = new JButton("Account Number");
		btnAccNum.addActionListener(new ActionListener() {
			@Override  //Enables the user to enter the account number
			public void actionPerformed(ActionEvent e) {
				jLabDisplay  = userText; 
				}
			});
		btnAccNum.setBounds(25, 29, 141, 52);
		panel.add(btnAccNum);
		
		//Pin button
		JButton btnPin = new JButton("Pin");
		btnPin.addActionListener(new ActionListener() {
			@Override  //Enables the user to enter the pin
			public void actionPerformed(ActionEvent e) {
				jLabDisplay  = passwordText;
				}
			});
		btnPin.setBounds(25, 105, 141, 52);
		panel.add(btnPin);
		
		//Properties of jLabDisplay
		jLabDisplay = new JTextField();
		jLabDisplay.setBounds(6, 122, 14, 15);
		panel.add(jLabDisplay);
		jLabDisplay.setVisible(false);
		jLabDisplay.setForeground(Color.WHITE);
		jLabDisplay.setBackground(Color.WHITE);
		jLabDisplay.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		jLabDisplay.setColumns(10);
		
		//Properties of panel_1
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(206, 6, 200, 188);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Properties of userText
		userText = new JTextField();
		userText.setBounds(6, 40, 130, 26);
		panel_1.add(userText);
		userText.setColumns(10);
		
		//Properties of passwordText
		passwordText = new JPasswordField();
		passwordText.setBounds(6, 117, 130, 26);
		panel_1.add(passwordText);
		passwordText.setColumns(10);
		
		//Properties of LoginLab
		loginLab = new JTextField("Enter your information:");
		loginLab.setEditable(false);
		loginLab.setBackground(Color.LIGHT_GRAY);
		loginLab.setColumns(10);
		loginLab.setBounds(20, 6, 156, 22);
		panel_1.add(loginLab);
		
		//Properties of panel_2
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(414, 6, 180, 188);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		//Login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(24, 25, 120, 52);
		btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jLabDisplay = loginLab;
			Verify();
			if(user_found==false) {
				jLabDisplay.setText("Login error");
			}
			else {
				frame.dispose();
				MainMenu panel = new MainMenu();
				panel.frame.setVisible(true);
			}	
		}
	});
		panel_2.add(btnLogin);
		
		//Sign up button
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			SignUp panel = new SignUp();
			panel.setVisible(true);
			}
		});
		btnSignUp.setBounds(24, 101, 120, 52);
		panel_2.add(btnSignUp);
		
		//Properties of panel_3
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(16, 206, 578, 356);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		//Adding the number buttons 0-9
		
		//Button for number 0
		JButton jBtn0 = new JButton("");
		jBtn0.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/0.jpeg")));
		jBtn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "0";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn0.setBounds(184, 251, 101, 64);
		panel_3.add(jBtn0);
		
		//Button for number 1
		JButton jBtn1 = new JButton("");
		jBtn1.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/1.jpeg")));
		jBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "1";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn1.setBounds(71, 25, 101, 64);
		panel_3.add(jBtn1);
		
		//Button for number 2
		JButton jBtn2 = new JButton("");
		jBtn2.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/2.jpeg")));
		jBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "2";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn2.setBounds(184, 25, 101, 64);
		panel_3.add(jBtn2);
		
		//Button for number 3
		JButton jBtn3 = new JButton("");
		jBtn3.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/3.jpeg")));
		jBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "3";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn3.setBounds(297, 25, 101, 64);
		panel_3.add(jBtn3);
		
		//Button for number 4
		JButton jBtn4 = new JButton("");
		jBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "4";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn4.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/4.jpeg")));
		jBtn4.setBounds(71, 101, 101, 64);
		panel_3.add(jBtn4);
		
		//Button for number 5
		JButton jBtn5 = new JButton("");
		jBtn5.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/5.jpeg")));
		jBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "5";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn5.setBounds(184, 101, 101, 64);
		panel_3.add(jBtn5);
		
		//Button for number 6
		JButton jBtn6 = new JButton("");
		jBtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "6";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn6.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/6.jpeg")));
		jBtn6.setBounds(297, 101, 101, 64);
		panel_3.add(jBtn6);
		
		//Button for number 7
		JButton jBtn7 = new JButton("");
		jBtn7.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/7.jpeg")));
		jBtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "7";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn7.setBounds(71, 176, 101, 64);
		panel_3.add(jBtn7);
		
		//Button for number 8
		JButton jBtn8 = new JButton("");
		jBtn8.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/8.jpeg")));
		jBtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "8";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn8.setBounds(184, 176, 101, 64);
		panel_3.add(jBtn8);
		
		//Button for number 9
		JButton jBtn9 = new JButton("");
		jBtn9.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/9.jpeg")));
		jBtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = jLabDisplay.getText() + "9";
				jLabDisplay.setText(enterNumber);
			}
		});
		jBtn9.setBounds(297, 176, 101, 64);
		panel_3.add(jBtn9);
		
		//Clear button
		JButton jBtnClear = new JButton("");
		jBtnClear.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons2/Clear.jpg")));
		jBtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passwordText.setText("");
				loginLab.setText("Enter your information:"); 
			}
		});
		jBtnClear.setBounds(410, 140, 101, 64);
		panel_3.add(jBtnClear);
		
		//Enter button
		JButton jBtnEnter = new JButton("");
		jBtnEnter.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons2/Enter.jpg")));
		jBtnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jLabDisplay = loginLab;
				
				Verify();
				if(user_found==false) {
					jLabDisplay.setText("Login error");
					
				}
				else {
					frame.dispose();
					MainMenu panel = new MainMenu();
					panel.frame.setVisible(true);
				}	
			}
			
		});
		jBtnEnter.setBounds(410, 230, 101, 64);
		panel_3.add(jBtnEnter);
		
		//Cancel button
		JButton jBtnCancel = new JButton("");
		jBtnCancel.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons2/Cancel.jpg")));
		jBtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passwordText.setText("");
				loginLab.setText("Enter your information:"); 
			}
		});
		jBtnCancel.setBounds(410, 45, 101, 64);
		panel_3.add(jBtnCancel);
		
	}
	
	//Function to verify the credentials entered by the user
		public void Verify() {
			String user = userText.getText();
			String password = passwordText.getText();
			String b = null;
	        try {
	        	//Reads information from the text file
				Scanner in = new Scanner(new File("C:\\Users\\KHALID\\git\\ATM\\ATM\\src\\LoginInfo.txt"));
				while(in.hasNextLine()){
					 //if there is a line, print it out
					 String line = in.nextLine();
					 String[] output = line.split(";");
					 accNum_from_file = output[0]; 
					 password_form_file = output[1];
					 name = output[2];
					 b = output[3];
					 if(user.equals(accNum_from_file) && password.equals(password_form_file)) {
						 jLabDisplay.setText("login Successful");
						 user_found=true;
						 break;
					 }
				 }
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			setBalance(Double.parseDouble(b));
		}

		public static double getBalance() {
			return balance;
		}

		public static void setBalance(double balance) {
			Login.balance = balance;
		}
		
}
