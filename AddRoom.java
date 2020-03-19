import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class AddRoom extends JFrame  implements ActionListener 
{
	JFrame addRoomForm;
	JTextField roomNumber;
	JTextField capacity;
	JButton saveBtn,clearBtn,exitBtn;			
	public AddRoom()
	{
		addRoomForm=new JFrame();
		addRoomForm.setTitle("AddRoom to Hostem Management System");
		addRoomForm.setBounds(100,100,400,270);
		addRoomForm.setLayout(null);		

		JLabel l1=new JLabel("Room Number : ");
		JLabel l2=new JLabel("Capicity : ");
		
		l1.setBounds(10,10,100,50);
		l2.setBounds(10,70,100,50);
		
		roomNumber = new JTextField(30);
		capacity = new JTextField(20);
		roomNumber.setBounds(120,10,200,50);		
		capacity.setBounds(120,70,200,50);

		saveBtn = new JButton("Save");
		clearBtn = new JButton("Clear");
		exitBtn = new JButton("Exit");
		saveBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		saveBtn.setBounds(50,160,100,30);
		clearBtn.setBounds(160,160,100,30);
		exitBtn.setBounds(270,160,100,30);

		addRoomForm.add(l1);
		addRoomForm.add(l2);		
		addRoomForm.add(roomNumber);		
		addRoomForm.add(capacity);
		addRoomForm.add(saveBtn);
		addRoomForm.add(clearBtn);
		addRoomForm.add(exitBtn);

		addRoomForm.setResizable(false);
		addRoomForm.setVisible(true);
		addRoomForm.addWindowListener(new close());
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			addRoomForm.dispose();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{		
		if(ae.getSource()== saveBtn)
		{			
			try{
				String query = "insert into rooms (no,capacity,allocated) values ("+roomNumber.getText()+","+capacity.getText()+",0)";				
				if(SQLResultSetGenerator.insertData(query)){                               		
					JOptionPane.showMessageDialog(null, "Room number added");
            	}else{
					JOptionPane.showMessageDialog(null, "Error ! \nRoom number already exist");
            	}			
      		}catch(Exception ee){
      			JOptionPane.showMessageDialog(null, "Error : "+ee);      			
      		}				
		}	
		if(ae.getSource()==clearBtn)
		{
			roomNumber.setText("");
			capacity.setText("");
		}
		if(ae.getSource()==exitBtn)
			addRoomForm.dispose();
	}
	// public static void main(String str[]) throws Exception
	// {
	// 	AddRoom obj=new AddRoom();
	// }
}