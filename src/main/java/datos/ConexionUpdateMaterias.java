package datos;

import modelos.Materia;

/**
* Class.
*/
public final class ConexionUpdateMaterias {

  /**
  * Constructor.
  */
  private ConexionUpdateMaterias() {
  }

  /**
  * @param materia materia.
  */
  public static void execute(Materia materia) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE subjects SET");
    sql.append(" ");
    sql.append("name = '" + materia.nombre + "'");
    sql.append(" ");
    sql.append("WHERE ");
    sql.append("id =" + materia.id + ";");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
