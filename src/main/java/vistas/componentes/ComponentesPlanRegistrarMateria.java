package vistas.componentes;

import datos.ConexionSelectMateriasNoEnCurso;
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
import vistas.eventos.EventosPlanRegistrarMateria;
import vistas.ventanas.VentanaPlanRegistrarMateria;

/**
* Class.
*/
public final class ComponentesPlanRegistrarMateria {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "NOMBRE", "AGREGAR"};
  public static Curso course;
  public static JPanel panel;

  /**
  * Constructor.
  */
  private ComponentesPlanRegistrarMateria() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaPlanRegistrarMateria ventana) {
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
    EventosPlanRegistrarMateria eventosPlanRegistrarMateria = new EventosPlanRegistrarMateria();
    table = new JTable();
    table.addMouseListener(eventosPlanRegistrarMateria);
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
    String title = "Agregar materias al curso " + course.nombre;
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
    ConexionSelectMateriasNoEnCurso.execute(course);
    int size = ContainerListas.getInstance().listaMaterias.size();
    Object[][] datos = new Object[size][3];
    int row = 0;
    for (Materia materia : ContainerListas.getInstance().listaMaterias) {
      JButton botonAgregar = new JButton("agregar");
      botonAgregar.setName("agregar");
      datos[row][0] = materia.id;
      datos[row][1] = materia.nombre;
      datos[row][2] = botonAgregar;
      row++;
    }
    return datos;
  }
}
