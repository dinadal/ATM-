import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Window2 {
	
		public static void main(String[] args) {
			showWindow();
			// TODO Auto-generated method stub
		}
		
		
		public static void showWindow() {
		
			JFrame frame = new JFrame("WINDOW 1");
			
			frame.setBounds (100,100,467,315); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.getContentPane().setLayout (null);
			
			JLabel lblNewLabel = new JLabel("the function");
			lblNewLabel.setBackground(SystemColor.controlDkShadow);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel.setBounds(155, 92, 174, 62);
			frame.getContentPane().add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Back");
			btnNewButton.setBackground(SystemColor.inactiveCaption);
			btnNewButton.setBounds(10, 22, 89, 23);
			frame.getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					frame.setVisible(false);
					Window1 w1 = new Window1();
					w1.showWindow();
				}
			
			});
			
			
			frame.setVisible(true);
			
		}
	}