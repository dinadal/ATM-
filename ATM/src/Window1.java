import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Window1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showWindow();

	}
	//

	public static void showWindow() {

		JFrame frame = new JFrame("WINDOW 1");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);

		frame.setBounds (100,100,583,383);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout (null);
		
		JButton btnNewButton = new JButton("deposit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(132, 181, 111, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("withdraw");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(327, 181, 102, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to your acount");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(28, 27, 286, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please select the desired process");
		lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(146, 104, 298, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override //Takes the user to the deposite frame
			public void actionPerformed(ActionEvent e) {
				DepositeFrame panel = new DepositeFrame();
				panel.setVisible(true);
				panel.setLocation(400,250);
			}
			
		});
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
					
					@Override  //Takes the user to the withdraw frame
					public void actionPerformed(ActionEvent e) {
						WithdrawFrame panel = new WithdrawFrame();
						panel.setVisible(true);
						panel.setLocation(400,250);
					}
					
				});
		

		frame.setVisible(true);
	}
}