package ques1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Register {
	public static void main(String[] args) {
		Register sig= new Register();

	}
	
	Register(){
		
		JFrame log= new JFrame("Register");
		
		
		
		ImageIcon backgroundimage= new ImageIcon("C:\\Users\\Latitude\\eclipse-workspace\\week8-11\\src\\ques1\\cg.jpg");
		
		Image img= backgroundimage.getImage();
		Image temp_img= img.getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
		backgroundimage= new ImageIcon(temp_img);
		JLabel background= new JLabel("",backgroundimage, JLabel.CENTER);
		log.add(background);
		background.setBounds(0, 0, 1200, 800);
		
		//font
		Font f= new Font("Serif",Font.BOLD,120);
		//JPanel
		JPanel jpan= new JPanel();
		background.add(jpan);
		jpan.setBounds(280, 80,630, 540);
		jpan.setBackground(new Color(0,0,0,125));
		jpan.setLayout(null);

		
		
		JLabel lUsername, lPassword, lCPassword, jsign;
		JTextField tfUsername;
		JPasswordField pfPassword, pfCPassword;
		JButton btnSignUp, btnCancel;
		
		
		jsign= new JLabel("SignUp  Form");
		jpan.add(jsign);
		jsign.setBounds(330, 10, 300, 100);
		jsign.setFont(new Font("Serif", Font.BOLD, 30));
		jsign.setForeground(Color.WHITE);
		
		lUsername= new JLabel("Username");
		jpan.add(lUsername);
		lUsername.setBounds(120, 150, 300, 30);
		lUsername.setFont(new Font("Arial", Font.BOLD,15));
		lUsername.setForeground(Color.WHITE);
		
		tfUsername= new JTextField(30);
		jpan.add(tfUsername);
		tfUsername.setBounds(265, 150, 330, 30);
		
		
		
		lPassword= new JLabel("Password");
		jpan.add(lPassword);
		lPassword.setBounds(120, 200, 300, 30);
		lPassword.setFont(new Font("Arial", Font.BOLD,15));
		lPassword.setForeground(Color.WHITE);
			
		pfPassword= new JPasswordField(30);
		jpan.add(pfPassword);
		pfPassword.setBounds(265, 200, 330, 30);
		
		
		lCPassword= new JLabel("Confirm Password");
		jpan.add(lCPassword);
		lCPassword.setBounds(120, 250, 300, 30);
		lCPassword.setFont(new Font("Arial", Font.BOLD,15));
		lCPassword.setForeground(Color.WHITE);
			
		pfCPassword= new JPasswordField(30);
		jpan.add(pfCPassword);
		pfCPassword.setBounds(265, 250, 330, 30);
		
		
		btnSignUp = new JButton("Signup");
		jpan.add(btnSignUp);
		btnSignUp.setBounds(265, 330, 140, 40);
		btnSignUp.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		btnSignUp.setForeground(Color.green);
        
		
		btnCancel = new JButton("Cancel");
		jpan.add(btnCancel);
		btnCancel.setBounds(450, 330, 140, 40);
		btnCancel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		btnCancel.setForeground(Color.red);
        
		
		btnCancel.addActionListener(e->{
			int select= JOptionPane.showConfirmDialog(btnCancel,"Are you sure?");
			if (select==0) {
				new LoginFrame();
				log.dispose();
			}
			
		});
		
		btnSignUp.addActionListener(e->{
			String username= tfUsername.getText();
			String password= pfPassword.getText();
			String cpassword= pfCPassword.getText();
			
			try {
				FileWriter myWriter= new FileWriter("Register.txt");
				myWriter.write(username+","+password+","+cpassword);
				myWriter.close();
				JOptionPane.showMessageDialog(btnSignUp, "Registered Successfully");
				System.out.println("Successfully wrote to the file.");
			}catch(IOException e1) {
				System.out.println("An error occured.");
				e1.printStackTrace();
			}
			new LoginFrame();
			log.dispose();		
		
			
		});
		
				
		log.setLayout(null);
		log.setSize(1000,600);
		log.setVisible(true);
		log.setLocationRelativeTo(null);
		log.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}

}

