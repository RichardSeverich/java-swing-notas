package vistas.componentes;

import datos.ConexionSelectMateriasEnCurso;
import datos.ConexionSelectMateriasEnCursoNota;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import listas.ContainerListas;
import modelos.Curso;
import modelos.Estudiante;
import modelos.Materia;
import vistas.eventos.EventosReporteNotasEstudianteCurso;
import vistas.eventos.EventosReporteNotasEstudianteEstudiante;
import vistas.utiles.Render;
import vistas.ventanas.VentanaReporteNotasEstudianteMateria;

/**
* Class.
*/
public final class ComponentesReporteNotasEstudianteMateria {
  public static DefaultTableModel defaultTableModel;
  public static JTable table;
  public static String[] columnHeaders = new String[] {"ID", "ID MATERIA", "NOMBRE", "NOTA"};
  public static JPanel panel;

  /**
  * Constructor.
  */
  private ComponentesReporteNotasEstudianteMateria() {
  }

  /**
   * @param ventana ventana.
  */
  public static void set(VentanaReporteNotasEstudianteMateria ventana) {
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
    table = new JTable();
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
    String title = "Materias del Curso " + EventosReporteNotasEstudianteCurso.curso.nombre
        + " Estudiante " + EventosReporteNotasEstudianteEstudiante.estudiante.nombres
        + " " + EventosReporteNotasEstudianteEstudiante.estudiante.apellidos;
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
    table.getColumnModel().getColumn(2).setPreferredWidth(610);
    table.getColumnModel().getColumn(3).setPreferredWidth(95);
  }

  /**
   * @return datos.
  */
  private static Object[][] construtirDatos() {
    Curso curso = EventosReporteNotasEstudianteCurso.curso;
    Estudiante estudiante = EventosReporteNotasEstudianteEstudiante.estudiante;
    ConexionSelectMateriasEnCurso.execute(curso);
    ConexionSelectMateriasEnCursoNota.execute(curso, estudiante);
    int size = ContainerListas.getInstance().listaMaterias.size();
    Object[][] datos = new Object[size][4];
    int row = 0;
    for (Materia materia : ContainerListas.getInstance().listaMaterias) {
      materia.nota = "0";
      setNota(materia);
      datos[row][0] = materia.idRelacion;
      datos[row][1] = materia.id;
      datos[row][2] = materia.nombre;
      datos[row][3] = materia.nota;
      row++;
    }
    return datos;
  }

  /**
   * @param materia materia.
  */
  private static void setNota(Materia materia) {
    for (Materia materiaAux : ContainerListas.getInstance().listaMateriasAux) {
      if (materiaAux.id == materia.id) {
        materia.nota = materiaAux.nota;
      }
    }
  }
}
