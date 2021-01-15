package vistas.componentes;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import vistas.eventos.EventosMateriasRegistrar;
import vistas.ventanas.VentanaMateriasRegistrar;

/**
* Class.
*/
public final class ComponentesMateriasRegistrar {
  public static JTextField fieldNombre;

  /**
  * Constructor.
  */
  private ComponentesMateriasRegistrar() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaMateriasRegistrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setBounds(250, 20, 400, 250);
    panel.setLayout(null);
    // Titulo
    JLabel labelTitulo = new JLabel("Registrar Materias");
    labelTitulo.setFont(new Font("Arial", Font.PLAIN, 22));
    labelTitulo.setBounds(120, 30, 250, 50);
    panel.add(labelTitulo);
    // dni
    JLabel labelNombre = new JLabel("Nombre");
    fieldNombre = new JTextField();
    labelNombre.setBounds(50, 100, 100, 25);
    fieldNombre.setBounds(110, 100, 200, 25);
    panel.add(labelNombre);
    panel.add(fieldNombre);
    // Boton Registrar
    JButton registrarButton = new JButton("Guardar");
    registrarButton.setBounds(110, 150, 200, 30);
    EventosMateriasRegistrar eventosMAteriasRegistrar = new EventosMateriasRegistrar();
    registrarButton.addActionListener(eventosMAteriasRegistrar);
    panel.add(registrarButton);
    // Titulo y Borde
    String title = "Registrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /**
   * Method limpia componentes.
  */
  public static void limpiar() {
    ComponentesMateriasRegistrar.fieldNombre.setText("");
  }
}
