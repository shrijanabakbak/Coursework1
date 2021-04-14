package ques1;
	
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.Font;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.*;

public class AddDevices {
	public static void main(String[] args) {
			AddDevices obj = new AddDevices();
			
			try {
				File myObj= new File("Device.txt");
				if (myObj.createNewFile()) {
					System.out.println("File created:" +myObj.getName());
				}else {
					System.out.println("File already exists.");
				}
				
			}catch(IOException e) {
				System.out.println("An error occoured");
				e.printStackTrace();
			}
		}
		
		AddDevices(){
			JFrame  log = new JFrame("Add Devices");
			JLabel title= new JLabel("  Device Details");
			log.add(title);
			title.setBounds(230, 0, 500, 200);
			title.setFont(new Font("Felix Titling", Font.BOLD,30));
			
			JLabel lId, lName, lPort, lModel,lDesc;
			JTextField tfId;
			JTextField tfName;
			JTextField tfPort;
			JTextField tfModel;
			JTextField tfDesc;
			
			JButton btnAdd, btnView;
			
			
			lId= new JLabel(" Product ID");
			log.add(lId);
			lId.setBounds(150, 180, 300, 30);
			tfId= new JTextField(50);
			log.add(tfId);
			tfId.setBounds(250, 180, 330, 30);
			
			
			lName= new JLabel("Name");
			log.add(lName);
			lName.setBounds(150, 230, 300, 30);
			tfName= new JTextField(50);
			log.add(tfName);
			tfName.setBounds(250, 230, 330, 30);
			
			lPort= new JLabel("Port");
			log.add(lPort);
			lPort.setBounds(150, 280, 300, 30);
			tfPort= new JTextField(50);
			log.add(tfPort);
			tfPort.setBounds(250, 280, 330, 30);
			

			lModel= new JLabel("Model");
			log.add(lModel);
			lModel.setBounds(150, 330, 300, 30);
			tfModel= new JTextField(50);
			log.add(tfModel);
			tfModel.setBounds(250, 330, 330, 30);
			

			lDesc= new JLabel("Desc");
			log.add(lDesc);
			lDesc.setBounds(150, 380, 300, 30);
			tfDesc= new JTextField(50);
			log.add(tfDesc);
			tfDesc.setBounds(250, 380, 330, 30);
			
			btnAdd = new JButton("Add");
			log.add(btnAdd);
			btnAdd.setBounds(250, 440, 130, 40);
			btnAdd.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			btnAdd.setForeground(Color.green);
			
			btnAdd.addActionListener(e->{
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter ("Device.txt", true));
					int id = Integer.parseInt(tfId.getText());
					String name=tfName.getText();
	                String port=tfPort.getText();
					String model = tfModel.getText();
					String desc= tfDesc.getText();
					bw.write(id+" ,"+name+" ,"+port+" ,"+ model+","+desc);
					bw.flush();
					bw.newLine();
					bw.close();
					JOptionPane.showMessageDialog(btnAdd, "Device Added Successfully");
					System.out.println(" Succesfully Added");
	                tfId.setText("");
	                tfName.setText("");
	                tfPort.setText("");
	                tfModel.setText("");
	                tfDesc.setText("");
					
					}catch(IOException e1) {
						System.out.println("An error occoured");
						e1.printStackTrace();
					}
					
					new ViewDevices();
					log.dispose();
			});
			

			btnView = new JButton("View");
			log.add(btnView);
			btnView.setBounds(440, 440, 130, 40);
			btnView.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
			btnView.setForeground(Color.green);
			
			
			btnView.addActionListener(e->{
				new ViewDevices();
				log.dispose();
			});
			
			ImageIcon backgroundimage= new ImageIcon("C:\\Users\\Latitude\\eclipse-workspace\\week8-11\\src\\ques1\\gg.jpg");
			
			Image img= backgroundimage.getImage();
			Image temp_img= img.getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
			backgroundimage= new ImageIcon(temp_img);
			JLabel background= new JLabel("",backgroundimage, JLabel.CENTER);
			log.add(background);
			background.setBounds(0, 0, 1200, 800);
		
			
			
			log.setLayout(null);
			log.setSize(800,600);
			log.setVisible(true);
			log.setLocationRelativeTo(null);
			log.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	 
	}	
		
	}

	
	

