package ques1;

import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;

public class LoginFrame {
	public static void main(String[] args) {
		LoginFrame regobj=new LoginFrame();
		
	}

	LoginFrame(){
		JFrame log= new JFrame("Login Page");
		
			
		ImageIcon backgroundimage= new ImageIcon("C:\\Users\\Latitude\\eclipse-workspace\\week8-11\\src\\ques1\\bg.jpg");
		
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

			
		
		JLabel  lUsername, lPassword, jreg;
		JTextField tfUsername;
		JPasswordField pfPassword;
		JButton btnLogin,btnCancel;
		
		jreg = new JLabel("Login  Form");
		jpan.add(jreg);
		jreg.setBounds(250, 10, 300, 100);
		jreg.setFont(new Font("Serif",Font.BOLD,30));
		jreg.setForeground(Color.WHITE);
		
			 
		
		lUsername= new JLabel("Username");
		jpan.add(lUsername);
		lUsername.setBounds(60, 140, 300, 40);
		lUsername.setFont(new Font("Arial",Font.BOLD,15));
		lUsername.setForeground(Color.WHITE);
		
		tfUsername= new JTextField(30);
		jpan.add(tfUsername);
		tfUsername.setBounds(180, 140, 330, 30);
		
		
		
		lPassword= new JLabel("Password");
		jpan.add(lPassword);
		lPassword.setBounds(60, 220, 300, 40);
		lPassword.setFont(new Font("Arial",Font.BOLD,15));
		lPassword.setForeground(Color.WHITE);
		
		pfPassword= new JPasswordField(30);
		jpan.add(pfPassword);
		pfPassword.setBounds(180, 220, 330, 30);
		
		// login
		btnLogin = new JButton("Login");
		jpan.add(btnLogin);
		btnLogin.setBounds(160, 400, 130, 40);
		btnLogin.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		btnLogin.setForeground(Color.green);

		btnLogin.addActionListener(e->{
			String user=  tfUsername.getText();
			String pass= pfPassword.getText();
			
		boolean res= userLogin(user,pass);
		if(res) {
			JOptionPane.showMessageDialog(btnLogin, " Successfully Login ");
			new AddDevices();
			log.dispose();
		}else {
			JOptionPane.showMessageDialog(btnLogin, "Username or Password Invalid");
		}
		});
		
		btnCancel = new JButton("Cancel");
		jpan.add(btnCancel);
		btnCancel.setBounds(340, 400, 130, 40);
		btnCancel.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		btnCancel.setForeground(Color.red);

		
		btnCancel.addActionListener(e->{
			int select= JOptionPane.showConfirmDialog(btnCancel,"Are you sure?");
			if (select==0) {
				log.dispose();
			}
			});
			
				
		log.setLayout(null);
		log.setSize(1200,800);
		log.setVisible(true);
		log.setLocationRelativeTo(null);
		log.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public boolean userLogin(String user, String pass) {
		ArrayList<String[]> data_from_file= new ArrayList<String[]>();
		try {
			File myObj= new File("Register.txt");
			myObj.createNewFile();
			Scanner myReader= new Scanner(myObj);
			
			while(myReader.hasNextLine()) {
				String data= myReader.nextLine();
				String arr[]= data.split(",");
				data_from_file.add(arr);
				}
			myReader.close();
			
		
	}catch(IOException e){
		e.printStackTrace();
		
	}
	for(String[] arr:data_from_file) {
		if(user.equals(arr[0])&& pass.equals(arr[1])) {
			return true;
		}
	}
	
	return false;
}
	


}

