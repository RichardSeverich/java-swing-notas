package vistas.componentes;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import vistas.eventos.EventosCursosRegistrar;
import vistas.ventanas.VentanaCursosRegistrar;

public class ComponentesCursosRegistrar {
  public static JTextField fieldNombre;

  private ComponentesCursosRegistrar(){
  }

  /** 
   * Set Componentes.
   * @param ventana ventana.
  */
  public static void set(VentanaCursosRegistrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setBounds(200, 20, 500, 630);
    panel.setLayout(null);

    // Titulo
    JLabel labelTitulo = new JLabel("Registrar Cursos");
    labelTitulo.setFont(new Font("Arial", Font.PLAIN, 22));
    labelTitulo.setBounds(200, 30, 250, 50);
    panel.add(labelTitulo);

    // Nombre
    JLabel labelNombre = new JLabel("Nombre");
    fieldNombre = new JTextField();
    labelNombre.setBounds(50, 100, 100, 25);
    fieldNombre.setBounds(180, 100, 200, 25);
    panel.add(labelNombre);
    panel.add(fieldNombre);

    // Boton Registrar
    JButton registrarButton = new JButton("Guardar");
    registrarButton.setBounds(180, 150, 200, 30);
    EventosCursosRegistrar eventosCursosRegistrar = new EventosCursosRegistrar();
    registrarButton.addActionListener(eventosCursosRegistrar);
    panel.add(registrarButton);

    // Titulo y Borde
    String title = "Registrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /** Limpia comoponentes */
  public static void limpiar() {
    // Set valores a los componenentes del modal.
    ComponentesCursosRegistrar.fieldNombre.setText("");
  }
}
