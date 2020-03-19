import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class RoomStatus extends JFrame
{
	JFrame roomStatusForm;
	//name,address,department,roomNumber;
	String[] colHead={"Sequence","Rom No","Capacity","Allocated","Free"};
	String[][] dummyData = new String[500][5] ; /*{{"1","101","5","2","3"},
	{"2","102","5","5","0"},
	{"3","103","3","1","4"}};*/
	public RoomStatus()
	{
		roomStatusForm=new JFrame();
		roomStatusForm.setTitle("Room Status");
		roomStatusForm.setBounds(100,100,500,350);
		roomStatusForm.setLayout(null);		
		try{
			String query = "select * from rooms";
			ResultSet rs = SQLResultSetGenerator.getResultSet(query);	
			int cntr=0;	
			while(rs.next()){
				for(int i=1;i<5;i++){
					dummyData[cntr][i-1] = rs.getString(i);
				}
				dummyData[cntr][4] = ""+(Integer.parseInt(dummyData[cntr][2]) - Integer.parseInt(dummyData[cntr][3]));
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
			roomStatusForm.add(js1);

		roomStatusForm.setResizable(false);
		roomStatusForm.setVisible(true);
		roomStatusForm.addWindowListener(new close());
	}

	public class close extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			roomStatusForm.dispose();
		}
	}	
	/*public static void main(String str[]) throws Exception
	{
		ListStudent obj=new ListStudent();
	}*/
}
