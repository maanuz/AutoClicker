import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GetCoordinates implements ActionListener {
	public GetCoordinates() {
		Timer getCords = new Timer(10, this);
		getCords.start();
	}

	public void actionPerformed(ActionEvent e) {
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		GUI.setGUIInfo(mouse.getX(), mouse.getY());
	}
}
