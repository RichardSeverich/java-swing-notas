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
public final class ConexionSelectEstudiantesEnCurso {

  /**
  * Constructor.
  */
  private ConexionSelectEstudiantesEnCurso() {
  }

  /**
  * @param curso curso.
  */
  public static void execute(Curso curso) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ");
    sql.append("courses_students.id,");
    sql.append("students.id as id_student,");
    sql.append("students.dni,");
    sql.append("students.name,");
    sql.append("students.last_name,");
    sql.append("students.birth_date,");
    sql.append("students.telephone,");
    sql.append("students.adress,");
    sql.append("students.email ");
    sql.append("FROM students ");
    sql.append("INNER JOIN courses_students ");
    sql.append("ON students.id = courses_students.id_student ");
    sql.append("INNER JOIN courses ");
    sql.append("ON courses.id = courses_students.id_course ");
    sql.append("WHERE courses_students.id_course = ");
    sql.append(curso.id);
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
      ContainerListas.getInstance().listaEstudiantes.clear();
      while (resultSet.next()) {
        Estudiante estudiante = new Estudiante();
        estudiante.idRelacion = resultSet.getInt("id");
        estudiante.id = resultSet.getInt("id_student");
        estudiante.dni = resultSet.getString("dni");
        estudiante.nombres = resultSet.getString("name");
        estudiante.apellidos = resultSet.getString("last_name");
        estudiante.fechaNacimiento = resultSet.getString("birth_date");
        estudiante.telefono = resultSet.getString("telephone");
        estudiante.direccion = resultSet.getString("adress");
        estudiante.email = resultSet.getString("email");
        ContainerListas.getInstance().listaEstudiantes.add(estudiante);
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
