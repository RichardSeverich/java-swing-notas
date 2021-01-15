package vistas.componentes;

import datos.ConexionSelectEstudiantesEnCurso;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import listas.ContainerListas;
import modelos.Curso;
import modelos.Estudiante;
import vistas.utiles.Render;
import vistas.eventos.EventosNotasRegistrarEstudiante;
import vistas.ventanas.VentanaNotasRegistrarEstudiante;

/**
* Class.
*/
public final class ComponentesNotasRegistrarEstudiante {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "DNI", "NOMBRES", "APELLIDOS",
    "SELECCIONAR"
  };
  public static Curso course;
  public static JPanel panel;

  /**
  * Constructor.
  */
  private ComponentesNotasRegistrarEstudiante() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaNotasRegistrarEstudiante ventana) {
    panel = new JPanel();
    panel.setBounds(0, 0, 890, 660);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object[][] datos = {{null, null, null, null, null}};
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosNotasRegistrarEstudiante eventosNotasRegistrarEstudiante = new EventosNotasRegistrarEstudiante();
    table = new JTable();
    table.addMouseListener(eventosNotasRegistrarEstudiante);
    table.setDefaultRenderer(Object.class, new Render());
    table.setModel(defaultTableModel);
    JScrollPane scrollPane = new JScrollPane(table,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    panel.add(scrollPane);
  }

  /**
   * Method actualiza tabla.
  */
  public static void actualizarTabla() {
    String title = "Seleccionar estudiante del curso " + course.nombre;
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
    Object[][] datos = construtirDatos();
    defaultTableModel.setDataVector(datos, columnHeaders);
    setPreferredWidth();
  }

  /**
   * Method set columnas.
  */
  private static void setPreferredWidth() {
    table.getColumnModel().getColumn(0).setPreferredWidth(70);
    table.getColumnModel().getColumn(1).setPreferredWidth(105);
    table.getColumnModel().getColumn(2).setPreferredWidth(290);
    table.getColumnModel().getColumn(3).setPreferredWidth(290);
    table.getColumnModel().getColumn(4).setPreferredWidth(120);
  }

  /**
   * @return datos.
  */
  private static Object[][] construtirDatos() {
    ConexionSelectEstudiantesEnCurso.execute(course);
    int size = ContainerListas.getInstance().listaEstudiantes.size();
    Object[][] datos = new Object[size][5];
    int row = 0;
    for (Estudiante estudiante : ContainerListas.getInstance().listaEstudiantes) {
      JButton botonSeleccionar = new JButton("seleccionar");
      botonSeleccionar.setName("seleccionar");
      datos[row][0] = estudiante.id;
      datos[row][1] = estudiante.dni;
      datos[row][2] = estudiante.nombres;
      datos[row][3] = estudiante.apellidos;
      datos[row][4] = botonSeleccionar;
      row++;
    }
    return datos;
  }
}
