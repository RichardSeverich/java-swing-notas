package datos;

import java.lang.StringBuilder;
import modelos.Usuario;

public class ConexionUpdateUsuarios {

  private ConexionUpdateUsuarios() {

  }

  /**Construye SQL.*/
  public static void execute(Usuario usuario) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE users SET");
    sql.append(" ");
    sql.append("dni = '" + usuario.dni + "', ");
    sql.append("username = '" + usuario.username + "', ");
    sql.append("password = '" + usuario.contrasena + "', ");
    sql.append("name = '" + usuario.nombres + "', ");
    sql.append("last_name = '" + usuario.apellidos + "', ");
    sql.append("birth_date = '" + usuario.fechaNacimiento + "', ");
    sql.append("email = '" + usuario.email + "', ");
    sql.append("type = '" + usuario.tipo + "'");
    sql.append(" ");
    sql.append("WHERE ");
    sql.append("id=" + usuario.id + ";");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }

}
