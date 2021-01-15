package datos;

import modelos.Curso;
import modelos.Estudiante;

/**
* Class.
*/
public final class ConexionInsertCursosStudents {

  /**
  * Constructor.
  */
  private ConexionInsertCursosStudents() {
  }

  /**
  * @param curso curso.
  * @param estudiante estudiante.
  */
  public static void execute(Curso curso, Estudiante estudiante) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO courses_students");
    sql.append(" ");
    sql.append("(id_course, id_student)");
    sql.append(" ");
    sql.append("VALUES");
    sql.append("(");
    sql.append("'" + curso.id + "',");
    sql.append("'" + estudiante.id + "'");
    sql.append(");");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
