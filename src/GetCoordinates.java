import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GetCoordinates {
	public GetCoordinates() {
		Timer getCords = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.setGUIInfo(MouseInfo.getPointerInfo().getLocation()
						.getX(), MouseInfo.getPointerInfo().getLocation()
						.getY());
			}
		});
		getCords.start();
	}
}
