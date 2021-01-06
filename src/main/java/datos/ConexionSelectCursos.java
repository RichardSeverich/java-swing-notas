package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Curso;

public class ConexionSelectCursos {

  public ConexionSelectCursos() {

  }

  /**Construye SQL.*/
  public static void execute() {
    Connection connection = Conexion.open();
    Statement statement = null;
    String sql = "SELECT * FROM courses";
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      ContainerListas.getInstance().listaCursos.clear();
      while (resultSet.next()) {
        Curso curso = new Curso();
        curso.id = resultSet.getInt("id");
        curso.nombre = resultSet.getString("name");
        ContainerListas.getInstance().listaCursos.add(curso);
      }
      resultSet.close();
      statement.close();
      connection.close();
      System.out.println("Operation done successfully");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      //System.exit(0);
    }
  }
}
