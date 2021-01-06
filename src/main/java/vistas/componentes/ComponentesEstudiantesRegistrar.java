package vistas.componentes;

import java.awt.Font;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import vistas.eventos.EventosEstudiantesRegistrar;
import vistas.utiles.DateLabelFormatter;
import vistas.ventanas.VentanaEstudiantesRegistrar;

public class ComponentesEstudiantesRegistrar {
  public static JTextField fieldDni;
  public static JTextField fieldNombres;
  public static JTextField fieldApellidos;
  public static JDatePickerImpl datePicker;
  public static JTextField fieldTelefono;
  public static JTextField fieldDireccion;
  public static JTextField fieldEmail;

  private ComponentesEstudiantesRegistrar(){
  }

  /** 
   * Set Componentes.
   * @param ventana ventana.
  */
  public static void set(VentanaEstudiantesRegistrar ventana) {
    JPanel panel = new JPanel();
    ventana.frame.add(panel);
    panel.setBounds(200, 20, 500, 630);
    panel.setLayout(null);

    // Titulo
    JLabel labelTitulo = new JLabel("Registrar Estudiantes");
    labelTitulo.setFont(new Font("Arial", Font.PLAIN, 22));
    labelTitulo.setBounds(200, 30, 250, 50);
    panel.add(labelTitulo);

    // dni
    JLabel labelDni = new JLabel("Numero Identidad");
    fieldDni = new JTextField();
    labelDni.setBounds(50, 100, 100, 25);
    fieldDni.setBounds(200, 100, 200, 25);
    panel.add(labelDni);
    panel.add(fieldDni);

    // Nombres
    JLabel labelNombres = new JLabel("Nombres");
    fieldNombres = new JTextField();
    labelNombres.setBounds(50, 150, 100, 25);
    fieldNombres.setBounds(200, 150, 200, 25);
    panel.add(labelNombres);
    panel.add(fieldNombres);

    // Apellidos
    JLabel labelApellidos = new JLabel("Apellidos");
    fieldApellidos = new JTextField();
    labelApellidos.setBounds(50, 200, 100, 25);
    fieldApellidos.setBounds(200, 200, 200, 25);
    panel.add(labelApellidos);
    panel.add(fieldApellidos);

    // Fecha nacimiento
    UtilDateModel model = new UtilDateModel();
    Properties properties = new Properties();
    properties.put("text.today", "Today");
    properties.put("text.month", "Month");
    properties.put("text.year", "Year");
    JLabel labelFechaNacimiento = new JLabel("Fecha Nacimiento");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
    datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    model.setSelected(true);
    labelFechaNacimiento.setBounds(50, 250, 120, 25);
    datePicker.setBounds(200, 250, 200, 25);
    panel.add(labelFechaNacimiento);
    panel.add(datePicker);

    // Telefono
    JLabel labelTelefono = new JLabel("Telefono");
    fieldTelefono = new JTextField();
    labelTelefono.setBounds(50, 300, 100, 25);
    fieldTelefono.setBounds(200, 300, 200, 25);
    panel.add(labelTelefono);
    panel.add(fieldTelefono);

    // Direccion
    JLabel labelDireccion = new JLabel("Direccion");
    fieldDireccion = new JTextField();
    labelDireccion.setBounds(50, 350, 100, 25);
    fieldDireccion.setBounds(200, 350, 200, 25);
    panel.add(labelDireccion);
    panel.add(fieldDireccion);

    // Email
    JLabel labelEmail = new JLabel("Correo");
    fieldEmail = new JTextField();
    labelEmail.setBounds(50, 400, 100, 25);
    fieldEmail.setBounds(200, 400, 200, 25);
    panel.add(labelEmail);
    panel.add(fieldEmail);

    // Boton Registrar
    JButton registrarButton = new JButton("Guardar");
    registrarButton.setBounds(200, 520, 200, 30);
    EventosEstudiantesRegistrar eventosEstudiantesRegistrar = new EventosEstudiantesRegistrar();
    registrarButton.addActionListener(eventosEstudiantesRegistrar);
    panel.add(registrarButton);

    // Titulo y Borde
    String title = "Registrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /** Limpia comoponentes */
  public static void limpiar() {
    // Set valores a los componenentes del modal.
    ComponentesEstudiantesRegistrar.fieldDni.setText("");
    ComponentesEstudiantesRegistrar.fieldNombres.setText("");
    ComponentesEstudiantesRegistrar.fieldApellidos.setText("");
    ComponentesEstudiantesRegistrar.fieldTelefono.setText("");
    ComponentesEstudiantesRegistrar.fieldDireccion.setText("");
    ComponentesEstudiantesRegistrar.fieldEmail.setText("");
  }
}
