package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import model.NodeFormat;
import model.PaneInfo;
import view.AttributePane;
import view.MindMap;

public class addNewNodeEvent implements ActionListener {
	NodeFormat node;
	JSplitPane leftPane;
	AttributePane attr;
	PaneInfo[] pane;
	public addNewNodeEvent(NodeFormat node, JSplitPane leftPane,PaneInfo[] pane, AttributePane attr){
		this.node=node;
		this.leftPane=leftPane;
		this.attr=attr;
		this.pane=pane;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	    String name = JOptionPane.showInputDialog(null, "노드이름을 입력하세요. 모든 정보를 입력해주세요.");
	    if(name.equals("")) {
	    	JOptionPane.showMessageDialog(null, "정보를 입력하지 않았습니다","경고", JOptionPane.WARNING_MESSAGE);
	    	return ;
	    }
	    String parentName = JOptionPane.showInputDialog(null, "부모노드이름을 입력하세요. 없으면  비워두셔도 됩니다.");
	    int depth = Integer.parseInt(JOptionPane.showInputDialog(null, "몇번째 깊이에 있는 노드인지 입력하세요.(1부터 시작입니다.)"));
	    if(depth==0) {
	    	JOptionPane.showMessageDialog(null, "정보를 입력하지 않았습니다","경고", JOptionPane.WARNING_MESSAGE);
	    	return ;
	    }
	    int x = Integer.parseInt(JOptionPane.showInputDialog(null, "X좌표를 입력하세요."));
	    int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Y좌표를 입력하세요."));
	    int width = Integer.parseInt(JOptionPane.showInputDialog(null, "가로길이를 입력하세요."));
	    int height = Integer.parseInt(JOptionPane.showInputDialog(null, "세로길이를 입력하세요."));
	    Color color = stringToColor(JOptionPane.showInputDialog(null, "노드색을 입력하세요."));

	    node.extendNode(name, parentName, x, y, width, height, depth, color);
	    leftPane.setLeftComponent(new MindMap(node, leftPane,pane, attr).getMindMap());
	    leftPane.setDividerLocation(leftPane.getWidth()-leftPane.getWidth()/5*2);;
	}
	private Color stringToColor(String a) {
	     if(a.equals("회색"))
	        return Color.gray;
	     else if(a.equals("검정색"))
	        return Color.BLACK;
	     else if(a.equals("파란색"))
	        return Color.blue;
	     else if(a.equals("청록색"))
	        return Color.cyan;
	     else if(a.equals("진한 회색"))
	        return Color.DARK_GRAY;
	     else if(a.equals("초록색"))
	        return Color.GREEN;
	     else if(a.equals("연한 회색"))
	        return Color.LIGHT_GRAY;
	     else if(a.equals("적자색"))
	        return Color.MAGENTA;
	     else if(a.equals("오렌지색"))
	        return Color.ORANGE;
	     else if(a.equals("핑크색"))
	        return Color.pink;
	     else if(a.equals("빨간색"))
	        return Color.red;
	     else if(a.equals("하얀색"))
	        return Color.WHITE;
	     else if(a.equals("노란색"))
	        return Color.yellow;
	     else
	        return null;
	   }
}