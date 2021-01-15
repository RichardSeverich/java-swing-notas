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

/**
* Class.
*/
public final class ComponentesCursosRegistrar {
  public static JTextField fieldNombre;

  /**
  * Constructor.
  */
  private ComponentesCursosRegistrar() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaCursosRegistrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setBounds(250, 20, 400, 250);
    panel.setLayout(null);
    JLabel labelTitulo = new JLabel("Registrar Cursos");
    labelTitulo.setFont(new Font("Arial", Font.PLAIN, 22));
    labelTitulo.setBounds(120, 30, 250, 50);
    panel.add(labelTitulo);
    JLabel labelNombre = new JLabel("Nombre");
    fieldNombre = new JTextField();
    labelNombre.setBounds(50, 100, 100, 25);
    fieldNombre.setBounds(110, 100, 200, 25);
    panel.add(labelNombre);
    panel.add(fieldNombre);
    JButton registrarButton = new JButton("Guardar");
    registrarButton.setBounds(110, 150, 200, 30);
    EventosCursosRegistrar eventosCursosRegistrar = new EventosCursosRegistrar();
    registrarButton.addActionListener(eventosCursosRegistrar);
    panel.add(registrarButton);
    String title = "Registrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /**
   * Method limpia.
  */
  public static void limpiar() {
    ComponentesCursosRegistrar.fieldNombre.setText("");
  }
}
