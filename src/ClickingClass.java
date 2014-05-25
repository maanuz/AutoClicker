import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.Timer;

public class ClickingClass {
	
	public ClickingClass() {
		final Robot mouseActionRobot;
		try {
			mouseActionRobot = new Robot();
			mouseActionRobot.mouseMove(Integer.parseInt(GUI.xToClick.getText()), Integer.parseInt(GUI.yToClick.getText()));
			Timer mouseClickTimer = new Timer(Integer.parseInt(GUI.clickSpeed.getText()), new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (GUI.xToClick.getText().equals(
							GUI.x.getText())
							&& GUI.yToClick.getText().equals(
									GUI.y.getText()))
					{ //clicks mouse at coordinates
						mouseActionRobot.mousePress(InputEvent.BUTTON1_MASK);
						mouseActionRobot.mouseRelease(InputEvent.BUTTON1_MASK);
						
					} else {
						((Timer)e.getSource()).stop(); //moving mouse, stops clicking
					}
				}
			});
			
			mouseClickTimer.start();
		} catch (AWTException e1) {
			System.out.println("error");
		}
	}
}
