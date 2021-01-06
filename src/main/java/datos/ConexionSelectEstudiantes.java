package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Estudiante;

public class ConexionSelectEstudiantes {

  public ConexionSelectEstudiantes() {

  }

  /**Construye SQL.*/
  public static void execute() {
    Connection connection = Conexion.open();
    Statement statement = null;
    String sql = "SELECT * FROM students";
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      ContainerListas.getInstance().listaEstudiantes.clear();
      while (resultSet.next()) {
        Estudiante estudiante = new Estudiante();
        estudiante.id = resultSet.getInt("id");
        estudiante.dni = resultSet.getString("dni");
        estudiante.nombres = resultSet.getString("name"); 
        estudiante.apellidos = resultSet.getString("last_name");
        estudiante.fechaNacimiento = resultSet.getString("birth_date");
        estudiante.telefono = resultSet.getString("telephone");
        estudiante.direccion = resultSet.getString("adress");
        estudiante.email = resultSet.getString("email"); 
        ContainerListas.getInstance().listaEstudiantes.add(estudiante);
      }
      resultSet.close();
      statement.close();
      connection.close();
      System.out.println("Operation done successfully");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      //System.exit(0);
    }
  }
}
