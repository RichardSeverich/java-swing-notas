package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Estudiante;
import modelos.Curso;

/**
* Class.
*/
public final class ConexionSelectEstudiantesNoEnCurso {

  /**
  * Constructor.
  */
  private ConexionSelectEstudiantesNoEnCurso() {
  }

  /**
  * @param curso curso.
  */
  public static void execute(Curso curso) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT students.*");
    sql.append("FROM ");
    sql.append("students ");
    sql.append("WHERE ");
    sql.append("students.id ");
    sql.append("NOT IN (");
    sql.append("SELECT courses_students.id_student ");
    sql.append("FROM courses_students ");
    sql.append("WHERE courses_students.id_course = ");
    sql.append(curso.id);
    sql.append(");");
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
      ContainerListas.getInstance().listaEstudiantes.clear();
      while (resultSet.next()) {
        Estudiante estudiante = new Estudiante();
        estudiante.id = resultSet.getInt("id");
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
