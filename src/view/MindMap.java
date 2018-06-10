package view;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.NodeFormat;
import model.PaneInfo;

public class MindMap extends JPanel{
	private static final long serialVersionUID = 1L;

	JSplitPane frame;
	PaneInfo[] Pane;
	NodeFormat node;
	NodeLabel baner=new NodeLabel();
	NodeLabel[] lavel;
	public MindMap(NodeFormat a,JSplitPane frame,PaneInfo[] Pane, AttributePane attr){
		this.frame=frame;
		this.Pane=Pane;
		node=a;
		lavel = new NodeLabel[a.getNumber()];
		
		this.add(baner);
		
		for(int i=0;i<a.getNumber();i++) {
			lavel[i]= new NodeLabel(node,attr,Pane,i,frame);
			this.add(lavel[i].getLabel());
		}
		this.setVisible(true);
	}
	
	public JPanel getMindMap() {
		return this;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		baner.setLocation(frame.getWidth()/3, 0);
		if(lavel.length>0) 
			for(int i=0;i<lavel.length;i++) {
				lavel[i].setSize(node.getWidth(i),node.getHeight(i));
				lavel[i].setLocation(node.getX(i), node.getY(i));
				drawLine(i,g);
			}	
	}
	
	private void drawLine(int i,Graphics g) {
		if(node.getParentName(i)!=null) {
			for(int k=i;k>=0;k--) {
				if(node.getParentName(i).equals(node.getName(k))) {
					if(node.getY(k)<=node.getY(i) && node.getX(k)<=node.getX(i)) {
						g.drawLine(node.getX(k)+node.getWidth(k), node.getY(k)+node.getHeight(k)/2,node.getX(i)+node.getWidth(i)/2, node.getY(i));
						g.drawLine(node.getX(k)+node.getWidth(k), node.getY(k)+node.getHeight(k)/2, node.getX(k)+node.getWidth(k), node.getY(k)+10+node.getHeight(k)/2);
						g.drawLine(node.getX(k)+node.getWidth(k), node.getY(k)+node.getHeight(k)/2, node.getX(k)+10+node.getWidth(k), node.getY(k)+node.getHeight(k)/2);
					}
					else if(node.getY(k)<=node.getY(i) && node.getX(k)>node.getX(i)) {
						g.drawLine(node.getX(k)+node.getWidth(k)/2, node.getY(k)+node.getHeight(k),node.getX(i)+node.getWidth(i)/2, node.getY(i));
						g.drawLine(node.getX(k)+node.getWidth(k)/2, node.getY(k)+node.getHeight(k), node.getX(k)+node.getWidth(k)/2-10, node.getY(k)+node.getHeight(k));
						g.drawLine(node.getX(k)+node.getWidth(k)/2, node.getY(k)+node.getHeight(k),node.getX(k)+node.getWidth(k)/2, node.getY(k)+node.getHeight(k)+10 );
					}
					else if(node.getY(k)>node.getY(i) && node.getX(k)<=node.getX(i)) {
						g.drawLine(node.getX(k)+node.getWidth(k)/2, node.getY(k),node.getX(i)+node.getWidth(i)/2, node.getY(i)+node.getHeight(i));
						g.drawLine(node.getX(k)+node.getWidth(k)/2, node.getY(k), node.getX(k)+node.getWidth(k)/2+10, node.getY(k));
						g.drawLine(node.getX(k)+node.getWidth(k)/2, node.getY(k), node.getX(k)+node.getWidth(k)/2, node.getY(k)-10);
					}
					else if(node.getY(k)>node.getY(i) && node.getX(k)>node.getX(i)) {
						g.drawLine(node.getX(k), node.getY(k)+node.getHeight(k)/2,node.getX(i)+node.getWidth(i)/2, node.getY(i)+node.getHeight(i));
						g.drawLine(node.getX(k), node.getY(k)+node.getHeight(k)/2,node.getX(k), node.getY(k)+node.getHeight(k)/2-10 );
						g.drawLine(node.getX(k), node.getY(k)+node.getHeight(k)/2,node.getX(k)-10, node.getY(k)+node.getHeight(k)/2 );
					}
					break;
				}
			}
		}
	}
}