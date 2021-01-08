package datos;

import java.lang.StringBuilder;
import modelos.Curso;
import modelos.Materia;

public class ConexionInsertCursosSubjects {

  private ConexionInsertCursosSubjects() {

  }

  /**Construye SQL.*/
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
