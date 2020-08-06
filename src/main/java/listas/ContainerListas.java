package listas;

import java.util.List;
import java.util.ArrayList;

import modelos.Usuario;

public class ContainerListas {

  private static ContainerListas containerListas;
  public List<Usuario> listaUsuarios;

  private ContainerListas() {
    this. listaUsuarios = new ArrayList<Usuario>();
  }

  public static ContainerListas getInstance(){
    if(containerListas == null){
      containerListas = new ContainerListas();
    }
    return containerListas;
  }

}
