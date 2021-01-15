import datos.ReadConfigProperties;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public final class Main {

  /**
  * Constructor.
  */
  private Main() {
  }

  /**
  * @param args args.
  */
  public static void main(String[] args) {
    ReadConfigProperties.leer();
    VentanaContainer
      .getInstancia()
      .ventanaLogin
      .frame
      .setVisible(true);
  }
}
