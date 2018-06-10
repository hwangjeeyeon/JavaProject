package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import model.NodeFormat;
import model.PaneInfo;
import view.AttributePane;
import view.MindMap;

public class NoticeTextEvent implements ActionListener{
		JTextArea textArea;
		NodeFormat node;
		JSplitPane frame;
		PaneInfo[] pane;
		AttributePane attr;
		
		public NoticeTextEvent(NodeFormat a,JSplitPane frame,JTextArea textArea,PaneInfo[] pane,AttributePane attr){
			this.textArea=textArea;
			node=a;
			this.frame=frame;
			this.pane=pane;
			this.attr=attr;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			NodeFormat newNode = new NodeFormat(textArea.getLineCount());
			newNode.setNumber(textArea.getLineCount());
			for(int i=0;i<textArea.getLineCount();i++) {
				try {
					String temp = textArea.getText(textArea.getLineStartOffset(i), textArea.getLineEndOffset(i)-textArea.getLineStartOffset(i));
					if(temp == null);
					else {
						int count = 0;
						for(int k=0;k<temp.length();k++) {
							if(temp.charAt(k)=='\n');
							else if(temp.charAt(k)=='\t')
								count++;
							
							else {
								newNode.setName(i, temp.substring(k));
								newNode.setColor(i, Color.yellow);
								newNode.setHeight(i, 30);
								newNode.setWidth(i, 80);
								newNode.setDepth(i, count);
								if(count!=0)
									for(int z=i;z>=0;z--) {
										if(newNode.getDepth(z)==count-1) {
											newNode.setParentName(i, newNode.getName(z));
											break;}
									}
								else
									newNode.setParentName(i, null);

								if(count!=0) {
									int number=0;
									for(int z=i-1;z>=0;z--) {
										if(newNode.getName(z)==newNode.getParentName(i)) {
											if(number<4) {
											newNode.setX(i, newNode.getX(z)+100/count*(int)Math.pow(-1, number+1));
											newNode.setY(i, newNode.getY(z)+100/count*(number>=2?1:-1));
											break;}
											else{
												newNode.setX(i, newNode.getX(z)+200/count*(int)Math.pow(-1, number+1));
												newNode.setY(i, newNode.getY(z)+200/count*(number>=6?1:-1));
												break;}
										}
										else if(newNode.getDepth(z)==newNode.getDepth(i)) 
											number++;
									}
								}
								else {
									newNode.setX(i, frame.getWidth()/3);
									newNode.setY(i, frame.getHeight()/2);
								}
								break;
							}	
						}
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
			node.changeNode(newNode);
			frame.setLeftComponent(new MindMap(node, frame,pane, attr).getMindMap());
			frame.setDividerLocation(frame.getWidth()-frame.getWidth()/5*2);
		}
	}