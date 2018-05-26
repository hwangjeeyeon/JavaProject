package view;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;
	JSplitPane pane1;
	JSplitPane pane2;
	Frame(){
		pane1 = new JSplitPane();pane2 = new JSplitPane();
		this.setTitle("Welecom to MindMap");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		this.setJMenuBar(new MenuBar().getMenuBar());
		this.add(new ToolBar().getToolBar(), BorderLayout.NORTH);

		
		pane1.setDividerLocation(200);
		pane2.setDividerLocation(600);
		pane1.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,new PropertyChangeListener());
		pane2.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,new PropertyChangeListener());
		
		pane1.setLeftComponent(new TextField().getTextArea());
		pane1.setRightComponent(pane2);
		pane2.setLeftComponent(new MindMapPane().getMindMap());
		pane2.setRightComponent(new AttributePane().getInfo());
		
		this.add(pane1);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Frame();
	}
	
	private class PropertyChangeListener implements java.beans.PropertyChangeListener{
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if(evt.getSource()==pane1)
				pane1.setDividerLocation(200);
			else if(evt.getSource()==pane2)
				pane2.setDividerLocation(600);
		}
	}
}