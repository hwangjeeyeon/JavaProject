package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.NoticeTextEvent;
import model.NodeFormat;
import model.PaneInfo;

public class TextField{
	JTextArea textArea = new JTextArea();
	private JPanel panel;
	TextField(NodeFormat a,JSplitPane frame,PaneInfo[] Pane,AttributePane attr){
		panel = new JPanel();
		JButton application = new JButton("Àû¿ë");
		JLabel title = new JLabel("Text Editor pane",SwingConstants.CENTER);
		JScrollPane scrollBar = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		title.setForeground(Color.WHITE);
		title.setFont(new Font("°íµñ", Font.BOLD,15));
		title.setOpaque(true);
		title.setBackground(Color.blue);
		title.setPreferredSize(new Dimension(150,30));
		application.setBackground(Color.RED);
		textArea.setTabSize(3);
		
		panel.setLayout(new BorderLayout());
		textArea.setLineWrap(false);
		panel.setSize(150, 150);
		panel.add(title,BorderLayout.NORTH);
		panel.add(scrollBar,BorderLayout.CENTER);
		panel.add(application,BorderLayout.SOUTH);

		application.addActionListener(new NoticeTextEvent(a,frame,textArea,Pane,attr));
	}
	JPanel getTextArea() {
		return panel;
	}
	public void showText(NodeFormat node) {
		String total="";
		for(int i=0;i<node.getNumber();i++) {
			for(int k=0;k<node.getDepth(i);k++)
				total+="\t";
			total+=node.getName(i);
			total+="\n";
		}
		textArea.setText(total);
	}
}