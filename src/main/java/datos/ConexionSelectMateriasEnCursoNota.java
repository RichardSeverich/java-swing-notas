package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Materia;
import modelos.Curso;
import modelos.Estudiante;

/**
* Class.
*/
public final class ConexionSelectMateriasEnCursoNota {

  /**
  * Constructor.
  */
  private ConexionSelectMateriasEnCursoNota() {
  }

  /**
  * @param curso curso.
  * @param estudiante estudiante.
  */
  public static void execute(Curso curso, Estudiante estudiante) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append("subjects_students.id,");
    sql.append("subjects.id as subjects_id,");
    sql.append("subjects.name,");
    sql.append("subjects_students.score ");
    sql.append("FROM students ");
    sql.append("INNER JOIN subjects_students ");
    sql.append("ON students.id=subjects_students.id_student ");
    sql.append("INNER JOIN subjects ");
    sql.append("ON subjects.id=subjects_students.id_subject ");
    sql.append("INNER JOIN courses_subjects ");
    sql.append("ON courses_subjects.id_subject=subjects_students.id_subject ");
    sql.append("WHERE subjects_students.id_student = ");
    sql.append(estudiante.id);
    sql.append("AND courses_subjects.id_course = ");
    sql.append(curso.id);
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
      ContainerListas.getInstance().listaMateriasAux.clear();
      while (resultSet.next()) {
        Materia materia = new Materia();
        materia.idRelacion = resultSet.getInt("id");
        materia.id = resultSet.getInt("subjects_id");
        materia.nombre = resultSet.getString("name");
        materia.nota = resultSet.getString("score");
        ContainerListas.getInstance().listaMateriasAux.add(materia);
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
