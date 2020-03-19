import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.sql.*;*/
public class AddStudent extends JFrame  implements ActionListener 
{
	JFrame addStudentForm;
	JTextField uniqueNumber;
	JTextField name,address,department,roomNumber;
	JButton saveBtn,clearBtn,exitBtn;			
	public AddStudent()
	{
		addStudentForm=new JFrame();
		addStudentForm.setTitle("AddStudent to Hostem Management System");
		addStudentForm.setBounds(100,100,400,420);
		addStudentForm.setLayout(null);		

		JLabel l1=new JLabel("Fill out following details");
		JLabel l2=new JLabel("Name : ");
		JLabel l3=new JLabel("Address : ");
		JLabel l4=new JLabel("Department : ");
		JLabel l5=new JLabel("Room Number : ");
		
		l1.setBounds(10,10,200,50);
		l2.setBounds(10,70,100,50);
		l3.setBounds(10,130,100,50);
		l4.setBounds(10,190,100,50);
		l5.setBounds(10,250,100,50);
		
		
		uniqueNumber = new JTextField(30);
		name = new JTextField(20);
		address = new JTextField(20);
		department = new JTextField(20);
		roomNumber = new JTextField(20);

		uniqueNumber.setBounds(120,10,200,50);		
		name.setBounds(120,70,200,50);
		address.setBounds(120,130,200,50);
		department.setBounds(120,190,200,50);
		roomNumber.setBounds(120,250,200,50);

		saveBtn = new JButton("saveBtn");
		clearBtn = new JButton("clearBtn");
		exitBtn = new JButton("exitBtn");
		saveBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		saveBtn.setBounds(50,320,100,30);
		clearBtn.setBounds(160,320,100,30);
		exitBtn.setBounds(270,320,100,30);

		addStudentForm.add(l1);
		addStudentForm.add(l2);		
		addStudentForm.add(l3);	
		addStudentForm.add(l4);	
		addStudentForm.add(l5);	
		//addStudentForm.add(uniqueNumber);		
		addStudentForm.add(name);
		addStudentForm.add(address);
		addStudentForm.add(department);				
		addStudentForm.add(roomNumber); 		
		addStudentForm.add(saveBtn);
		addStudentForm.add(clearBtn);
		addStudentForm.add(exitBtn);

		addStudentForm.setResizable(false);
		addStudentForm.setVisible(true);
		addStudentForm.addWindowListener(new close());
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			addStudentForm.dispose();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{		
		if(ae.getSource()== saveBtn)
		{			
			try{				
				String query = "insert into students (name,address,department,roomno) values ('"+name.getText()+"','"+address.getText()+"','"+
					department.getText()+"',"+roomNumber.getText()+")";				
				if(SQLResultSetGenerator.insertData(query)){                               		
					JOptionPane.showMessageDialog(null, "Student added successfully");
					name.setText("");
					address.setText("");
					department.setText("");
					roomNumber.setText("");
            	}else{
					JOptionPane.showMessageDialog(null, "Error ! \nSomething wen't wrong!!!");
            	}			
      		}catch(Exception ee){
      			JOptionPane.showMessageDialog(null, "Error : "+ee);      			
      		}	
		}	
		if(ae.getSource()==clearBtn)
		{
			//uniqueNumber.setText("");
			name.setText("");
			address.setText("");
			department.setText("");
			roomNumber.setText("");
		}
		if(ae.getSource()==exitBtn)
			addStudentForm.dispose();
	}
	/*public static void main(String str[]) throws Exception
	{
		AddStudent obj=new AddStudent();
	}*/
}
