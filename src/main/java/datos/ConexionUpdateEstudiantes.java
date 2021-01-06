package datos;

import java.lang.StringBuilder;
import modelos.Estudiante;

public class ConexionUpdateEstudiantes {

  private ConexionUpdateEstudiantes() {

  }

  /**Construye SQL.*/
  public static void execute(Estudiante estudiante) {
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE students SET");
    sql.append(" ");
    sql.append("dni = '" + estudiante.dni + "', ");
    sql.append("name = '" + estudiante.nombres + "', ");
    sql.append("last_name = '" + estudiante.apellidos + "', ");
    sql.append("birth_date = '" + estudiante.fechaNacimiento + "', ");
    sql.append("telephone = '" + estudiante.telefono + "', ");
    sql.append("adress = '" + estudiante.direccion + "', ");
    sql.append("email = '" + estudiante.email + "'");
    sql.append(" ");
    sql.append("WHERE ");
    sql.append("id =" + estudiante.id + ";");
    System.out.println(sql.toString());
    ConexionInsert.execute(sql.toString());
  }
}
