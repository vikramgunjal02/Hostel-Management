import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame  implements ActionListener 
{
	JFrame loginForm;
	JTextField userName;
	JPasswordField password;
	JButton loginBtn,clearBtn,exitBtn;
	/*JComboBox dd,mm,yy,ampm;*/
	String[] s1 = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] s2 = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	String[] s3 = {"2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	String[] s4 ={"AM","PM"};
	public Login()
	{
		loginForm=new JFrame();
		loginForm.setTitle("Login to access Hostem Management System");
		loginForm.setBounds(100,100,400,270);
		loginForm.setLayout(null);		

		JLabel l1=new JLabel("User : ");
		JLabel l2=new JLabel("Password : ");
		
		l1.setBounds(10,10,100,50);
		l2.setBounds(10,70,100,50);
		
		userName = new JTextField(30);
		password = new JPasswordField(20);
		userName.setBounds(120,10,200,50);		
		password.setBounds(120,70,200,50);

		loginBtn = new JButton("loginBtn");
		clearBtn = new JButton("clearBtn");
		exitBtn = new JButton("exitBtn");
		loginBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		loginBtn.setBounds(50,160,100,30);
		clearBtn.setBounds(160,160,100,30);
		exitBtn.setBounds(270,160,100,30);

		loginForm.add(l1);
		loginForm.add(l2);		
		loginForm.add(userName);		
		loginForm.add(password);
		loginForm.add(loginBtn);
		loginForm.add(clearBtn);
		loginForm.add(exitBtn);

		loginForm.setResizable(false);
		loginForm.setVisible(true);
		loginForm.addWindowListener(new close());
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			loginForm.dispose();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{		
		if(ae.getSource()== loginBtn)
		{
			try{
				String query = "select * from login where user='"+userName.getText()+"' and password='"+password.getText()+"'";
				
				ResultSet rs = SQLResultSetGenerator.getResultSet(query);
				if(rs != null && rs.next()){                
               		Home home = new Home();
					loginForm.dispose(); 
            	}else{
					JOptionPane.showMessageDialog(null, "Please provide valid username and password");
            	}			
      		}catch(Exception ee){
      			JOptionPane.showMessageDialog(null, "Error : "+ee);      			
      		}	
		}	
		if(ae.getSource()==clearBtn)
		{
			userName.setText("");
			password.setText("");
		}
		if(ae.getSource()==exitBtn)
			loginForm.dispose();
	}
	public static void main(String str[]) throws Exception
	{
		Login obj=new Login();
	}
}
