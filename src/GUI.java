import java.awt.*;

import javax.swing.*;

public class GUI {
	static Dimension xAndYSize = new Dimension(50, 20);
  	static Dimension buttonSize = new Dimension(170, 25);
	static JFrame f = new JFrame("MnZ");
	static JTextField x = new JTextField();
	static JTextField y = new JTextField();
	static JCheckBox allwaysTopBox = new JCheckBox();
	static JCheckBox randomizeClickspeed = new JCheckBox();
	static JTextArea xToClick = new JTextArea("0");
	static JTextArea yToClick = new JTextArea("0");
	static JTextArea clickSpeed = new JTextArea("10");
	
	static JPanel p = new JPanel();
	
	public static void createGUI() {

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);

		p.add(Labels.xString);
		p.add(x);
		p.add(Labels.yString);
		p.add(y);

		x.setEditable(false);
		y.setEditable(false);
		Labels.xString.setBorder(null);
		Labels.yString.setBorder(null);

		x.setBackground(Color.WHITE);
		y.setBackground(Color.WHITE);
		x.setPreferredSize(xAndYSize);
		y.setPreferredSize(xAndYSize);
		
		p.add(Labels.topString);
		p.add(allwaysTopBox);
		
		xToClick.setPreferredSize(xAndYSize);
		xToClick.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		yToClick.setPreferredSize(xAndYSize);
		yToClick.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		clickSpeed.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		clickSpeed.setPreferredSize(xAndYSize);
		
		p.add(Labels.xToClickStr);
		p.add(xToClick);
		p.add(Labels.yToClickStr);
		p.add(yToClick);
		p.add(Labels.clickSpeedStr);
		p.add(clickSpeed);
		p.add(Labels.speedMs);
		
		p.add(Labels.randomizeClickspeed);
		p.add(randomizeClickspeed);
		
		ButtonSaveCoordinates bsc = new ButtonSaveCoordinates();
		p.add(bsc.getButton());
		ButtonStart bs = new ButtonStart();
		p.add(bs.getButton());
		p.add(Labels.stopInfo);
		
		f.setSize(220, 280);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	public static void setGUIInfo(Double xCoord, Double yCoord){
		Integer xC = xCoord.intValue();
		Integer yC = yCoord.intValue();
		x.setText(xC.toString());
		y.setText(yC.toString());
		if (allwaysTopBox.isSelected()){
			f.setAlwaysOnTop(true);
		} else {
			f.setAlwaysOnTop(false);
		}
	}
}
