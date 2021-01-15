package vistas.componentes;

import datos.ConexionSelectMateriasEnCurso;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import listas.ContainerListas;
import modelos.Materia;
import modelos.Curso;
import vistas.utiles.Render;
import vistas.eventos.EventosPlanMostrarMateria;
import vistas.ventanas.VentanaPlanMostrarMateria;

/**
* Class.
*/
public final class ComponentesPlanMostrarMateria {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "ID MATERIA", "NOMBRE", "ELIMINAR"};
  public static Curso course;
  public static JPanel panel;

  /**
  * Constructor.
  */
  private ComponentesPlanMostrarMateria() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaPlanMostrarMateria ventana) {
    panel = new JPanel();
    panel.setBounds(0, 0, 890, 660);
    ventana.frame.add(panel);
    panel.setLayout(new BorderLayout());
    Object[][] datos = {{null, null, null, null}};
    defaultTableModel = new DefaultTableModel(datos, columnHeaders) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    EventosPlanMostrarMateria eventosPlanMostrarMateria = new EventosPlanMostrarMateria();
    table = new JTable();
    table.addMouseListener(eventosPlanMostrarMateria);
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
    String title = "Materias en el curso " + course.nombre;
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
    table.getColumnModel().getColumn(1).setPreferredWidth(70);
    table.getColumnModel().getColumn(2).setPreferredWidth(615);
    table.getColumnModel().getColumn(3).setPreferredWidth(120);
  }

  /**
   * @return datos.
  */
  private static Object[][] construtirDatos() {
    ConexionSelectMateriasEnCurso.execute(course);
    int size = ContainerListas.getInstance().listaMaterias.size();
    Object[][] datos = new Object[size][4];
    int row = 0;
    for (Materia materia : ContainerListas.getInstance().listaMaterias) {
      JButton botonEliminar = new JButton("eliminar");
      botonEliminar.setName("eliminar");
      datos[row][0] = materia.idRelacion;
      datos[row][1] = materia.id;
      datos[row][2] = materia.nombre;
      datos[row][3] = botonEliminar;
      row++;
    }
    return datos;
  }
}
