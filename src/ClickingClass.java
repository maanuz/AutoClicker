import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.Timer;

public class ClickingClass implements ActionListener {
  
	private Robot mouseActionRobot;
	private Timer mouseClickTimer;

  public ClickingClass() {

    try {
      this.mouseActionRobot = new Robot();
      this.mouseActionRobot.mouseMove(Integer.parseInt(GUI.xToClick.getText()), Integer.parseInt(GUI.yToClick.getText()));

      try { //first click after pressing start
        Thread.sleep(500);
        this.mouseActionRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.mouseActionRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      } catch (InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      this.start();
    } catch (AWTException e1) {
      System.out.println("error");
    }
  }

  private void start() {
    int interval = Integer.parseInt(GUI.clickSpeed.getText());

    if (GUI.randomizeClickspeed.isSelected()) {
      int d = (int)Math.floor(Math.random() * (interval + 1) * 0.05);
      System.out.println(d);
      if (Math.random() < 0.5) {
        interval += d;
      } else {
        interval -= d;
      }
    }
    this.mouseClickTimer = new Timer(interval, this);
    this.mouseClickTimer.start();
  }

  public void actionPerformed(ActionEvent e) {

    if (GUI.xToClick.getText().equals(GUI.x.getText()) && GUI.yToClick.getText().equals(GUI.y.getText())) {
      //clicks mouse at coordinates
      // this.mouseActionRobot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      // this.mouseActionRobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      
      // if random click speed is selected, stop and start new timer with new interval
      if (GUI.randomizeClickspeed.isSelected()) {
        this.mouseClickTimer.stop();
        this.start();
      }
    } else {
      this.mouseClickTimer.stop(); //moving mouse, stops clicking
    }
  }
}
