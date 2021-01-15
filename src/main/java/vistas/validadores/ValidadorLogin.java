package vistas.validadores;

import datos.ConexionSelectLogin;
import listas.ContainerListas;
import vistas.componentes.ComponentesLogin;

/**
* Class.
*/
public final class ValidadorLogin {

  /**
  * Constructor.
  */
  private ValidadorLogin() {
  }

  /**
  * @return boolean.
  */
  public static boolean validar() {
    String userName = ComponentesLogin.fieldUserName.getText();
    String password = ComponentesLogin.fieldPassword.getText();
    ConexionSelectLogin.execute(userName, password);
    return ContainerListas.getInstance().listaUsuarios.size() > 0;
  }
}
