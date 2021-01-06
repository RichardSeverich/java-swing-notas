package vistas.validadores;

import datos.ConexionSelectLogin;
import listas.ContainerListas;
import vistas.componentes.ComponentesLogin;

public class ValidadorLogin {

  private ValidadorLogin(){

  }

  public static boolean validar() {
    String userName = ComponentesLogin.fieldUserName.getText();
    String password = ComponentesLogin.fieldPassword.getText();
    ConexionSelectLogin.execute(userName, password);
    return ContainerListas.getInstance().listaUsuarios.size() > 0;
  }
}
