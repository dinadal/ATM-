import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
	private JTextField jLabDisplay;
	private JTextField userText;
	private JTextField passwordText;
	private static JLabel success;
	private static String name;
	private JTextField LoginLab;
	String AccNum_from_file;
	boolean user_found=false; 
	static double balance = 0;

	/**
	 * Launch the application.
	 */
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
	public void Verify() {
		String user = userText.getText();
		String password = passwordText.getText();
		String b = null;
        try {
			Scanner in = new Scanner(new File("./src/RounterInfo.txt"));
			while(in.hasNextLine()){
				 //if there is a line, print it out
				 String line = in.nextLine();
				 String[] output = line.split(";");
				 String AccNum_from_file = output[0]; 
				 String password_form_file = output[1];
				 name = output[2];
				 b = output[3];
				 if(user.equals(AccNum_from_file) && password.equals(password_form_file)) {
					 jLabDisplay.setText("login Successful");
					 user_found=true;
					 break;
				 }
			 }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		balance = Double.parseDouble(b);
	}
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		

	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(22, 6, 172, 188);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAccNum = new JButton("Account Number");
		btnAccNum.addActionListener(new ActionListener() {
			
			@Override  //Takes the user to the withdraw frame
			public void actionPerformed(ActionEvent e) {
				jLabDisplay  = userText;
			}
			
		});
		btnAccNum.setBounds(25, 29, 141, 52);
		panel.add(btnAccNum);
		
		JButton btnPin = new JButton("Pin");
		btnPin.addActionListener(new ActionListener() {
					
					@Override  //Takes the user to the withdraw frame
					public void actionPerformed(ActionEvent e) {
						jLabDisplay  = passwordText;
					}
					
				});
		btnPin.setBounds(25, 105, 141, 52);
		panel.add(btnPin);
		
		jLabDisplay = new JTextField();
		jLabDisplay.setBounds(6, 122, 14, 15);
		panel.add(jLabDisplay);
		jLabDisplay.setVisible(false);
		jLabDisplay.setForeground(Color.WHITE);
		jLabDisplay.setBackground(Color.WHITE);
		jLabDisplay.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		jLabDisplay.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(206, 6, 200, 188);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		userText = new JTextField();
		userText.setBounds(6, 40, 130, 26);
		panel_1.add(userText);
		userText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(6, 117, 130, 26);
		panel_1.add(passwordText);
		passwordText.setColumns(10);
		
		LoginLab = new JTextField("Enter your information:");
		LoginLab.setBackground(Color.LIGHT_GRAY);
		LoginLab.setColumns(10);
		LoginLab.setBounds(20, 6, 156, 22);
		panel_1.add(LoginLab);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(414, 6, 180, 188);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(24, 25, 120, 52);
		btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jLabDisplay = LoginLab;
			
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
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(24, 101, 120, 52);
		panel_2.add(btnSignUp);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(16, 206, 578, 356);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
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
		
		JButton jBtnClear = new JButton("");
		jBtnClear.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/clear.jpeg"));
		jBtnClear.setBounds(410, 140, 101, 64);
		panel_3.add(jBtnClear);
		
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
		
		JButton jBtnEnter = new JButton("");
		jBtnEnter.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/enter.jpeg"));
		jBtnEnter.setBounds(410, 230, 101, 64);
		panel_3.add(jBtnEnter);
		
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
		
		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/empty.jpeg")));
		btnNewButton_1_3.setBounds(71, 251, 101, 64);
		panel_3.add(btnNewButton_1_3);
		
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
		
		JButton jBtnCancel = new JButton("");
		jBtnCancel.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/cancel.jpeg"));
		jBtnCancel.setBounds(410, 45, 101, 64);
		panel_3.add(jBtnCancel);
		
		JButton btnNewButton_1_3_1 = new JButton("");
		btnNewButton_1_3_1.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/empty.jpeg")));
		btnNewButton_1_3_1.setBounds(297, 252, 101, 64);
		panel_3.add(btnNewButton_1_3_1);
	}
}
