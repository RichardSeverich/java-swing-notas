package listas;

import java.util.ArrayList;
import java.util.List;

import modelos.Curso;
import modelos.Estudiante;
import modelos.Materia;
import modelos.Usuario;

/**
* Class.
*/
public final class ContainerListas {
  private static ContainerListas containerListas;
  public List<Usuario> listaUsuarios;
  public List<Estudiante> listaEstudiantes;
  public List<Curso> listaCursos;
  public List<Materia> listaMaterias;
  public List<Materia> listaMateriasAux;
  public List<Object> listaRelacion;
  public static String userName;

  /**
  * Constructor.
  */
  private ContainerListas() {
    this.listaUsuarios = new ArrayList<>();
    this.listaEstudiantes = new ArrayList<>();
    this.listaCursos = new ArrayList<>();
    this.listaMaterias = new ArrayList<>();
    this.listaMateriasAux = new ArrayList<>();
    this.listaRelacion = new ArrayList<>();
  }

  /**
  * @return instance containerListas.
  */
  public static ContainerListas getInstance() {
    if (containerListas == null) {
      containerListas = new ContainerListas();
    }
    return containerListas;
  }
}
