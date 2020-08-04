package vistas.componentes;

import javax.swing.JMenu;
import javax.swing.JMenuItem ;
import javax.swing.JMenuBar ;

import vistas.ventanas.VentanaDashboard;
import vistas.eventos.EventosNavegar;

public class ComponentesDashboard {

  private ComponentesDashboard(){

  }

  public static void set(VentanaDashboard ventana) {
    JMenuBar menuBar = new JMenuBar();
    // USUARIOS
    JMenu menuUsuarios = new JMenu("Usuarios"); 
    JMenuItem menuItemUsuariosRegistrar =  new JMenuItem("Usuarios Registrar");
    JMenuItem menuItemUsuariosMostrar =  new JMenuItem("Usuarios Mostrar");
    EventosNavegar eventosNavegar = new EventosNavegar();
    menuItemUsuariosRegistrar.addActionListener(eventosNavegar);
    menuUsuarios.add(menuItemUsuariosRegistrar);
    menuUsuarios.add(menuItemUsuariosMostrar);
    menuBar.add(menuUsuarios);
    // ESTUDIANTES
    JMenu menuEstudiantes = new JMenu("Estudiantes"); 
    JMenuItem menuItemEstudiantesRegistrar =  new JMenuItem("Estudiantes Registrar");
    JMenuItem menuItemEstudiantesMostrar =  new JMenuItem("Estudiantes Mostrar");
    menuEstudiantes.add(menuItemEstudiantesRegistrar);
    menuEstudiantes.add(menuItemEstudiantesMostrar);
    menuBar.add(menuEstudiantes);
    // MATERIAS
    JMenu menuMaterias = new JMenu("Materias"); 
    JMenuItem menuItemMateriasRegistrar =  new JMenuItem("Materias Registrar");
    JMenuItem menuItemMateriasMostrar =  new JMenuItem("Materias Mostrar");
    menuMaterias.add(menuItemMateriasRegistrar);
    menuMaterias.add(menuItemMateriasMostrar);
    menuBar.add(menuMaterias);
    // MATERIAS
    JMenu menuCursos = new JMenu("Cursos"); 
    JMenuItem menuItemCursosRegistrar =  new JMenuItem("Cursos Registrar");
    JMenuItem menuItemCursosMostrar =  new JMenuItem("Cursos Mostrar");
    menuCursos.add(menuItemCursosRegistrar);
    menuCursos.add(menuItemCursosMostrar);
    menuBar.add(menuCursos);
    // NOTAS
    JMenu menuNotas = new JMenu("Notas"); 
    JMenuItem menuItemNotasRegistrar =  new JMenuItem("Notas Registrar");
    JMenuItem menuItemNotasMostrar =  new JMenuItem("Notas Mostrar");
    menuNotas.add(menuItemNotasRegistrar);
    menuNotas.add(menuItemNotasMostrar);
    menuBar.add(menuNotas);
    // FIRMA DIGITAL
    JMenu menuFirma = new JMenu("Firma Digital"); 
    JMenuItem menuItemFirmaRegistrar =  new JMenuItem("Firma Registrar");
    JMenuItem menuItemFirmaMostrar =  new JMenuItem("Firma Mostrar");
    menuFirma.add(menuItemFirmaRegistrar);
    menuFirma.add(menuItemFirmaMostrar);
    menuBar.add(menuFirma);
    // REPORTES
    JMenu menuReportes = new JMenu("Reportes"); 
    JMenuItem menuItemNotasPorCurso =  new JMenuItem("Reporte notas por curso");
    JMenuItem menuItemNotasPorEstudiante =  new JMenuItem("Reporte notas por estudiante");
    menuReportes.add(menuItemNotasPorCurso);
    menuReportes.add(menuItemNotasPorEstudiante);
    menuBar.add(menuReportes);
    ventana.frame.setJMenuBar(menuBar);  
  }
}
