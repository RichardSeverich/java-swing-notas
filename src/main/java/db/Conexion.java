/*package db.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
   
   private Conexion static conexion;
   private Connection connection;
   private String driverPackage;
   private String driver;
   private String host;
   private String port;
   private String dbName;
   private String dbUser;
   private String dbPassword;

   private Conexion(){
      this.connection = null;
      this.driverPackage = "org.postgresql.Driver"
      this.driver = "jdbc:postgresql"
      this.host = "localhost"
      this.port = "5432"
      this.dbName = "testdb"
      this.dbUser = "postgres"
      this.dbPassword = "123"
   }

   private void openConnection() {
      try {
         Class.forName("org.postgresql.Driver");
         this.connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/testdb",
            "postgres", "123");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
   
   private static conexion getInstance(){
      if(conexion == null){
         conexion = new Conexion();
      }
      return conexion;
   }

   public static Connection Open(){
      return getInstance().openConnection();
   }

   public static Close(){
      return getInstance().connection.close();
   }

}
*/