package view;

import java.awt.BorderLayout;
import java.awt.Color;

//import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

//import view.TextField.PropertyChangeListener;

public class AttributePane extends JFrame{
	//private JSplitPane pane;
	JPanel panel, panel2;
	AttributePane(){
		//panel = new JPanel();
		panel2 = new JPanel();
		
		//JLabel title = new JLabel("Attribute Pane",SwingConstants.CENTER);
		//pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel, panel2);
	
		JButton jb = new JButton("Attribute Pane");
		jb.setLayout(null);
		jb.setSize(300,20);
		jb.setBackground(Color.blue);
		jb.setForeground(Color.white);
		
		/*GridLayout grid = new GridLayout(7,2);
		grid.setVgap(50);
		panel2.setLayout(grid);*/
		
		panel2.add(jb, BorderLayout.NORTH);
		
		panel2.add(new JLabel("TEXT: "));
		JTextField tf = new JTextField(10);
		tf.setEditable(false);
		panel2.add(tf);
		
		panel2.add(new JLabel("X:    "));
		panel2.add(new JTextField(10));
		panel2.add(new JLabel("Y:    "));
		panel2.add(new JTextField(10));
		panel2.add(new JLabel("W:    "));
		panel2.add(new JTextField(10));
		panel2.add(new JLabel("H:    "));
		panel2.add(new JTextField(10));
		panel2.add(new JLabel("Color:"));
		panel2.add(new JTextField(10));
		
		JButton change = new JButton("º¯°æ");
		change.setLayout(null);
		change.setSize(200,20);
		change.setBackground(Color.RED);
		
		panel2.add(change);
		//pane.setTopComponent(panel2);
		//pane.setBottomComponent(change);
		//pane.setDividerLocation(590);
		//pane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,new PropertyChangeListener());
		
		//panel.add(title);
		//panel.add(pane);
	}
	JPanel getInfo() {
		return panel2;
	}
	/*private class PropertyChangeListener implements java.beans.PropertyChangeListener{
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			panel.setDividerLocation(550);
		}
	}*/
}