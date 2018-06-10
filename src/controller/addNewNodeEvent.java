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
	    String name = JOptionPane.showInputDialog(null, "����̸��� �Է��ϼ���. ��� ������ �Է����ּ���.");
	    if(name.equals("")) {
	    	JOptionPane.showMessageDialog(null, "������ �Է����� �ʾҽ��ϴ�","���", JOptionPane.WARNING_MESSAGE);
	    	return ;
	    }
	    String parentName = JOptionPane.showInputDialog(null, "�θ����̸��� �Է��ϼ���. ������  ����μŵ� �˴ϴ�.");
	    int depth = Integer.parseInt(JOptionPane.showInputDialog(null, "���° ���̿� �ִ� ������� �Է��ϼ���.(1���� �����Դϴ�.)"));
	    if(depth==0) {
	    	JOptionPane.showMessageDialog(null, "������ �Է����� �ʾҽ��ϴ�","���", JOptionPane.WARNING_MESSAGE);
	    	return ;
	    }
	    int x = Integer.parseInt(JOptionPane.showInputDialog(null, "X��ǥ�� �Է��ϼ���."));
	    int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Y��ǥ�� �Է��ϼ���."));
	    int width = Integer.parseInt(JOptionPane.showInputDialog(null, "���α��̸� �Է��ϼ���."));
	    int height = Integer.parseInt(JOptionPane.showInputDialog(null, "���α��̸� �Է��ϼ���."));
	    Color color = stringToColor(JOptionPane.showInputDialog(null, "������ �Է��ϼ���."));

	    node.extendNode(name, parentName, x, y, width, height, depth, color);
	    leftPane.setLeftComponent(new MindMap(node, leftPane,pane, attr).getMindMap());
	    leftPane.setDividerLocation(leftPane.getWidth()-leftPane.getWidth()/5*2);;
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