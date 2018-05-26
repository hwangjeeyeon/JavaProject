package view;

import java.awt.Color;
import java.beans.PropertyChangeEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class TextField extends JTextArea{
	private static final long serialVersionUID = 1L;
	private JSplitPane pane;
	JPanel panel;
	TextField(){
		panel = new JPanel();
		JButton application = new JButton("Àû¿ë");
		application.setBackground(Color.RED);
	
		JButton jb = new JButton("Text Editor Pane");
		//JLabel title = new JLabel("Text Editor",SwingConstants.CENTER);
		JScrollPane scrollBar = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//pane= new JSplitPane(JSplitPane.VERTICAL_SPLIT,false);
		
		jb.setBackground(Color.blue);
		jb.setForeground(Color.white);
		//panel.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		//this.setLineWrap(false);
		panel.add(jb);
		JTextArea ta = new JTextArea(10,15);
		panel.add(new JScrollPane(ta));
		panel.add(scrollBar);
		panel.add(application);
		//pane.setTopComponent(scrollBar);
		//pane.setBottomComponent(application);
		//pane.setDividerLocation(590);
		//pane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,new PropertyChangeListener());
		
		//panel.add(title);
		//panel.add(pane);
	}
	JPanel getTextArea() {
		return panel;
	}
	/*private class PropertyChangeListener implements java.beans.PropertyChangeListener{
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			panel.setDividerLocation(590);
		}
	}*/
}