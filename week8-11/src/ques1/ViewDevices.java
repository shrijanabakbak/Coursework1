package ques1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ViewDevices {
    public static void main(String[] args) {
        ViewDevices vb=new ViewDevices();
    }
    
    ViewDevices(){
        JFrame f= new JFrame("View Devices");
        f.getContentPane().setBackground(Color.WHITE);
        
        JButton btnUpdate,btnDelete,btnBack;
        
        
        btnBack=new JButton("Back");
        btnBack.setBorder(BorderFactory.createEmptyBorder());
        f.add(btnBack);
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(Color.BLACK);
        btnBack.setBounds(400,440,100,30);
        
        btnBack.addActionListener(e2->{
            new LoginFrame();
            f.dispose();
        });
        
        String column[]= {"Product ID","Product Name","Port","Model","Description"};
        ArrayList<String []> file_data = new ArrayList<String []>();
        try
        {
            File fileObj=new File("Device.txt");      
            fileObj.createNewFile();
            Scanner read=new Scanner(fileObj);    //file to be scanned
            //returns true if there is another line to read
            while(read.hasNextLine())
            {
            String mydata = read.nextLine();
            String arr[]=mydata.split(",");
            file_data.add(arr);
            }
            read.close();     //closes the scanner
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        Object data[][]=new Object[file_data.size()][column.length];
     
      for (int i=0; i<file_data.size(); i++) {
          data[i][0]=file_data.get(i)[0];
          data[i][1]= file_data.get(i)[1];
          data[i][2]= file_data.get(i)[2];
          data[i][3]=file_data.get(i)[3];
          data[i][4]=file_data.get(i)[4];
      }
        JTable jtEmp=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jtEmp);
        f.add(sp);
        sp.setBounds(200,30,800,400);
        
        btnUpdate=new JButton("Update");
        btnUpdate.setBackground(Color.WHITE);
        btnUpdate.setForeground(Color.BLACK);
        f.add(btnUpdate);
        btnUpdate.setBounds(200,440,100,30);
        
        btnDelete=new JButton("Delete");
        btnDelete.setBackground(Color.WHITE);
        btnDelete.setForeground(Color.BLACK);
        f.add(btnDelete);
        btnDelete.setBounds(300,440,100,30);
        
        btnDelete.addActionListener(e->{
            int row = jtEmp.getSelectedRow();
            if(row>=0) {
                TableModel model = jtEmp.getModel();
                String product_id = (String) model.getValueAt(row, 0);
                String data_to_write = "";
                for (Object[]item:data) {
                    if(!item[0].equals(product_id)) {
                        data_to_write += item[0] + "," + item[1] + "," + item[2] + ","+ item[3] + ","+ item[4] +"\n";
                    }
                }
                try {
                    FileWriter myWriter = new FileWriter("Device.txt");
                    myWriter.write(data_to_write);
                    myWriter.close();
                    JOptionPane.showMessageDialog(sp, "Selected Data Deleted");
                    f.dispose();
                    new ViewDevices();
                }
                catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(sp, "Select Row for Delete");
            }
        });
        
        btnUpdate.addActionListener(e->{
        int row1 = jtEmp.getSelectedRow();
        
        if(row1>=0) {
            
            JLabel lid = new JLabel("Id");
            f.add(lid);
            lid.setBounds(10, 490, 300, 50);
            JTextField tfid = new JTextField();
            f.add(tfid);
            tfid.setBounds(50, 500, 150, 30);
            
            JLabel lname = new JLabel("Name");
            f.add(lname);
            lname.setBounds(210, 490, 300, 50);
            JTextField tfname = new JTextField();
            f.add(tfname);
            tfname.setBounds(260, 500, 150, 30);
            
            JLabel lport = new JLabel("Port");
            f.add(lport);
            lport.setBounds(420, 490, 300, 50);
            JTextField tfport = new JTextField();
            f.add(tfport);
            tfport.setBounds(470, 500, 150, 30);
            
            JLabel lmodel = new JLabel("Model");
            f.add(lmodel);
            lmodel.setBounds(630, 490, 300, 50);
            JTextField tfmodel = new JTextField();
            f.add(tfmodel);
            tfmodel.setBounds(710, 500, 150, 30);
            
            JLabel ldescription = new JLabel("Description");
            f.add(ldescription);
            ldescription.setBounds(870, 490, 300, 50);
            JTextField tfdescription = new JTextField();
            f.add(tfdescription);
            tfdescription.setBounds(960, 500, 150, 30);
            
            JButton btnChange = new JButton("Make Change");
            f.add(btnChange);
            f.setFont(new Font("Serif",Font.BOLD,40));
            btnChange.setBounds(380, 580, 150, 40);
      
            btnChange.setBackground(Color.WHITE);
            btnChange.setForeground(Color.BLACK);
            
            JButton btnCancel = new JButton("Cancel");
            f.add(btnCancel);
            f.setFont(new Font("Serif",Font.BOLD,40));
            btnCancel.setBounds(620, 580, 150, 40);
            
            btnCancel.setBackground(Color.WHITE);
            btnCancel.setForeground(Color.BLACK);
            
            TableModel model = jtEmp.getModel();
            tfid.setText((String) model.getValueAt(row1, 0));
            tfname.setText((String) model.getValueAt(row1, 1));
            tfport.setText((String) model.getValueAt(row1, 2));
            tfmodel.setText((String) model.getValueAt(row1, 3));
            tfdescription.setText((String) model.getValueAt(row1, 4));
    
            btnChange.addActionListener(e1-> {
            String device_id= tfid.getText();
            String device_name = tfname.getText();
            String device_port=tfport.getText();
            String device_model=tfmodel.getText();
            String device_description = tfdescription.getText();
    
            String data_to_write = "";
    
            for(Object[] item: data) {
                for(int i=0; i<item.length; i++) {
                    if (item[0].equals(device_id)) {
                        item[1] = device_name;
                        item[2]= device_port;
                        item[3]= device_model;
                        item[4] = device_description;
                    }
                }
            }
        for (int i=0; i< data.length; i++) {
            int k=0;
            for (int j=0; j<data[i].length-1; j++) {
                data_to_write += data[i][j] + ",";
                k++;
            }
            data_to_write += data[i][k] + "\n";
        }
        try {
            FileWriter myWriter = new FileWriter("Device.txt");
            myWriter.write(data_to_write);
            myWriter.close();
            JOptionPane.showMessageDialog(sp, "Data updated");
            f.dispose();
            new ViewDevices();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        });
            
        btnCancel.addActionListener(e2->{
            new ViewDevices();
            f.dispose();
        });
        }
        else {
            JOptionPane.showMessageDialog(sp, "Select Row for Update");
        }
        });
        
        f.setLayout(null);
        f.setSize(1365,725);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
