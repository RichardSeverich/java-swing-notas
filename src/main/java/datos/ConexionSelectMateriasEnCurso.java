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
public final class ConexionSelectMateriasEnCurso {

  /**
  * Constructor.
  */
  private ConexionSelectMateriasEnCurso() {
  }

  /**
  * @param curso curso.
  */
  public static void execute(Curso curso) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append("courses_subjects.id,");
    sql.append("subjects.id as subject_id,");
    sql.append("subjects.name ");
    sql.append("FROM subjects ");
    sql.append("INNER JOIN ");
    sql.append("courses_subjects ");
    sql.append("ON ");
    sql.append("subjects.id = courses_subjects.id_subject ");
    sql.append("INNER JOIN courses ");
    sql.append("ON ");
    sql.append("courses.id = courses_subjects.id_course ");
    sql.append("WHERE ");
    sql.append("courses_subjects.id_course = ");
    sql.append(curso.id);
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
      ContainerListas.getInstance().listaMaterias.clear();
      while (resultSet.next()) {
        Materia materia = new Materia();
        materia.idRelacion = resultSet.getInt("id");
        materia.id = resultSet.getInt("subject_id");
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
