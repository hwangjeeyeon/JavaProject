package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MindMapPane extends JFrame{
	private JPanel panel;
	MindMapPane() {
		panel = new JPanel();
		JButton jb = new JButton("Mind Map Pane");
		//jb.setLayout(null);
		//jb.setSize(300,20);
		jb.setBackground(Color.blue);
		jb.setForeground(Color.white);
		panel.add(jb);
	}
	JPanel getMindMap() {
		return panel;
	}
}
