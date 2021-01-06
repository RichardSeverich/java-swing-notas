package listas;

import java.util.ArrayList;
import java.util.List;

import modelos.Curso;
import modelos.Estudiante;
import modelos.Materia;
import modelos.Usuario;

public class ContainerListas {
  private static ContainerListas containerListas;
  public List<Usuario> listaUsuarios;
  public List<Estudiante> listaEstudiantes;
  public List<Curso> listaCursos;
  public List<Materia> listaMaterias;
  public static String userName;

  private ContainerListas() {
    this. listaUsuarios = new ArrayList<Usuario>();
    this.listaEstudiantes = new ArrayList<>();
    this.listaCursos = new ArrayList<>();
    this.listaMaterias = new ArrayList<>();
  }

  /** retorna unica instancia. */
  public static ContainerListas getInstance() {
    if (containerListas == null) {
      containerListas = new ContainerListas();
    }
    return containerListas;
  }
}
