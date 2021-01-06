package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import datos.ConexionInsertEstudiantes;
import datos.ConexionUpdateEstudiantes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelos.Estudiante;
import vistas.componentes.ComponentesEstudiantesRegistrar;
import vistas.validadores.ValidadorEstudiantes;


public class EventosEstudiantesRegistrar implements ActionListener {
  public static boolean editar;
  public static int id;

  public EventosEstudiantesRegistrar() {
    this.editar = false;
    this.id = 0;
  }

  public void actionPerformed(ActionEvent actionEvent) {
    boolean esValido = ValidadorEstudiantes.validar();
    if(esValido) {
      Estudiante estudiante = new Estudiante();
      estudiante.dni = ComponentesEstudiantesRegistrar.fieldDni.getText();
      estudiante.nombres = ComponentesEstudiantesRegistrar.fieldNombres.getText();
      estudiante.apellidos = ComponentesEstudiantesRegistrar.fieldApellidos.getText();
      estudiante.fechaNacimiento = ComponentesEstudiantesRegistrar.datePicker
        .getJFormattedTextField().getText();
      estudiante.telefono = ComponentesEstudiantesRegistrar.fieldTelefono.getText();
      estudiante.direccion = ComponentesEstudiantesRegistrar.fieldDireccion.getText();
      estudiante.email = ComponentesEstudiantesRegistrar.fieldEmail.getText();
      if(this.editar) {
        this.modificar(estudiante);
      } else {
        this.crear(estudiante);
      }
    }
  }

  private void crear(Estudiante estudiante){
    ConexionInsertEstudiantes.execute(estudiante);
    showMessageDialog(null, "Registrado exitosamente");
  }

  private void modificar(Estudiante estudiante){
    estudiante.id = this.id;
    ConexionUpdateEstudiantes.execute(estudiante);
    showMessageDialog(null, "Editado exitosamente");
  }
}
