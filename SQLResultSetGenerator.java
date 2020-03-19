import java.sql.*;

public class SQLResultSetGenerator {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/HostelManagementData";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   static Connection conn = null;
   static Statement stmt = null;   
      public static ResultSet getResultSet(String sql) 
      {      
         ResultSet rs =null;
         try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection      
            //if(conn==null){
               conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //}
            //STEP 4: Execute a query  
           // if(stmt==null){
               stmt = conn.createStatement();      
            //sql = "SELECT id, first, last, age FROM Employees";
            rs = stmt.executeQuery(sql);  
            /*if(rs != null && rs.next()){                
               return true;
            }  */  
            return rs;
            //STEP 5: Extract data from result set      
            // rs;
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }
         return rs;
      }//end main

      public static boolean insertData(String sql) 
      {              
         try{            
            Class.forName("com.mysql.jdbc.Driver");            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);            
            stmt = conn.createStatement();    
            stmt.executeUpdate(sql);    
            return true;
         }catch(SQLException se){
              se.printStackTrace();
            return false;
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
         }       
      }//end main
}//end FirstExample