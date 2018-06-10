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
		     if(a.equals("ȸ��"))
		        return Color.gray;
		     else if(a.equals("������"))
		        return Color.BLACK;
		     else if(a.equals("�Ķ���"))
		        return Color.blue;
		     else if(a.equals("û�ϻ�"))
		        return Color.cyan;
		     else if(a.equals("���� ȸ��"))
		        return Color.DARK_GRAY;
		     else if(a.equals("�ʷϻ�"))
		        return Color.GREEN;
		     else if(a.equals("���� ȸ��"))
		        return Color.LIGHT_GRAY;
		     else if(a.equals("���ڻ�"))
		        return Color.MAGENTA;
		     else if(a.equals("��������"))
		        return Color.ORANGE;
		     else if(a.equals("��ũ��"))
		        return Color.pink;
		     else if(a.equals("������"))
		        return Color.red;
		     else if(a.equals("�Ͼ��"))
		        return Color.WHITE;
		     else if(a.equals("�����"))
		        return Color.yellow;
		     else
		        return null;
		   }
}