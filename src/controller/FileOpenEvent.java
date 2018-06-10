package controller;

import javax.swing.*;
import javax.swing.filechooser.*;

import model.NodeFormat;
import model.PaneInfo;
import view.AttributePane;
import view.MindMap;
import view.TextField;

import java.awt.event.*;
	
public class FileOpenEvent implements ActionListener{
		
		private JFileChooser chooser;
		NodeFormat node;
		String filePath;
		JSplitPane pane;
		PaneInfo[] panel;
		AttributePane attr;
		TextField text;
		
		public FileOpenEvent(NodeFormat a,JSplitPane pane,PaneInfo[] panel,AttributePane attr,TextField text) {
			node = a;
			this.pane=pane;
			this.attr=attr;
			this.panel=panel;
			chooser = new JFileChooser();
			this.text=text;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			FileFilter filter = new FileNameExtensionFilter("XML file", "xml");	 
			 chooser.addChoosableFileFilter(filter);
			 chooser.setFileFilter(filter);

			int open = chooser.showOpenDialog(null);
			if(open != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다","경고", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			filePath = chooser.getSelectedFile().getPath();
			FileParser parser = new FileParser(node,filePath);
			node=parser.getNode();
			pane.setLeftComponent(new MindMap(node, pane,panel, attr).getMindMap());
			pane.setDividerLocation(pane.getWidth()-pane.getWidth()/5*2);;
			text.showText(node);
		}
}