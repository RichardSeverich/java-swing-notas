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
import vistas.eventos.EventosInscripcionMostrarEstudiante;
import vistas.ventanas.VentanaInscripcionMostrarEstudiante;

/**
* Class.
*/
public final class ComponentesInscripcionMostrarEstudiante {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "ID ESTUDIANTE", "DNI", "NOMBRES", "APELLIDOS",
    "ELIMINAR"
  };
  public static Curso course;
  public static JPanel panel;

  /**
  * Constructor.
  */
  private ComponentesInscripcionMostrarEstudiante() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaInscripcionMostrarEstudiante ventana) {
    panel = new JPanel();
    panel.setBounds(0, 0, 890, 660);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object[][] datos = {{null, null, null, null, null, null}};
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosInscripcionMostrarEstudiante eventosInscripcionMostrarEstudiante = new EventosInscripcionMostrarEstudiante();
    table = new JTable();
    table.addMouseListener(eventosInscripcionMostrarEstudiante);
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
    String title = "Estudiantes en el curso " + course.nombre;
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
    table.getColumnModel().getColumn(1).setPreferredWidth(100);
    table.getColumnModel().getColumn(2).setPreferredWidth(90);
    table.getColumnModel().getColumn(3).setPreferredWidth(250);
    table.getColumnModel().getColumn(4).setPreferredWidth(250);
    table.getColumnModel().getColumn(5).setPreferredWidth(120);
  }

  /**
  * @return datos.
  */
  private static Object[][] construtirDatos() {
    ConexionSelectEstudiantesEnCurso.execute(course);
    int size = ContainerListas.getInstance().listaEstudiantes.size();
    Object[][] datos = new Object[size][6];
    int row = 0;
    for (Estudiante estudiante : ContainerListas.getInstance().listaEstudiantes) {
      JButton botonEliminar = new JButton("eliminar");
      botonEliminar.setName("eliminar");
      datos[row][0] = estudiante.idRelacion;
      datos[row][1] = estudiante.id;
      datos[row][2] = estudiante.dni;
      datos[row][3] = estudiante.nombres;
      datos[row][4] = estudiante.apellidos;
      datos[row][5] = botonEliminar;
      row++;
    }
    return datos;
  }
}
