package datos;

import modelos.Curso;
import modelos.Materia;

/**
* Class.
*/
public final class ConexionInsertCursosSubjects {

  /**
  * Constructor.
  */
  private ConexionInsertCursosSubjects() {
  }

  /**
  * @param curso curso.
  * @param materia materia.
  */
  public static void execute(Curso curso, Materia materia) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO courses_subjects");
    sql.append(" ");
    sql.append("(id_course, id_subject)");
    sql.append(" ");
    sql.append("VALUES");
    sql.append("(");
    sql.append("'" + curso.id + "',");
    sql.append("'" + materia.id + "'");
    sql.append(");");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
