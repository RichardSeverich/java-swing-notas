package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Materia;

/**
* Class.
*/
public final class ConexionSelectMaterias {

  /**
  * Constructor.
  */
  private ConexionSelectMaterias() {
  }

  /**
  * Method muestra todos las materias.
  */
  public static void execute() {
    Connection connection = Conexion.open();
    Statement statement = null;
    String sql = "SELECT * FROM subjects";
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      ContainerListas.getInstance().listaMaterias.clear();
      while (resultSet.next()) {
        Materia materia = new Materia();
        materia.id = resultSet.getInt("id");
        materia.nombre = resultSet.getString("name");
        ContainerListas.getInstance().listaMaterias.add(materia);
      }
      resultSet.close();
      statement.close();
      connection.close();
      System.out.println("Operation done successfully");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }
}
