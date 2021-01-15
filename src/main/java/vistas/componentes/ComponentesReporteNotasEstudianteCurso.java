package vistas.componentes;

import datos.ConexionSelectCursosDeEstudiante;

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
import vistas.eventos.EventosReporteNotasEstudianteCurso;
import vistas.eventos.EventosReporteNotasEstudianteEstudiante;
import vistas.ventanas.VentanaReporteNotasEstudianteCurso;

/**
* Class.
*/
public final class ComponentesReporteNotasEstudianteCurso {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static JPanel panel;
  public static String[] columnHeaders = new String[] {"ID", "NOMBRE", "SELECCIONAR"};

  /**
  * Constructor.
  */
  private ComponentesReporteNotasEstudianteCurso() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaReporteNotasEstudianteCurso ventana) {
    panel = new JPanel();
    panel.setBounds(0, 0, 890, 660);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object[][] datos = {{null, null, null}};
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosReporteNotasEstudianteCurso eventosReporteNotasEstudianteCurso = new EventosReporteNotasEstudianteCurso();
    table = new JTable();
    table.addMouseListener(eventosReporteNotasEstudianteCurso);
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
    String title = "Seleccionar Curso del estudiante "
        + EventosReporteNotasEstudianteEstudiante.estudiante.nombres + " "
        + EventosReporteNotasEstudianteEstudiante.estudiante.apellidos;
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
    table.getColumnModel().getColumn(0).setPreferredWidth(80);
    table.getColumnModel().getColumn(1).setPreferredWidth(675);
    table.getColumnModel().getColumn(2).setPreferredWidth(120);
  }

  /**
   * @return datos.
  */
  private static Object[][] construtirDatos() {
    Estudiante estudiante = EventosReporteNotasEstudianteEstudiante.estudiante;
    ConexionSelectCursosDeEstudiante.execute(estudiante);
    int size = ContainerListas.getInstance().listaCursos.size();
    Object[][] datos = new Object[size][3];
    int row = 0;
    for (Curso curso : ContainerListas.getInstance().listaCursos) {
      JButton botonSeleccionar = new JButton("seleccionar");
      botonSeleccionar.setName("seleccionar");
      datos[row][0] = curso.id;
      datos[row][1] = curso.nombre;
      datos[row][2] = botonSeleccionar;
      row++;
    }
    return datos;
  }
}
