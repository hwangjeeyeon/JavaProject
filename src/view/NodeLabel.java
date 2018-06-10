package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import controller.DragEvent;
import model.NodeFormat;
import model.PaneInfo;

public class NodeLabel extends JLabel{
	private static final long serialVersionUID = 1L;

	NodeLabel(){
		super("Mind Map Pane",SwingConstants.CENTER);
		this.setPreferredSize(new Dimension(150,30));
		this.setFont(new Font("°íµñ", Font.BOLD,15));
		this.setOpaque(true);
		this.setForeground(Color.white);
		this.setBackground(Color.blue);
		this.setLocation(200, 0);
	}
	
	public NodeLabel(NodeFormat a,AttributePane frame,PaneInfo[] Pane,int i,JSplitPane pane){
		super(a.getName(i),SwingConstants.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setPreferredSize(new Dimension(a.getWidth(i),a.getHeight(i)));
		this.setMinimumSize(new Dimension(30,15));
		this.setMaximumSize(new Dimension(150,100));
		this.setFont(new Font(Pane[1].getFont(), Font.BOLD,Pane[1].getFontSize()));
		this.setOpaque(true);
		this.setBackground(a.getColor(i));
		this.setForeground(Pane[1].getfontColor());
		this.addMouseListener(new DragEvent(a,frame,pane,Pane,i,this));
	}
	
	public void reColor(Color a) {
		this.setBackground(a);
		this.repaint();
	}
	
	public void noticeBorder() {
		this.setBorder(BorderFactory.createLineBorder(Color.red));
	}
	
	JLabel getLabel() {
		return this;
	}
	
	public void setSizez(int x, int y) {
		this.setPreferredSize(new Dimension(x,y));
		repaint();
	}
	
	public void changeSize() {
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
	}

	public void reset() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

}