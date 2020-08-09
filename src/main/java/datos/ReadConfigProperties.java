package datos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties {

  public static String host;
  public static String port;
  public static String dbName;
  public static String dbUser;
  public static String dbPassword;

  /** Leer archivo de configuracion */
  public static void leer() {
    try (InputStream input = new FileInputStream("config.properties")) {
      Properties prop = new Properties();
      // load a properties file
      prop.load(input);
      // get the property value and print it out
      host = prop.getProperty("db.host");
      port = prop.getProperty("db.port");
      dbName = prop.getProperty("db.dbName");
      dbUser = prop.getProperty("db.dbUser");
      dbPassword = prop.getProperty("db.dbPassword");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
