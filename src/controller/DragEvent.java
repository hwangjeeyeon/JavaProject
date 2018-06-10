package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JSplitPane;

import model.NodeFormat;
import model.PaneInfo;
import view.AttributePane;
import view.MindMap;
import view.NodeLabel;

public class DragEvent extends MouseAdapter{
	NodeFormat node;
	AttributePane attr;
	JSplitPane pane;
	PaneInfo[] Pane;
	JLabel Label = new JLabel();
	NodeLabel k;
	
	int i,x,y;
		
	private boolean isBorder1 = false;
	private boolean isBorder2 = false;
	private boolean isBorder3 = false;
	private boolean isBorder4 = false;
	
	public DragEvent(NodeFormat node,AttributePane attr, JSplitPane pane,PaneInfo[] Pane,int i,NodeLabel k){
		this.node=node;
		this.attr=attr;
		this.pane=pane;
		this.i=i;
		this.Pane = Pane;
		this.k=k;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		x=e.getX();y=e.getY();
		if((0<=x&& x<=3))
			isBorder1=true;
		else if(node.getWidth(i)-3<=x && x<=node.getWidth(i))
			isBorder2=true;
		if(0<=y&&y<=3)
			isBorder3=true;
		else if(node.getHeight(i)-3<=y && y<=node.getHeight(i)) 
			isBorder4  = true;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		x=e.getX();y=e.getY();
		if((0<=x&& x<=3)||(node.getWidth(i)-3<=x && x<=node.getWidth(i))||(0<=y&&y<=3)||(node.getHeight(i)-3<=y && y<=node.getHeight(i))) 
			k.changeSize();
		else
			k.noticeBorder();
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		k.reset();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		x=e.getX()-x;
		y=e.getY()-y;
		
		if(isBorder1 == true) 
			node.setWidth(i, node.getWidth(i)-x);
		else if(isBorder2 == true) {
			node.setWidth(i, node.getWidth(i)+x);
			node.setX(i, node.getX(i)-x);
		}
		if(isBorder3 == true) {
			node.setHeight(i, node.getHeight(i)-y);
			node.setY(i, node.getY(i)+y);
		}
		else if(isBorder4 == true) 
			node.setHeight(i, node.getHeight(i)+y);
		else {
			node.setX(i, node.getX(i)+x);
			node.setY(i, node.getY(i)+y);}
		attr.showNodeInfo(i);
		pane.setRightComponent(attr.getInfo());
		
		Color temp = node.getColor(i);
		node.setColor(i, Color.WHITE);
		pane.setLeftComponent(new MindMap(node,pane,Pane,attr).getMindMap());
		pane.setDividerLocation(pane.getWidth()-pane.getWidth()/5*2);
		node.setColor(i, temp);
		isBorder1=isBorder2=isBorder3=isBorder4=false;
	}
}