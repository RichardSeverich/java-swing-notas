package datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
* https://www.tutorialspoint.com/postgresql/postgresql_java.htm
* Class.
*/
public final class Conexion {
  private static Conexion conexion;
  private Connection connection;
  private String driverPackage;
  private String driver;
  private String host;
  private String port;
  private String dbName;
  private String dbUser;
  private String dbPassword;

  /**
  * Method.
  */
  private Conexion() {
    this.connection = null;
    this.driverPackage = "org.postgresql.Driver";
    this.driver = "jdbc:postgresql";
    this.host = ReadConfigProperties.host;
    this.port = ReadConfigProperties.port;
    this.dbName = ReadConfigProperties.dbName;
    this.dbUser = ReadConfigProperties.dbUser;
    this.dbPassword = ReadConfigProperties.dbPassword;
  }

  /**
  * Method.
  */
  private void openConnection() {
    try {
      // example: jdbc:postgresql://192.168.0.100:5432/dbnotas
      String cadenaConexion = this.driver + "://" + this.host + ":" + this.port + "/" + this.dbName;
      Class.forName(driverPackage);
      this.connection = DriverManager.getConnection(cadenaConexion, this.dbUser, this.dbPassword);
      System.out.println("Opened database successfully");
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      //System.exit(0);
    }

  }

  /**
  * @return conexion.
  */
  private static Conexion getInstance() {
    if (conexion == null) {
      conexion = new Conexion();
    }
    return conexion;
  }

  /**
  * @return instance connection.
  */
  public static Connection open() {
    getInstance().openConnection();
    return getInstance().connection;
  }
}
