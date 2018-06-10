package controller;

import javax.swing.*;
import javax.swing.filechooser.*;

import model.NodeFormat;

import java.awt.event.*;
import java.io.IOException;
	
public class FileSaveEvent extends MouseAdapter{
		
		private JFileChooser chooser;
		NodeFormat node;
		String filePath;
		
		public FileSaveEvent(NodeFormat node) {
			this.node=node;
			chooser = new JFileChooser();
		}
		
		public void mousePressed(MouseEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("xml","xml");
			chooser.setFileFilter(filter);
			int save = chooser.showSaveDialog(null);
			
			if(save != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다","경고", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			filePath = chooser.getSelectedFile().getPath();	
			try {
				new FileMaker(node,filePath);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		public String getFilePath() {
			return filePath;
		}
}