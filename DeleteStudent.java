import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class DeleteStudent extends JFrame  implements ActionListener 
{
	JFrame deleteStudentForm;
	JTextField uniqueNumber;	
	JButton deleteBtn,clearBtn,exitBtn;	
	public DeleteStudent()
	{
		deleteStudentForm=new JFrame();
		deleteStudentForm.setTitle("DeleteStudent from Hostem Management System");
		deleteStudentForm.setBounds(100,100,400,270);
		deleteStudentForm.setLayout(null);		

		JLabel l1=new JLabel("Unique Number : ");		
		
		l1.setBounds(10,30,100,50);		
		
		uniqueNumber = new JTextField(30);
		uniqueNumber.setBounds(120,30,200,50);				

		deleteBtn = new JButton("deleteBtn");
		clearBtn = new JButton("clearBtn");
		exitBtn = new JButton("exitBtn");
		deleteBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		deleteBtn.setBounds(50,160,100,30);
		clearBtn.setBounds(160,160,100,30);
		exitBtn.setBounds(270,160,100,30);

		deleteStudentForm.add(l1);
		deleteStudentForm.add(uniqueNumber);				
		deleteStudentForm.add(deleteBtn);
		deleteStudentForm.add(clearBtn);
		deleteStudentForm.add(exitBtn);

		deleteStudentForm.setResizable(false);
		deleteStudentForm.setVisible(true);
		deleteStudentForm.addWindowListener(new close());
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			deleteStudentForm.dispose();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{		
		if(ae.getSource()== deleteBtn)
		{			
			try{
				String query = "delete from students where id="+uniqueNumber.getText();
				if(SQLResultSetGenerator.insertData(query)){                               		
					JOptionPane.showMessageDialog(null, "Student deleted successfully");					
            	}else{
					JOptionPane.showMessageDialog(null, "Error ! \nSomething wen't wrong!!!");
            	}				
      		}catch(Exception ee){
      			JOptionPane.showMessageDialog(null, "Error : "+ee);      			
      		}	
		}	
		if(ae.getSource()==clearBtn)
		{
			uniqueNumber.setText("");			
		}
		if(ae.getSource()==exitBtn)
			deleteStudentForm.dispose();
	}
	/*public static void main(String str[]) throws Exception
	{
		DeleteStudent obj=new DeleteStudent();
	}*/
}
