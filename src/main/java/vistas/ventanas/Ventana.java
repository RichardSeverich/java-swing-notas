package vistas.ventanas;

import javax.swing.JFrame;

/**
* Class.
*/
public abstract class Ventana {
  public JFrame frame;

  /**
  * Constructor.
  * @param frameName frameName.
  */
  public Ventana(String frameName) {
    this.frame = new JFrame(frameName);
    this.frame.setResizable(false);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
