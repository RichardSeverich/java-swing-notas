package datos;

import modelos.Materia;
import modelos.Estudiante;

/**
* Class.
*/
public final class ConexionInsertSubjectsStudents {

  /**
  * Constructor.
  */
  private ConexionInsertSubjectsStudents() {

  }

  /**
  * @param materia materia.
  * @param estudiante estudiante.
  * @param score score.
  */
  public static void execute(Materia materia, Estudiante estudiante, String score) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO subjects_students");
    sql.append(" ");
    sql.append("(id_subject, id_student, score)");
    sql.append(" ");
    sql.append("VALUES");
    sql.append("(");
    sql.append("'" + materia.id + "',");
    sql.append("'" + estudiante.id + "',");
    sql.append("'" + score + "'");
    sql.append(");");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
