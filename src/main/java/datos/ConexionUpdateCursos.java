package datos;

import java.lang.StringBuilder;
import modelos.Curso;

public class ConexionUpdateCursos {

  private ConexionUpdateCursos() {

  }

  /**Construye SQL.*/
  public static void execute(Curso curso) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE courses SET");
    sql.append(" ");
    sql.append("name = '" + curso.nombre + "'");
    sql.append(" ");
    sql.append("WHERE ");
    sql.append("id =" + curso.id + ";");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
