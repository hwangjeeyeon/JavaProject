package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.PaneInfo;

public class ChangeFontSizeEvent implements ActionListener{
	  PaneInfo[] pane;
	  int a;
	  
	  public ChangeFontSizeEvent(PaneInfo[] pane,int a){
		  this.pane = pane;this.a=a;
	  }
	  
	  @Override
	  public void actionPerformed(ActionEvent arg0) {
		  pane[0].setFontSize(a);
		  pane[1].setFontSize(a);
		  pane[2].setFontSize(a);
	  }
}