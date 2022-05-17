import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JTextField fname;
	private static JTextField lname;
	private static JTextField address;
	private static JTextField email;
	private static JPasswordField pinText;
	private static JPasswordField ConfirmPinText;
	private static JTextField PhoneNum;
	private static JLabel passwordLabel;
	private static JLabel success;
	String user;
	Account acc;
	String password;
	double b;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUp(){
		
		setTitle("SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userLabel = new JLabel("Last Name");
		userLabel.setBounds(10, 20, 160, 25);
		contentPane.add(userLabel);
		
		lname = new JTextField();
		lname.setBounds(120, 20, 165, 25);
		contentPane.add(lname);
		
		userLabel = new JLabel("First Name");
		userLabel.setBounds(10, 50, 80, 25);
		contentPane.add(userLabel);
		
		fname = new JTextField();
		fname.setBounds(120, 50, 165, 25);
		contentPane.add(fname);
		
		userLabel = new JLabel("Address");
		userLabel.setBounds(10, 80, 80, 25);
		contentPane.add(userLabel);
		
		address = new JTextField();
		address.setBounds(120, 80, 200, 65);
		contentPane.add(address);
		
		userLabel = new JLabel("Email");
		userLabel.setBounds(350, 20, 160, 25);
		contentPane.add(userLabel);
		
		email = new JTextField();
		email.setBounds(500, 20, 165, 25);
		contentPane.add(email);
		
		userLabel = new JLabel("Phone Number");
		userLabel.setBounds(350, 50, 160, 25);
		contentPane.add(userLabel);
		
		PhoneNum = new JTextField();
		PhoneNum.setBounds(500, 50, 165, 25);
		contentPane.add(PhoneNum);
		
		passwordLabel = new JLabel("Pin Number");
		passwordLabel.setBounds(350, 80, 160, 25);
		contentPane.add(passwordLabel);
		
		pinText = new JPasswordField();
		pinText.setBounds(500, 80, 165, 25);
		contentPane.add(pinText);
		pinText.setColumns(4);
		
		passwordLabel = new JLabel("Confirm Pin Number");
		passwordLabel.setBounds(350, 110, 160, 25);
		contentPane.add(passwordLabel);
		
		ConfirmPinText = new JPasswordField();
		ConfirmPinText.setBounds(500, 110, 165, 25);
		contentPane.add(ConfirmPinText);
		ConfirmPinText.setColumns(4);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		contentPane.add(success);
		success.setText(null);

		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.setBounds(250, 200, 302, 35);
		btnNewButton.setVisible(true);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user = fname.getText();
				try {
					acc = new Account(fname.getText(),lname.getText(),address.getText(),email.getText(),pinText.getText(),PhoneNum.getText());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(pinText.equals(ConfirmPinText)) {
					 success.setText("Sign Up Successful! The account has been created");
					
					}								
				try(FileWriter fw = new FileWriter("./src/LoginInfo.txt", true);
					    BufferedWriter bw = new BufferedWriter(fw);
					    PrintWriter out = new PrintWriter(bw))
					{
					    out.println(acc.getAccountNumber()+";"+acc.getPin()+";"+fname.getText()+";"+"0");
					    String message = "Your account number is: " + acc.getAccountNumber();
				        JOptionPane.showMessageDialog(null,message,"Account Number", JOptionPane.INFORMATION_MESSAGE);
						dispose();
				        Login window = new Login();
						window.frame.setVisible(true);
					} catch (IOException e1) {
					}
				
			}
		});

}
			
}
