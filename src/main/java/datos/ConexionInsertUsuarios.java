package datos;

import modelos.Usuario;

/**
* Class.
*/
public final class ConexionInsertUsuarios {

  /**
  * Constructor.
  */
  private ConexionInsertUsuarios() {
  }

  /**
  * @param usuario usuario.
  */
  public static void execute(Usuario usuario) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO users");
    sql.append(" ");
    sql.append("(dni,username,password,name,last_name,birth_date,email,type)");
    sql.append(" ");
    sql.append("VALUES");
    sql.append("(");
    sql.append("'" + usuario.dni + "',");
    sql.append("'" + usuario.username + "',");
    sql.append("'" + usuario.contrasena + "',");
    sql.append("'" + usuario.nombres + "',");
    sql.append("'" + usuario.apellidos + "',");
    sql.append("'" + usuario.fechaNacimiento + "',");
    sql.append("'" + usuario.email + "',");
    sql.append("'" + usuario.tipo + "'");
    sql.append(");");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
