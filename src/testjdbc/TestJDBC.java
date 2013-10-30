package testjdbc;
import java.sql.*;


class TestJDBC {
  public static void main (String[] args) throws Exception
  {
      //DriverManager.registerDriver (new oracle.jdbc.OracleDriver());

   Class.forName ("oracle.jdbc.OracleDriver");

   //DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
  


   
   Connection conn = DriverManager.getConnection
      ("jdbc:oracle:thin:@//localhost:1521/Oracle", "SYSTEM", "sascha29");
                        // @//machineName:port/SID,   userid,  password
   try {
     Statement stmt = conn.createStatement();
     try {
       //ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
         ResultSet rset = stmt.executeQuery("select * from locations");
       try {
         while (rset.next())
           System.out.println (rset.getString(1) + " | " + rset.getString("street_address"));   // Print col 1
       } 
       finally {
          try { rset.close(); } catch (Exception ignore) {}
       }
     } 
     finally {
       try { stmt.close(); } catch (Exception ignore) {}
     }
   } 
   finally {
     try { conn.close(); } catch (Exception ignore) {}
   }
  }
}
