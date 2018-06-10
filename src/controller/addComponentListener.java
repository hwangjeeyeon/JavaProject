package controller;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class addComponentListener extends ComponentAdapter{
	JSplitPane pane1, pane2;
	JFrame frame;
	
	public addComponentListener(JSplitPane pane1, JSplitPane pane2, JFrame frame){
		super();
		this.pane1=pane1;this.pane2=pane2;
		this.frame = frame;
	}
	
	@Override
	public void componentResized(ComponentEvent evt){
		if(evt.getSource() == frame) {
			pane1.setDividerLocation(frame.getWidth()/5);
			pane2.setDividerLocation(frame.getWidth()-frame.getWidth()/5*2);
			pane1.repaint();
			pane2.repaint();
		}
	}
}