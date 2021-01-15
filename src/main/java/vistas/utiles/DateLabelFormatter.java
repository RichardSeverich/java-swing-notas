package vistas.utiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField.AbstractFormatter;

/**
* Class.
*/
public class DateLabelFormatter extends AbstractFormatter {
  private String datePattern = "yyyy-MM-dd";
  private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

  /**
  * {@inheritDoc}
  */
  @Override
  public Object stringToValue(String text) throws ParseException {
    return dateFormatter.parseObject(text);
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public String valueToString(Object value) throws ParseException {
    if (value != null) {
      Calendar cal = (Calendar) value;
      return dateFormatter.format(cal.getTime());
    }
    return "";
  }
}
