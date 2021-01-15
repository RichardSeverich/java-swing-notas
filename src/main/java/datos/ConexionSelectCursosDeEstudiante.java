package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Curso;
import modelos.Estudiante;

/**
* Class.
*/
public final class ConexionSelectCursosDeEstudiante {

  /**
  * Constructor.
  */
  private ConexionSelectCursosDeEstudiante() {
  }

  /**
  * @param estudiante estudiante.
  */
  public static void execute(Estudiante estudiante) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append("courses_students.id,");
    sql.append("courses.id as id_course,");
    sql.append("courses.name ");
    sql.append("FROM students ");
    sql.append("INNER JOIN courses_students ");
    sql.append("ON students.id = courses_students.id_student ");
    sql.append("INNER JOIN courses ");
    sql.append("ON courses.id = courses_students.id_course ");
    sql.append("WHERE courses_students.id_student = ");
    sql.append(estudiante.id);
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
      ContainerListas.getInstance().listaCursos.clear();
      while (resultSet.next()) {
        Curso curso = new Curso();
        curso.idRelacion = resultSet.getInt("id");
        curso.id = resultSet.getInt("id_course");
        curso.nombre = resultSet.getString("name");
        ContainerListas.getInstance().listaCursos.add(curso);
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
