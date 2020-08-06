/*package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionInsert {

   // https://www.tutorialspoint.com/postgresql/postgresql_java.htm
   public static void Insert(String sql) {
      Statement statement = null;
      Connection connection = Conexion.open();
      try {
         connection.setAutoCommit(false);
         statement = connection.createStatement();
         statement.executeUpdate(sql);
         statement.close();
         connection.commit();
         connection.close();
         System.out.println("Records created successfully");
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
   }
}
*/