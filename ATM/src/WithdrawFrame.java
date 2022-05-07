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
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;		
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class WithdrawFrame extends JFrame {
	private JTextField jLabDisplay;
	public JFrame frame;
	private JPanel contentPane;
	private JTextField txtTf;
	private JTextField balanceText;
	private JTextField nonNegative1;
	
	//Takes balance from Login class
	double balance = Login.balance;  
	String balanceS = String.valueOf(balance);

	//Launch the application
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

	//Create the frame
	public WithdrawFrame() {
		
		setTitle("Withdraw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 589);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter the amount that you want to withdraw");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 67, 317, 26);
		contentPane.add(lblNewLabel);

		jLabDisplay = new JTextField();
		jLabDisplay.setBounds(184, 95, 209, 78);
		contentPane.add(jLabDisplay);
		jLabDisplay.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		jLabDisplay.setColumns(10);
		

		nonNegative1 = new JTextField();
		nonNegative1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		nonNegative1.setEditable(false);
		nonNegative1.setBackground(SystemColor.window);
		nonNegative1.setBounds(10, 109, 162, 52);
		contentPane.add(nonNegative1);
		nonNegative1.setColumns(10);
		
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
		
		//Main Menu Button
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
		
		//ok Button
		JButton btnNewButton = new JButton("ok");
		btnNewButton.setBounds(405, 107, 159, 56);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//The "ok" button
				//Subtracts the withdrawn amount from the balance
				String withdrawAmount;
				withdrawAmount = jLabDisplay.getText();				
				double withdrawD = Double.parseDouble(withdrawAmount);
				nonNegative1.setText(null);
				if (withdrawD < 0) {
					nonNegative1.setText("Error: negative amount!");
		        }
				else {
					String b = Double. toString(balance);
					balance = balance - withdrawD; //answer as double
					String newBalance = String.valueOf(balance);
					balanceText.setText(newBalance);
					nonNegative1.setText("Balance updated");
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter out = null;
					try {
						updateFile();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					    try {
							fw = new FileWriter("./src/RounterInfo.txt", true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    bw = new BufferedWriter(fw);
					    out = new PrintWriter(bw);
					    String text = Login.accNum_from_file+";"+Login.password_form_file+";"+Login.name+";"+b;
					    text.replaceAll(text, "");
					    out.println(Login.accNum_from_file+";"+Login.password_form_file+";"+Login.name+";"+newBalance);
					    out.close();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 205, 571, 336);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		//frame.getContentPane().add(panel);
		panel.setLayout(null);

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
		panel.add(jBtn0);
				
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
		panel.add(jBtn1);
				
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
		panel.add(jBtn2);
				
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
		panel.add(jBtn3);
				
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
		panel.add(jBtn4);
		
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
		panel.add(jBtn5);
		
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
		panel.add(jBtn6);
		
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
		panel.add(jBtn7);
		
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
		panel.add(jBtn8);
		
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
		panel.add(jBtn9);
				
		//Clear button
		JButton jBtnClear = new JButton("");
		jBtnClear.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/clear.jpeg"));
		jBtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jLabDisplay.setText("");
				nonNegative1.setText("");
				
			}
		});
		jBtnClear.setBounds(410, 140, 101, 64);
		panel.add(jBtnClear);
		
		//Enter button
		JButton jBtnEnter = new JButton("");
		jBtnEnter.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/enter.jpeg"));
		jBtnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//The "ok" button
				//Subtracts the withdrawn amount from the balance
				String withdrawAmount;
				withdrawAmount = jLabDisplay.getText();				
				double withdrawD = Double.parseDouble(withdrawAmount);
				nonNegative1.setText(null);
				if (withdrawD < 0) {
					nonNegative1.setText("Error: negative amount!");
		        }
				else {
					String b = Double. toString(balance);
					balance = balance - withdrawD; //answer as double
					String newBalance = String.valueOf(balance);
					balanceText.setText(newBalance);
					nonNegative1.setText("Balance updated");
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter out = null;
					try {
						updateFile();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					    try {
							fw = new FileWriter("./src/RounterInfo.txt", true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    bw = new BufferedWriter(fw);
					    out = new PrintWriter(bw);
					    String text = Login.accNum_from_file+";"+Login.password_form_file+";"+Login.name+";"+b;
					    text.replaceAll(text, "");
					    out.println(Login.accNum_from_file+";"+Login.password_form_file+";"+Login.name+";"+newBalance);
					    out.close();
				}
			}
		});
		jBtnEnter.setBounds(410, 230, 101, 64);
		panel.add(jBtnEnter);
		
		//Cancel button
		JButton jBtnCancel = new JButton("");
		jBtnCancel.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/cancel.jpeg"));
		jBtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				dispose();
				// main frame should be here
				MainMenu panel = new MainMenu();
				panel.frame.setVisible(true);
				}
		});
		jBtnCancel.setBounds(410, 45, 101, 64);
		panel.add(jBtnCancel);
		
	}
	//Updates new balance to the text file
	public void updateFile() throws IOException {
		File inputFile = new File("./src/RounterInfo.txt");
        File tempFile = new File("./src/myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.startsWith(Login.accNum_from_file)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        boolean successful = tempFile.renameTo(inputFile);
        System.out.println(successful);
	}
	
}
