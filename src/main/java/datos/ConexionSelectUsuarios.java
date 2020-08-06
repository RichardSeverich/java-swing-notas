package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import modelos.Usuario;
import listas.ContainerListas;

public class ConexionSelectUsuarios {

   public static void execute() {
      Connection connection = Conexion.open();
      Statement statement = null;
      try {
         statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery( "SELECT * FROM users");
         ContainerListas.getInstance().listaUsuarios.clear();
         while ( resultSet.next() ) {
            Usuario usuario = new Usuario();
            usuario.id = resultSet.getInt("id");
            usuario.dni = resultSet.getString("dni");
            usuario.username = resultSet.getString("username");
            usuario.contrasena = resultSet.getString("password");
            usuario.nombres = resultSet.getString("name"); 
            usuario.apellidos = resultSet.getString("last_name");
            usuario.fechaNacimiento = resultSet.getString("birth_date"); 
            usuario.email = resultSet.getString("email"); 
            usuario.tipo = resultSet.getString("type");
            ContainerListas.getInstance().listaUsuarios.add(usuario);
         }
         resultSet.close();
         statement.close();
         connection.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         //System.exit(0);
      }
      System.out.println("Operation done successfully");
   }
}
