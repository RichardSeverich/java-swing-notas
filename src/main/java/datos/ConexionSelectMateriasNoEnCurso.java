package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Materia;
import modelos.Curso;

/**
* Class.
*/
public final class ConexionSelectMateriasNoEnCurso {

  /**
  * Constructor.
  */
  private ConexionSelectMateriasNoEnCurso() {
  }

  /**
  * @param curso curso.
  */
  public static void execute(Curso curso) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT subjects.* ");
    sql.append("FROM ");
    sql.append("subjects ");
    sql.append("WHERE ");
    sql.append("subjects.id ");
    sql.append("NOT IN (");
    sql.append("SELECT courses_subjects.id_subject ");
    sql.append("FROM courses_subjects ");
    sql.append("WHERE courses_subjects.id_course = ");
    sql.append(curso.id);
    sql.append(");");
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
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
