import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MainMenu {

	public JFrame frame;
	private JTextField JLabDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(22, 6, 172, 188);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setBounds(25, 29, 117, 52);
		panel.add(btnBalance);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
					
					@Override  //Takes the user to the withdraw frame
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						WithdrawFrame panel = new WithdrawFrame();
						panel.setVisible(true);
						panel.setLocation(400,250);
					}
					
				});
		btnWithdraw.setBounds(25, 105, 117, 52);
		panel.add(btnWithdraw);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(206, 6, 200, 188);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabDisplay = new JTextField();
		JLabDisplay.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		JLabDisplay.setBounds(6, 22, 188, 133);
		panel_1.add(JLabDisplay);
		JLabDisplay.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(414, 6, 180, 188);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(24, 25, 120, 52);
		btnDeposit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			DepositeFrame panel = new DepositeFrame();
			panel.setVisible(true);
			panel.setLocation(400,250);
		}
		
	});
		panel_2.add(btnDeposit);
		
		JButton btnMiniState = new JButton("Mini Statement");
		btnMiniState.setBounds(24, 101, 120, 52);
		panel_2.add(btnMiniState);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(16, 206, 578, 356);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton jBtn2 = new JButton("");
		jBtn2.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/2.jpeg")));
		jBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "2";
				JLabDisplay.setText(enterNumber);
			}
		});
		jBtn2.setBounds(184, 25, 101, 64);
		panel_3.add(jBtn2);
		
		JButton jBtn3 = new JButton("");
		jBtn3.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/3.jpeg")));
		jBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "3";
				JLabDisplay.setText(enterNumber);
			}
		});
		jBtn3.setBounds(297, 25, 101, 64);
		panel_3.add(jBtn3);
		
		JButton jBtn5 = new JButton("");
		jBtn5.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/5.jpeg")));
		jBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "5";
				JLabDisplay.setText(enterNumber);
			}
		});
		jBtn5.setBounds(184, 101, 101, 64);
		panel_3.add(jBtn5);
		
		JButton jBtn4 = new JButton("");
		jBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "4";
				JLabDisplay.setText(enterNumber);
			}
		});
			
		jBtn4.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/4.jpeg")));
		jBtn4.setBounds(71, 101, 101, 64);
		panel_3.add(jBtn4);
		
		JButton jBtn6 = new JButton("");
		jBtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "6";
				JLabDisplay.setText(enterNumber);
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
				String enterNumber = JLabDisplay.getText() + "8";
				JLabDisplay.setText(enterNumber);
			}
		});
		jBtn8.setBounds(184, 176, 101, 64);
		panel_3.add(jBtn8);
		
		JButton jBtn7 = new JButton("");
		jBtn7.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/7.jpeg")));
		jBtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "7";
				JLabDisplay.setText(enterNumber);
			}
		});
		jBtn7.setBounds(71, 176, 101, 64);
		panel_3.add(jBtn7);
		
		JButton jBtn9 = new JButton("");
		jBtn9.setIcon(new ImageIcon(MainMenu.class.getResource("/Icons/9.jpeg")));
		jBtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNumber = JLabDisplay.getText() + "9";
				JLabDisplay.setText(enterNumber);
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
				String enterNumber = JLabDisplay.getText() + "0";
				JLabDisplay.setText(enterNumber);
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
				String enterNumber = JLabDisplay.getText() + "1";
				JLabDisplay.setText(enterNumber);
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
