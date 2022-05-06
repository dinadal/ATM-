import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class miniStatement  extends JFrame implements ActionListener{
	private JPanel contentPane;

		
		public miniStatement() {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setBounds(200, 200, 800, 300);
			contentPane = new JPanel();
			contentPane.setToolTipText("");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			JFrame frame = new JFrame ("Ministatement");
			String [] [] data= {
					{"001","Shaymaa", "200", "1000"}//example
			};
			
			String[] columnNames = {"Account Number", "Name" , "Amount", "Balance"};
			JTable table = new JTable(data, columnNames);
			frame.add(new JScrollPane(table));
			frame.setVisible(true);
			frame.setSize(500,500);
		
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scanner sc = new Scanner(new BufferedReader(new FileReader("./src/RounterInfo.txt")));
				      int rows = 4;
				      int columns = 4;
				      int [][] myArray = new int[rows][columns];
				      while(sc.hasNextLine()) {
				         for (int i=0; i<myArray.length; i++) {
				            String[] line = sc.nextLine().trim().split(" ");
				            
				            for (int j=0; j<line.length; j++) {
				               myArray[i][j] = Integer.parseInt(line[j]);
				            }
				         }
				      }
				      System.out.println(Arrays.deepToString(myArray));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
