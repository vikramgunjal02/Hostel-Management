import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class InOutTimeForm extends JFrame  implements ActionListener 
{
	JFrame inOutTimeForm;
	JComboBox prn,type;
	JTextField time;
	JButton save,clear,exit;
	JComboBox dd,mm,yy,ampm;
	String[] s1 = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] s2 = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	String[] s3 = {"2015","2016","2017","2018","2019","2020"};
	String[] s4 ={"AM","PM"};
	String[] s5 ={"IN","OUT"};
	String[] studentsList = new String[500];
	public InOutTimeForm()
	{
		inOutTimeForm=new JFrame();
		inOutTimeForm.setTitle("Register in out entry");
		inOutTimeForm.setBounds(100,100,400,320);
		inOutTimeForm.setLayout(null);
		//inOutTimeForm.getContentPane().setBackground(new Color(150,150,150));

		JLabel l1=new JLabel("Student Number : ");
		JLabel l2=new JLabel("DATE : ");
		JLabel l3=new JLabel("TIMING: ");
		JLabel l4=new JLabel("Entry Type: ");

		l1.setBounds(10,10,120,50);
		l2.setBounds(10,70,120,50);
		l3.setBounds(10,130,120,50);
		l4.setBounds(10,190,120,50);

		dd=new JComboBox(s1);
		//dd.setBackground(Color.gray);
 		dd.setForeground(Color.black);
		dd.setBounds(140,70,50,50);

		mm=new JComboBox(s2);
		//mm.setBackground(Color.gray);
  		mm.setForeground(Color.black);
		mm.setBounds(190,70,70,50);

		yy=new JComboBox(s3);
		//yy.setBackground(Color.gray);
  		yy.setForeground(Color.black);
		yy.setBounds(260,70,80,50);
		

		ampm=new JComboBox(s4);
		//ampm.setBackground(Color.gray);
 		ampm.setForeground(Color.black);
		ampm.setBounds(270,130,70,50);

		try{
			String query = "select * from students";
			ResultSet rs = SQLResultSetGenerator.getResultSet(query);	
			int cntr=0;	
			while(rs.next()){				
				studentsList[cntr] = rs.getString(1);							
				cntr++;
			}		
  		}catch(Exception ee){
  			JOptionPane.showMessageDialog(null, "Error : "+ee);      			
  		}
		prn = new JComboBox(studentsList);
		type = new JComboBox(s5);
		time = new JTextField(20);
		prn.setBounds(140,10,200,50);
		time.setBounds(140,130,130,50);
		type.setBounds(140,190,130,50);

		save = new JButton("SAVE");
		clear = new JButton("CLEAR");
		exit = new JButton("EXIT");
		save.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);
		save.setBounds(50,260,100,30);
		clear.setBounds(160,260,100,30);
		exit.setBounds(270,260,100,30);

		inOutTimeForm.add(l1);
		inOutTimeForm.add(l2);
		inOutTimeForm.add(l3);
		inOutTimeForm.add(l4);
		inOutTimeForm.add(prn);
		inOutTimeForm.add(type);
		inOutTimeForm.add(dd);
		inOutTimeForm.add(mm);
		inOutTimeForm.add(yy);
		inOutTimeForm.add(ampm);
		inOutTimeForm.add(time);
		inOutTimeForm.add(save);
		inOutTimeForm.add(clear);
		inOutTimeForm.add(exit);

		inOutTimeForm.setResizable(false);
		inOutTimeForm.setVisible(true);
		inOutTimeForm.addWindowListener(new close());
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			inOutTimeForm.dispose();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== save)
		{
			String date = (String)dd.getSelectedItem()+"-"+ (String)mm.getSelectedItem()+"-"+yy.getSelectedItem();
			String timing = time.getText()+(String)ampm.getSelectedItem(); 
        //create table registerentries(id integer NOT NULL AUTO_INCREMENT,studentid varchar(50),type varchar(250),time varchar(50),date varchar(50), primary key(id));
			String query = "insert into registerentries (studentid,type,time,date) values"+
							"('"+prn.getSelectedItem()+"','"+type.getSelectedItem()+"','"+timing+"','"+date+"')";
			if(SQLResultSetGenerator.insertData(query)){                               		
					JOptionPane.showMessageDialog(null, "Entry added successfully");					
            	}else{
					JOptionPane.showMessageDialog(null, "Error ! \nSomething wen't wrong!!!");
            	}		
        inOutTimeForm.dispose();
		}
			
		if(ae.getSource()==clear)
		{			
			time.setText("");
		}
		if(ae.getSource()==exit)
			inOutTimeForm.dispose();
	}
	/*public static void main(String str[]) throws Exception
	{
		InOutTimeForm obj=new InOutTimeForm();
	}*/
}
