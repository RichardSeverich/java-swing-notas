package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import datos.ConexionInsertMaterias;
import datos.ConexionUpdateMaterias;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelos.Materia;
import vistas.componentes.ComponentesMateriasRegistrar;
import vistas.validadores.ValidadorMaterias;


public class EventosMateriasRegistrar implements ActionListener {
  public static boolean editar;
  public static int id;

  public EventosMateriasRegistrar() {
    this.editar = false;
    this.id = 0;
  }

  public void actionPerformed(ActionEvent actionEvent) {
    boolean esValido = ValidadorMaterias.validar();
    if(esValido) {
      Materia materia = new Materia();
      materia.nombre = ComponentesMateriasRegistrar.fieldNombre.getText();
      if(this.editar) {
        this.modificar(materia);
      } else {
        this.crear(materia);
      }
    }
  }

  private void crear(Materia materia){
    ConexionInsertMaterias.execute(materia);
    showMessageDialog(null, "Registrado exitosamente");
  }

  private void modificar(Materia materia){
    materia.id = this.id;
    ConexionUpdateMaterias.execute(materia);
    showMessageDialog(null, "Editado exitosamente");
  }
}
