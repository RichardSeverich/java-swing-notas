package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import datos.ConexionInsertCursos;
import datos.ConexionUpdateCursos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelos.Curso;
import vistas.componentes.ComponentesCursosRegistrar;
import vistas.validadores.ValidadorCursos;

/**
* Class.
*/
public class EventosCursosRegistrar implements ActionListener {
  public static boolean editar;
  public static int id;

  /**
  * Constructor.
  */
  public EventosCursosRegistrar() {
    this.editar = false;
    this.id = 0;
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    boolean esValido = ValidadorCursos.validar();
    if (esValido) {
      Curso curso = new Curso();
      curso.nombre = ComponentesCursosRegistrar.fieldNombre.getText();
      if (this.editar) {
        this.modificar(curso);
      } else {
        this.crear(curso);
      }
    }
  }

  /**
   * @param curso curso.
  */
  private void crear(Curso curso) {
    ConexionInsertCursos.execute(curso);
    showMessageDialog(null, "Registrado exitosamente");
  }

  /**
   * @param curso curso.
  */
  private void modificar(Curso curso) {
    curso.id = this.id;
    ConexionUpdateCursos.execute(curso);
    showMessageDialog(null, "Editado exitosamente");
  }
}
