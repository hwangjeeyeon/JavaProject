package controller;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class PropertyChangeListener implements java.beans.PropertyChangeListener{
	JSplitPane pane1, pane2;
	JFrame frame;
	public PropertyChangeListener(JSplitPane pane1, JSplitPane pane2, JFrame frame){
		super();
		this.pane1=pane1;this.pane2=pane2;
		this.frame = frame;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getSource()==pane1)
			pane1.setDividerLocation(frame.getWidth()/5);
		else if(evt.getSource()==pane2)
			pane2.setDividerLocation(frame.getWidth()-frame.getWidth()/5*2);
	}
}