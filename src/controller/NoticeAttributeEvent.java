package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import model.NodeFormat;

public class NoticeAttributeEvent implements ActionListener{
    NodeFormat node;
    JSplitPane frame;
    JTextField text;
    JTextField x,y,w, h,c;
    public NoticeAttributeEvent(NodeFormat a,JSplitPane frame, JTextField text,JTextField x,JTextField y,JTextField w,JTextField h,JTextField c){
	   node=a;
	   this.frame = frame;
	   this.text = text;
	   this.x=x;
	   this.y=y;
	   this.w=w;
	   this.h=h;
	   this.c=c;
    }
   	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 for(int i=0;i<node.getNumber();i++) {
	         if(node.getName(i).equals(text.getText())) {
	            node.setX(i, Integer.parseInt(x.getText()));
	            node.setY(i, Integer.parseInt(y.getText()));
	            node.setWidth(i, Integer.parseInt(w.getText()));
	            node.setHeight(i, Integer.parseInt(h.getText()));
	            node.setColor(i, stringToColor(c.getText()));
	            break;
	         }
	      }
		 frame.getLeftComponent().repaint();
   	}
	
   	private Color stringToColor(String a) {
        if(a.equals("Gray"))
           return Color.GRAY;
        else if(a.equals("Black"))
           return Color.black;
        else if(a.equals("Blue"))
           return Color.blue;
        else if(a.equals("Cyan"))
           return Color.cyan;
        else if(a.equals("Dark Gray"))
           return Color.DARK_GRAY;
        else if(a.equals("Green"))
           return Color.GREEN;
        else if(a.equals("Light Gray"))
           return Color.lightGray;
        else if(a.equals("Magenta"))
           return Color.MAGENTA;
        else if(a.equals("Orange"))
           return Color.ORANGE ;
        else if(a.equals("Pink"))
           return Color.pink;
        else if(a.equals("Red"))
           return Color.red;
        else if(a.equals("White"))
           return Color.WHITE;
        else if(a.equals("Yellow"))
           return Color.yellow;
        else
        	return null;
      }
}