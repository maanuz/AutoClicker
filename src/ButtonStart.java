import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonStart implements ActionListener {
  private JButton button = new JButton("START");

  public ButtonStart() {
    this.button.setPreferredSize(GUI.buttonSize);
    this.button.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    new ClickingClass();
  }

  public JButton getButton() {
    return this.button;
  }
}
