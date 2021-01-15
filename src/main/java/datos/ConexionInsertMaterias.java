package datos;

import modelos.Materia;

/**
* Class.
*/
public final class ConexionInsertMaterias {

  /**
  * Constructor.
  */
  private ConexionInsertMaterias() {
  }

  /**
  * @param materia materia.
  */
  public static void execute(Materia materia) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO subjects");
    sql.append(" ");
    sql.append("(name)");
    sql.append(" ");
    sql.append("VALUES");
    sql.append("(");
    sql.append("'" + materia.nombre + "'");
    sql.append(");");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
