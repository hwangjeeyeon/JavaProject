package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.PaneInfo;

public class FontStyleEvent implements ActionListener{
	  PaneInfo[] pane;
	  String name;
	  public FontStyleEvent(PaneInfo[] pane){
		  this.pane=pane;
	  }
	  
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem k = (JMenuItem)arg0.getSource();
			name=k.getText();
			pane[0].setFont(name);
			pane[1].setFont(name);
			pane[2].setFont(name);	
		} 
}