import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTf;
	private JTextField balanceText;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	private static String name;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userLabel = new JLabel("Account Number");
		userLabel.setBounds(10, 20, 160, 25);
		contentPane.add(userLabel);
		
		userText = new JTextField();
		userText.setBounds(120, 20, 165, 25);
		contentPane.add(userText);
		
		passwordLabel = new JLabel("Pin");
		passwordLabel.setBounds(10, 50, 80, 25);
		contentPane.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(120, 50, 165, 25);
		contentPane.add(passwordText);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		contentPane.add(success);
		success.setText(null);

		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(43, 181, 302, 35);
		btnNewButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = userText.getText();
				String password = passwordText.getText();
				boolean user_found=false; 
		        try {
					Scanner in = new Scanner(new File("./src/RounterInfo.txt"));
					while(in.hasNextLine()){
						 //if there is a line, print it out
						 String line = in.nextLine();
						 String[] output = line.split(";");
						 String AccNum_from_file = output[0]; 
						 String password_form_file = output[1];
						 name = output[2];
						 if(user.equals(AccNum_from_file) && password.equals(password_form_file)) {
							 success.setText("login Successful");
							 user_found=true;
							 break;
						 }
					 }
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
				if(user_found==false) {
					success.setText("Login error");
					
				}
				else {
					dispose();
					JOptionPane.showMessageDialog(null,"Welcome "+name,"Welcome",JOptionPane.INFORMATION_MESSAGE);
					// main frame should be here
					MainMenu panel = new MainMenu();
					panel.showWindow();
				}	
			}
		});

		
		contentPane.add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}