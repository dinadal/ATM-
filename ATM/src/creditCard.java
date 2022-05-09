import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.util.ArrayList;
import java.io.*;
//
//--

public class creditCard extends JFrame {
	

	//String fullName = "Alice J. Brown";  //Will be taken from file later
	

	String fullName = "Alice J. Brown";  //Will be taken from file later
	//	String fullName = Login.name;  //Is taken from file

//	File file = new File("src/RouterInfo.txt");
//	Scanner infile = new Scanner(System.in);
//	String n = infile.nextLine();
	

//**
	String name = Login.name; 
	String nameS = String.valueOf(name);
//	

	
	
	Random cardRandomNumberI = new Random(); 
	Random cardRandomNumberII = new Random();
	Random cardRandomNumberIII = new Random();
	Random cardRandomNumberIV = new Random();
	
	
	int I  = 10000;
	int II = 10000;
	int III = 10000;
	int IV  = 10000;
	
	int intRandomI = cardRandomNumberI.nextInt(I);
	int intRandomII = cardRandomNumberI.nextInt(II);
	int intRandomIII = cardRandomNumberI.nextInt(III);
	int intRandomIV = cardRandomNumberI.nextInt(IV);
	
	String randomCardI = String.valueOf(intRandomI);
	String randomCardII = String.valueOf(intRandomII);
	String randomCardIII = String.valueOf(intRandomIII);
	String randomCardIV = String.valueOf(intRandomIV);
	
	String Number = randomCardI + " " + randomCardII + " " + randomCardIII + " " + randomCardIV;
	
	//Date dateOnCard = new Date(); //MM/YY
	GregorianCalendar date = new GregorianCalendar();
	int year = date.get(GregorianCalendar.YEAR) + 4;	
	int month = date.get(GregorianCalendar.MONTH);
	//int day = date.get(GregorianCalendar.DAY_OF_MONTH);
	
	//year = year + 4;
	
	String cardDate = String.valueOf(month) +"/"+ String.valueOf(year);
	
	
/*		jBtnEnter.setIcon(new ImageIcon("/Users/dina_dal/Desktop/Icons/enter.jpeg"));
		jBtnEnter.setBounds(410, 230, 101, 64);
		panel_3.add(jBtnEnter);
		*/

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creditCard frame = new creditCard();
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
	public creditCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setBorder(new LineBorder(new Color(0, 128, 128), 7, true));
		//setBackground(new Color(0, 100, 0));
		
		JLabel cardHolderName = new JLabel("Customer Name");
		cardHolderName.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 22));
		cardHolderName.setBounds(34, 245, 270, 28);
		getContentPane().add(cardHolderName);
		//cardHolderName.setText(fullName);
		
		//More code here
		//failed attempt to get name from file
		/*
	    try {
	        File myObj = new File("RouterInfo.txt");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	         // System.out.println(data); 
	          cardHolderName.setText(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	      */
	    
		
		  cardHolderName.setText(nameS);
		  //cardHolderName.setText(fullName);
		
		JLabel cardNumber = new JLabel("New label");
		cardNumber.setForeground(Color.GRAY);
		cardNumber.setFont(new Font("Kannada Sangam MN", Font.PLAIN, 28));
		cardNumber.setBounds(34, 174, 385, 37);
		getContentPane().add(cardNumber);
		cardNumber.setText(Number);
		
		JLabel dateLabel = new JLabel("New label");
		dateLabel.setBounds(299, 207, 97, 28);
		getContentPane().add(dateLabel);
		dateLabel.setText(cardDate);
		
		JLabel masterCard = new JLabel("");
		masterCard.setBounds(341, 6, 107, 114);
		getContentPane().add(masterCard);
		//masterCard.setIcon(new ImageIcon(creditCard.class.getResource("images/Mastercard-logo.png")));
		//masterCard.setIcon(new ImageIcon(new ImageIcon("images/Mastercard-logo.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		ImageIcon image = new ImageIcon (creditCard.class.getResource("images/Mastercard-logo.png"));
	    Image newimg = image.getImage().getScaledInstance(60,40, java.awt.Image.SCALE_SMOOTH); 
	    image=new ImageIcon(newimg); 
	    
	    masterCard.setIcon(image);
	    
	    JLabel chipLabel = new JLabel("");
	    chipLabel.setBounds(46, 95, 82, 77);
	    getContentPane().add(chipLabel);
	    
		ImageIcon image2 = new ImageIcon (creditCard.class.getResource("images/chip.jpg"));
	    Image newimg2 = image2.getImage().getScaledInstance(70,50, java.awt.Image.SCALE_SMOOTH); 
	    image2=new ImageIcon(newimg2); 
	    chipLabel.setIcon(image2);
	    
	    JLabel lblNewLabel = new JLabel("National City Bank");
	    lblNewLabel.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 25));
	    lblNewLabel.setForeground(new Color(0, 51, 51));
	    lblNewLabel.setBounds(24, 40, 241, 43);
	    getContentPane().add(lblNewLabel);
	    
	    JLabel madaLabel = new JLabel("");
	    madaLabel.setBounds(341, 112, 120, 43);
	    contentPane.add(madaLabel);
	    
		ImageIcon image3 = new ImageIcon (creditCard.class.getResource("images/mada.png"));
	    Image newimg3 = image3.getImage().getScaledInstance(70,50, java.awt.Image.SCALE_SMOOTH); 
	    image3=new ImageIcon(newimg3); 
	    madaLabel.setIcon(image3);
	    
	  //Main Menu button
	  		JButton backButton = new JButton("Main Menu");
	  		backButton.setBounds(34, 300, 270, 28);
	  		backButton.addActionListener(new ActionListener() {
	  			public void actionPerformed(ActionEvent m) {
	  				dispose();
	  				// main frame should be here
	  				MainMenu panel = new MainMenu();
	  				panel.frame.setVisible(true);
	  				}
	  		});
	  		contentPane.add(backButton);
	    
	}

}
