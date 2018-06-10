package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import model.PaneInfo;


public class changePanelColor implements ActionListener{
	PaneInfo[] pane;
	  String a;
	  JSplitPane panel;
	  public changePanelColor(PaneInfo[] pane,JSplitPane panel){
		  this.pane=pane;
		  this.panel=panel;
	  }
	  
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem k= (JMenuItem)arg0.getSource();
			a=k.getText();
			pane[1].setColor(stringToColor(a));
			panel.getLeftComponent().setBackground(stringToColor(a));
		}
		
		private Color stringToColor(String a) {
		     if(a.equals("회색"))
		        return Color.gray;
		     else if(a.equals("검정색"))
		        return Color.BLACK;
		     else if(a.equals("파란색"))
		        return Color.blue;
		     else if(a.equals("청록색"))
		        return Color.cyan;
		     else if(a.equals("진한 회색"))
		        return Color.DARK_GRAY;
		     else if(a.equals("초록색"))
		        return Color.GREEN;
		     else if(a.equals("연한 회색"))
		        return Color.LIGHT_GRAY;
		     else if(a.equals("적자색"))
		        return Color.MAGENTA;
		     else if(a.equals("오렌지색"))
		        return Color.ORANGE;
		     else if(a.equals("핑크색"))
		        return Color.pink;
		     else if(a.equals("빨간색"))
		        return Color.red;
		     else if(a.equals("하얀색"))
		        return Color.WHITE;
		     else if(a.equals("노란색"))
		        return Color.yellow;
		     else
		        return null;
		   }
}