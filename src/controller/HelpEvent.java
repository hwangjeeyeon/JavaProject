package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpEvent extends MouseAdapter{
	
	public void mousePressed(MouseEvent e) {
		JFrame frame = new JFrame();
		frame.setTitle("Help(도움말)");
		JPanel panel = new JPanel();
		panel.add(new JTextArea("-마인드맵 그리기\n Text Editor Pane에 입력한 후 적용 버튼을 누르기\n-수정\n Text Editor Pane의 내용을 수정한 후 적용 버튼 누르기\n MindMap에서 마우스를 통한 노드 위치 및 크기 조절\n Attribute Pane에서 내용을 수정한 후 변경 버튼 누르기"));
		frame.add(panel);
		frame.setSize(300,200);
		frame.setLocation(400, 200);
		frame.setVisible(true);
	}
	
}
