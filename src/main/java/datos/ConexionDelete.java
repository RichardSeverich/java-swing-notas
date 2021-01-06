package datos;

import java.lang.StringBuilder;

public class ConexionDelete {

  private ConexionDelete() {

  }

  /**Construye sql.*/
  public static void execute(String tableName, int id) {
    StringBuilder sql = new StringBuilder();
    sql.append("DELETE FROM ");
    sql.append(tableName);
    sql.append(" ");
    sql.append("WHERE id = ");
    sql.append(id);
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
