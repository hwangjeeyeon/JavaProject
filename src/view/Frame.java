package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import controller.PropertyChangeListener;
import controller.addComponentListener;
import model.NodeFormat;
import model.PaneInfo;

public class Frame{
	JFrame frame = new JFrame();
	JSplitPane pane1;
	JSplitPane pane2;
	Frame(){
		frame.setTitle("Welecom to MindMap");
		frame.setSize(1000, 700);
		frame.setLocation(400, 200);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		NodeFormat node = new NodeFormat(0);
		PaneInfo[] Pane = new PaneInfo[3];
		for(int i=0;i<3;i++) 
			Pane[i]=new PaneInfo(Color.black, "°íµñ", 15,null);
		
		pane1 = new JSplitPane();pane2 = new JSplitPane();
		pane1.setDividerLocation(frame.getWidth()/5);
		pane1.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,new PropertyChangeListener(pane1,pane2,frame));
		
		pane2.setDividerLocation(frame.getWidth()-frame.getWidth()/5*2);
		pane2.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,new PropertyChangeListener(pane1,pane2,frame));
		
		frame.addComponentListener(new addComponentListener(pane1,pane2,frame));
		
		AttributePane attrPane=new AttributePane(node,pane2);
		MindMap mindmap = new MindMap(node,pane2,Pane,attrPane);
		TextField textfield = new TextField(node,pane2,Pane,attrPane);
		
		pane1.setLeftComponent(textfield.getTextArea());
		pane1.setRightComponent(pane2);
		
		pane2.setLeftComponent(mindmap.getMindMap());
		pane2.setRightComponent(attrPane.getInfo());
		
		frame.setJMenuBar(new MenuBar(node,Pane,pane2,attrPane,textfield).getMenuBar());
		frame.add(new ToolBar(node,pane2,Pane,attrPane,textfield).getToolBar(), BorderLayout.NORTH);
		
		frame.add(pane1);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Frame();
	}
}