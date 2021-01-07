import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonSaveCoordinates implements ActionListener {
  private JButton button = new JButton("SAVE MOUSE COORDS");

  public ButtonSaveCoordinates() {
    this.button.setPreferredSize(GUI.buttonSize);
    this.button.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e) {
    JButton button = this.getButton();
    button.setText("Save in: 3");

    final Timer save = new Timer(1000, new ActionListener() {
      int x = 2;
    
      @Override
      public void actionPerformed(ActionEvent e) {
        button.setText("Save in: " + Integer.toString(x));
        x--;
        if (x < 0){
          ((Timer)e.getSource()).stop();
          button.setText("SAVE MOUSE CORDS");
          GUI.xToClick.setText(GUI.x.getText());
          GUI.yToClick.setText(GUI.y.getText());
        }
        
      }
    });
    save.start();
  }

  public JButton getButton() {
    return this.button;
  }
}
