import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Buttons {
	
	static JButton saveCoords = new JButton ("SAVE MOUSE COORDS");
	static Dimension buttonSize = new Dimension(170, 25);
		
	public static Component start(){
		JButton start = new JButton ("START");
		start.setPreferredSize(buttonSize);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ClickingClass();
			}
		});
		return start;
	}
	
	public static Component saveCoords(){
		saveCoords.setPreferredSize(buttonSize);
		saveCoords.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				saveCoords.setLabel("Save in: 3");
				final Timer save = new Timer(1000, new ActionListener() {
					int x = 2;
					
					@Override
					public void actionPerformed(ActionEvent e) {
						saveCoords.setLabel("Save in: " + Integer.toString(x));
						x--;
						if (x < 0){
							((Timer)e.getSource()).stop();
							saveCoords.setLabel("SAVE MOUSE CORDS");
							GUI.xToClick.setText(GUI.x.getText());
							GUI.yToClick.setText(GUI.y.getText());
						}
						
					}
				});
				save.start();
			}
		});
		return saveCoords;
	}
}
