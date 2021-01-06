package datos;

import java.lang.StringBuilder;
import modelos.Curso;

public class ConexionInsertCursos {

  private ConexionInsertCursos() {

  }

  /**Construye SQL.*/
  public static void execute(Curso curso) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO courses");
    sql.append(" ");
    sql.append("(name)");
    sql.append(" ");
    sql.append("VALUES");
    sql.append("(");
    sql.append("'" + curso.nombre + "'");
    sql.append(");");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
