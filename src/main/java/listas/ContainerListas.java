package listas;

import java.util.ArrayList;
import java.util.List;

import modelos.Usuario;

public class ContainerListas {

  private static ContainerListas containerListas;
  public List<Usuario> listaUsuarios;

  private ContainerListas() {
    this. listaUsuarios = new ArrayList<Usuario>();
  }

  /** retorna unica instancia. */
  public static ContainerListas getInstance() {
    if (containerListas == null) {
      containerListas = new ContainerListas();
    }
    return containerListas;
  }

}
