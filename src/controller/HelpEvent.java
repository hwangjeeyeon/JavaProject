package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpEvent extends MouseAdapter{
	
	public void mousePressed(MouseEvent e) {
		JFrame frame = new JFrame();
		frame.setTitle("Help(����)");
		JPanel panel = new JPanel();
		panel.add(new JTextArea("-���ε�� �׸���\n Text Editor Pane�� �Է��� �� ���� ��ư�� ������\n-����\n Text Editor Pane�� ������ ������ �� ���� ��ư ������\n MindMap���� ���콺�� ���� ��� ��ġ �� ũ�� ����\n Attribute Pane���� ������ ������ �� ���� ��ư ������"));
		frame.add(panel);
		frame.setSize(300,200);
		frame.setLocation(400, 200);
		frame.setVisible(true);
	}
	
}
