package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import modelos.Usuario;
import listas.ContainerListas;

public class ConexionSelectLogin {

  public ConexionSelectLogin() {

  }

  /**Construye SQL.*/
  public static void execute(String userName, String password) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT * FROM users");
    sql.append(" ");
    sql.append("WHERE");
    sql.append(" ");
    sql.append("username");
    sql.append(" ");
    sql.append("=");
    sql.append(" ");
    sql.append("'" + userName + "'");
    sql.append(" ");
    sql.append("AND");
    sql.append(" ");
    sql.append("password");
    sql.append(" ");
    sql.append("=");
    sql.append(" ");
    sql.append("'" + password + "'");
    sql.append(";");
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
      ContainerListas.getInstance().listaUsuarios.clear();
      while (resultSet.next()) {
        Usuario usuario = new Usuario();
        usuario.id = resultSet.getInt("id");
        usuario.username = resultSet.getString("username");
        usuario.contrasena = resultSet.getString("password");
        ContainerListas.getInstance().listaUsuarios.add(usuario);
      }
      resultSet.close();
      statement.close();
      connection.close();
      System.out.println("Operation done successfully");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }
}
