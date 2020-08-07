package datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
   
   private static Conexion conexion;
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
      this.driverPackage = "org.postgresql.Driver";
      this.driver = "jdbc:postgresql";
      this.host = "192.168.0.100";
      this.port = "5432";
      this.dbName = "dbnotas";
      this.dbUser = "postgres";
      this.dbPassword = "secret123";
   }

   private void openConnection() {
      try {
        // example: jdbc:postgresql://192.168.0.100:5432/dbnotas
        String cadenaConexion = this.driver+"://"+this.host+":"+this.port+"/"+this.dbName;
        Class.forName(driverPackage);
        this.connection = DriverManager.getConnection(cadenaConexion,this.dbUser, this.dbPassword);
        System.out.println("Opened database successfully");
      } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        //System.exit(0);
      }
      
   }
   
   private static Conexion getInstance(){
      if(conexion == null){
         conexion = new Conexion();
      }
      return conexion;
   }

   public static Connection open(){
      getInstance().openConnection();
      return getInstance().connection;
   }

}
