package datos;

import modelos.Curso;

/**
* Class.
*/
public final class ConexionUpdateCursos {

  /**
  * Constructor.
  */
  private ConexionUpdateCursos() {
  }

  /**
  * @param curso curso.
  */
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
