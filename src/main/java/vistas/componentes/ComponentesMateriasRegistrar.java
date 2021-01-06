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

public class ComponentesMateriasRegistrar {
  public static JTextField fieldNombre;

  private ComponentesMateriasRegistrar(){
  }

  /** 
   * Set Componentes.
   * @param ventana ventana.
  */
  public static void set(VentanaMateriasRegistrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setBounds(200, 20, 500, 630);
    panel.setLayout(null);

    // Titulo
    JLabel labelTitulo = new JLabel("Registrar Materias");
    labelTitulo.setFont(new Font("Arial", Font.PLAIN, 22));
    labelTitulo.setBounds(200, 30, 250, 50);
    panel.add(labelTitulo);

    // dni
    JLabel labelNombre = new JLabel("Nombre");
    fieldNombre = new JTextField();
    labelNombre.setBounds(50, 100, 100, 25);
    fieldNombre.setBounds(180, 100, 200, 25);
    panel.add(labelNombre);
    panel.add(fieldNombre);

    // Boton Registrar
    JButton registrarButton = new JButton("Guardar");
    registrarButton.setBounds(180, 150, 200, 30);
    EventosMateriasRegistrar eventosMAteriasRegistrar = new EventosMateriasRegistrar();
    registrarButton.addActionListener(eventosMAteriasRegistrar);
    panel.add(registrarButton);

    // Titulo y Borde
    String title = "Registrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /** Limpia comoponentes */
  public static void limpiar() {
    // Set valores a los componenentes del modal.
    ComponentesMateriasRegistrar.fieldNombre.setText("");
  }
}
