package datos;

import modelos.Estudiante;

/**
* Class.
*/
public final class ConexionInsertEstudiantes {

  /**
  * Constructor.
  */
  private ConexionInsertEstudiantes() {
  }

  /**
  * @param estudiante estudiante.
  */
  public static void execute(Estudiante estudiante) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO students");
    sql.append(" ");
    sql.append("(dni,name,last_name,birth_date,telephone,adress,email)");
    sql.append(" ");
    sql.append("VALUES");
    sql.append("(");
    sql.append("'" + estudiante.dni + "',");
    sql.append("'" + estudiante.nombres + "',");
    sql.append("'" + estudiante.apellidos + "',");
    sql.append("'" + estudiante.fechaNacimiento + "',");
    sql.append("'" + estudiante.telefono + "',");
    sql.append("'" + estudiante.direccion + "',");
    sql.append("'" + estudiante.email + "'");
    sql.append(");");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
