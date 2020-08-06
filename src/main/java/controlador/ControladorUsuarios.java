package controlador;

import modelos.Usuario;
import listas.ContainerListas;
import datos.ConexionSelectUsuarios;

public class ControladorUsuarios {

  private ControladorUsuarios() {

  }

  public static Object[][] getArray() {
    ConexionSelectUsuarios.execute();
    int size = ContainerListas.getInstance().listaUsuarios.size();
    Object[][] datos = new Object[size][11];
    int row = 0;
    for (Usuario usuario : ContainerListas.getInstance().listaUsuarios){
      datos[row][0] = usuario.id;
      datos[row][1] = usuario.dni;
      datos[row][2] = usuario.username;
      datos[row][3] = usuario.contrasena;
      datos[row][4] = usuario.nombres;
      datos[row][5] = usuario.apellidos;
      datos[row][6] = usuario.fechaNacimiento;
      datos[row][7] = usuario.email;
      datos[row][8] = usuario.tipo;
      datos[row][9] = "Editar";
      datos[row][10] = "Eliminar";
      row++;
    }
    return datos;
  }

}
