import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.sql.*;*/
public class Home extends JFrame  implements ActionListener 
{		
	public int flag;
	public String prno;
	JLabel l1,l2,l3;		
	int x,y;
	String selected="Hostel Management System",startprn="PUN";
	JFrame home;
	public Home()
	{
		home=new JFrame();
		home.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		x=(int)screenSize.getWidth();
		y=(int)screenSize.getHeight();
		home.setBounds(0,0,x,y-50);
		JMenuBar menubar = new JMenuBar();	
		Font fnt = new Font("arial",Font.BOLD+Font.ITALIC,25);  

		JMenu adminOptions= new JMenu("Options");
		JMenu registerEntry = new JMenu("Register");
		JMenu roomStatus = new JMenu("Room Status");			

		JMenuItem ap_add_room = new JMenuItem("Add Room");
		ap_add_room.addActionListener(this);
		JMenuItem ap_add_student = new JMenuItem("Add Student");
		ap_add_student.addActionListener(this);
		JMenuItem ap_list_student = new JMenuItem("List Student");
		ap_list_student.addActionListener(this);
		JMenuItem ap_list_delete = new JMenuItem("Delete Student");
		ap_list_delete.addActionListener(this);

		JMenuItem inOutTime = new JMenuItem("In Out Entry");
		inOutTime.addActionListener(this);
		
		JMenuItem up_details = new JMenuItem("Vew Room Status");
		up_details.addActionListener(this);

		adminOptions.add(ap_add_room);
		adminOptions.add(ap_add_student);
		adminOptions.add(ap_list_student);
		adminOptions.add(ap_list_delete);

		registerEntry.add(inOutTime);				
		roomStatus.add(up_details);		
		roomStatus.addActionListener(this);
		
		menubar.add(adminOptions);
		menubar.add(registerEntry);
		menubar.add(roomStatus);					

		l1=new JLabel("MINI PROJECT : \n \t TE sem I");
		l1.setBounds(x/2-180,y/2+100,600,100);
		l1.setFont(new Font("Serif", Font.BOLD, 25));
		l1.setForeground(Color.blue);
		l2=new JLabel("Project by - Gunjal Dipali, \n\tGhonge Kshitij, Kavde Rutuja, Hase Dhanashree");
		l2.setBounds(x/2-280,y/2+200,500,20);
		l2.setFont(new Font("Serif", Font.ITALIC, 16));
		l2.setForeground(Color.blue);
		l3=new JLabel(selected);
		l3.setBounds(x/2-280,50,700,60);
		l3.setFont(new Font("Serif", Font.BOLD, 48));
		l3.setForeground(Color.blue);
		home.getContentPane().setBackground(new Color(204,255,204));		
 
		home.add(l1);
		home.add(l2);
		home.add(l3);

		home.setFont(fnt);
		home.setTitle("Hostel Management Home Page");
		home.setVisible(true);
		home.setJMenuBar(menubar);
		home.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		switch(str){
			case "Add Room":
				AddRoom addRoom = new AddRoom();
			break;
			case "Add Student":
				AddStudent addStudent = new AddStudent();
			break;
			case "List Student":
				ListStudent listStudent=new ListStudent();
			break;
			case "Delete Student":
				DeleteStudent deleteStudent = new DeleteStudent();
			break;
			case "In Out Entry":
				InOutTimeForm inOutTimeForm=new InOutTimeForm();
			break;
			case "Vew Room Status":
				RoomStatus roomStatus = new RoomStatus();
			break;			
		}
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			 home.dispose();
		}
	}

	/*public static void main(String str[]) throws Exception
	{
		Home obj=new Home();
	}*/
}
