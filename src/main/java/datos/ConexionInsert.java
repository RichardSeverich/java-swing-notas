package datos;

import java.sql.Connection;
import java.sql.Statement;

/**
* Class.
*/
public final class ConexionInsert {

  /**
  * Constructor.
  */
  private ConexionInsert() {
  }

  /**
  * @param sql sql.
  */
  public static void execute(String sql) {
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
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }
}
