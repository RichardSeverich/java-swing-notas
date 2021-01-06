package vistas.componentes;

import datos.ConexionSelectEstudiantes;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import listas.ContainerListas;
import modelos.Estudiante;
import vistas.utiles.Render;
import vistas.eventos.EventosEstudiantesMostrar;
import vistas.ventanas.VentanaEstudiantesMostrar;

public class ComponentesEstudiantesMostrar {

  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "DNI","NOMBRES", "APELLIDOS",
    "FECHA NACIMIENTO", "TELEPHONE", "ADRESS", "EMAIL", "EDITAR", "ELIMINAR"
  };

  private ComponentesEstudiantesMostrar(){
  }

  /** Set Componentes.*/
  public static void set(VentanaEstudiantesMostrar ventana) {
    JPanel panel = new JPanel();
    panel.setBounds(40, 20, 800, 630);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object [][] datos = { {null, null, null, null, null, null, null, null, null, null} };
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosEstudiantesMostrar eventosEstudiantesMostrar = new EventosEstudiantesMostrar();
    table = new JTable();
    table.addMouseListener(eventosEstudiantesMostrar);
    table.setDefaultRenderer(Object.class, new Render());
    table.setModel(defaultTableModel);
    //table.setEnabled(false);
    JScrollPane scrollPane = new JScrollPane(table,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    panel.add(scrollPane);
    // Titulo y Borde
    String title = "Mostrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /** Actualiza tabla.*/
  public static void actualizarTabla() {
    Object[][] datos = construtirDatos();
    defaultTableModel.setDataVector(datos, columnHeaders);
    setPreferredWidth();
  }

  private static void setPreferredWidth() {
    // Set columns width
    table.getColumnModel().getColumn(0).setPreferredWidth(50);
    table.getColumnModel().getColumn(1).setPreferredWidth(70);
    table.getColumnModel().getColumn(2).setPreferredWidth(90);
    table.getColumnModel().getColumn(3).setPreferredWidth(120);
    table.getColumnModel().getColumn(4).setPreferredWidth(90);
    table.getColumnModel().getColumn(5).setPreferredWidth(90);
    table.getColumnModel().getColumn(6).setPreferredWidth(170);
    table.getColumnModel().getColumn(7).setPreferredWidth(120);
    table.getColumnModel().getColumn(8).setPreferredWidth(90);
    table.getColumnModel().getColumn(9).setPreferredWidth(90);
  }

  private static Object[][] construtirDatos() {
    ConexionSelectEstudiantes.execute();
    int size = ContainerListas.getInstance().listaEstudiantes.size();
    Object[][] datos = new Object[size][10];
    int row = 0;
    for (Estudiante estudiante : ContainerListas.getInstance().listaEstudiantes) {
      JButton botonEditar = new JButton("Editar");
      JButton botonEliminar = new JButton("Eliminar");
      botonEditar.setName("Editar");
      botonEliminar.setName("Eliminar");
      datos[row][0] = estudiante.id;
      datos[row][1] = estudiante.dni;
      datos[row][2] = estudiante.nombres;
      datos[row][3] = estudiante.apellidos;
      datos[row][4] = estudiante.fechaNacimiento;
      datos[row][5] = estudiante.telefono;
      datos[row][6] = estudiante.direccion;
      datos[row][7] = estudiante.email;
      datos[row][8] = botonEditar;
      datos[row][9] = botonEliminar;
      row++;
    }
    return datos;
  }
}
