package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import listas.ContainerListas;
import modelos.Curso;
import modelos.Estudiante;
import modelos.Materia;

/**
* Class.
*/
public final class ConexionSelectTieneRelacion {

  /**
  * Constructor.
  */
  private ConexionSelectTieneRelacion() {
  }

  /**
  * @param tableName tableName.
  * @param typeId typeId.
  * @param id id.
  */
  public static void execute(String tableName, String typeId, int id) {
    Connection connection = Conexion.open();
    Statement statement = null;
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT * FROM ");
    sql.append(tableName);
    sql.append(" ");
    sql.append("WHERE ");
    sql.append(typeId);
    sql.append(" ");
    sql.append(" = ");
    sql.append(id);
    sql.append(";");
    System.out.println(sql);
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql.toString());
      ContainerListas.getInstance().listaRelacion.clear();
      Object objeto = tipoId(typeId);
      while (resultSet.next()) {
        if (objeto instanceof Curso) {
          Curso curso = (Curso) objeto;
          curso.id = resultSet.getInt("id");
          ContainerListas.getInstance().listaRelacion.add(curso);
        } else if (objeto instanceof Estudiante) {
          Estudiante estudiante = (Estudiante) objeto;
          estudiante.id = resultSet.getInt("id");
          ContainerListas.getInstance().listaRelacion.add(estudiante);
        } else if (objeto instanceof Materia) {
          Materia materia = (Materia) objeto;
          materia.id = resultSet.getInt("id");
          ContainerListas.getInstance().listaRelacion.add(materia);
        }
      }
      resultSet.close();
      statement.close();
      connection.close();
      System.out.println("Operation done successfully");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  /**
  * @param typeId typeId.
  * @return instance.
  */
  private static Object tipoId(String typeId) {
    switch (typeId) {
      case "id_course" :
        return new Curso();
      case "id_student":
        return new Estudiante();
      case "id_subject":
        return new Materia();
      default :
        return null;
    }

  }
}
