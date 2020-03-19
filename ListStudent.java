import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class ListStudent extends JFrame
{
	JFrame listStudentForm;
	//name,address,department,roomNumber;
	String[] colHead={"Sequence","Name","Address","Department","Room Number"};
	String[][] dummyData = new String[500][5];	
	public ListStudent()
	{
		listStudentForm=new JFrame();
		listStudentForm.setTitle("List of students to Hostem Management System");
		listStudentForm.setBounds(100,100,500,350);
		listStudentForm.setLayout(null);	

		try{
			String query = "select * from students";
			ResultSet rs = SQLResultSetGenerator.getResultSet(query);	
			int cntr=0;	
			while(rs.next()){
				for(int i=1;i<6;i++){
					dummyData[cntr][i-1] = rs.getString(i);
				}				
				cntr++;
			}		
  		}catch(Exception ee){
  			JOptionPane.showMessageDialog(null, "Error : "+ee);      			
  		}	

			JTable jt1=new JTable(dummyData,colHead);
			jt1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jt1.getColumnModel().getColumn(1).setPreferredWidth(160);
			int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			JScrollPane js1=new JScrollPane(jt1,v,h);
			js1.setBounds(0,0,500,350);
			listStudentForm.add(js1);

		listStudentForm.setResizable(false);
		listStudentForm.setVisible(true);
		listStudentForm.addWindowListener(new close());
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			listStudentForm.dispose();
		}
	}	
	/*public static void main(String str[]) throws Exception
	{
		ListStudent obj=new ListStudent();
	}*/
}
