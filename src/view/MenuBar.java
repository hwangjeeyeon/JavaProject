package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import model.NodeFormat;
import model.PaneInfo;
import controller.ChangeFontSizeEvent;
import controller.FileOpenEvent;
import controller.FileSaveEvent;
import controller.FontStyleEvent;
import controller.HelpEvent;
import controller.addNewNodeEvent;
import controller.changePanelColor;

public class MenuBar{
   JMenuBar menubar = new JMenuBar();
   PaneInfo[] pane;
   NodeFormat node;
   JSplitPane leftPane;
   AttributePane attr;
   TextField textfield;
   MenuBar(NodeFormat a,PaneInfo[] Pane,JSplitPane leftPane,AttributePane attr,TextField text){
	   this.node = a;
	   this.leftPane=leftPane;
	   pane = Pane;
	   textfield=text;
	   this.attr=attr;
	   
      //�޴� ���
      JMenu menu1 = new JMenu("����");
      JMenu menu2 = new JMenu("����");
      JMenu menu3 = new JMenu("ȭ��");
      JMenu menu4 = new JMenu("����");
      JMenu C_menu1 = new JMenu("����ü");
      JMenu C_menu3 = new JMenu("����ũ��");
      JMenu M_menu1 = new JMenu("������");
      
      //���� �޴� ���
      JMenuItem fMenu1 = new JMenuItem("������");
      JMenuItem fMenu2 = new JMenuItem("����");
      JMenuItem fMenu3 = new JMenuItem("�ʱ�ȭ");
      JMenuItem fMenu4 = new JMenuItem("����");
      JMenuItem fMenu5 = new JMenuItem("����߰�");

      fMenu1.addMouseListener(new MakeNew());
      fMenu2.addMouseListener(new FileSaveEvent(node));
      fMenu3.addActionListener(new reset());
      fMenu4.addActionListener(new FileOpenEvent(node,leftPane,Pane,attr,text));
      fMenu5.addActionListener(new addNewNodeEvent(node,leftPane,Pane,attr));
     
      
      //����->����ü �޴� ���
      JMenuItem C_menu1_1 = new JMenuItem("���");
      JMenuItem C_menu1_2 = new JMenuItem("����");
      JMenuItem C_menu1_3 = new JMenuItem("�ü�");
      JMenuItem C_menu1_4 = new JMenuItem("����");
      
      C_menu1_1.addActionListener(new FontStyleEvent(pane));
      C_menu1_2.addActionListener(new FontStyleEvent(pane));
      C_menu1_3.addActionListener(new FontStyleEvent(pane));
      C_menu1_4.addActionListener(new FontStyleEvent(pane));
      
      //����->����ũ�� �޴����
      JMenuItem C_menu31[] = new JMenuItem[6];
      for(int i=0;i<6;i++) {
    	  C_menu31[i]= new JMenuItem(Integer.toString(5*i));
    	  C_menu31[i].addActionListener(new ChangeFontSizeEvent(pane,5*i));
      }
      
      //ȭ��->������ �޴����
      JMenuItem M_menu1_1 = new JMenuItem("������");
      JMenuItem M_menu1_2 = new JMenuItem("���");
      JMenuItem M_menu1_3 = new JMenuItem("������");
      JMenuItem M_menu1_4 = new JMenuItem("�����");
      JMenuItem M_menu1_5 = new JMenuItem("ȸ��");
      JMenuItem M_menu1_6 = new JMenuItem("�ʷϻ�");
      JMenuItem M_menu1_7 = new JMenuItem("�Ķ���");
      JMenuItem M_menu1_8 = new JMenuItem("���ڻ�");
      JMenuItem M_menu1_9 = new JMenuItem("û�ϻ�");
      JMenuItem M_menu1_10 = new JMenuItem("���� ȸ��");
      JMenuItem M_menu1_11= new JMenuItem("��������");
      JMenuItem M_menu1_12= new JMenuItem("��ũ��");
      JMenuItem M_menu1_13= new JMenuItem("���� ȸ��");
      
      M_menu1_1.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_2.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_3.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_4.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_5.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_6.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_7.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_8.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_9.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_10.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_11.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_12.addActionListener(new changePanelColor(pane,leftPane));
      M_menu1_13.addActionListener(new changePanelColor(pane,leftPane));
      
      //���� �޴� ���
      JMenuItem Hmenu1 = new JMenuItem("����");
      JMenuItem Hmenu2 = new JMenuItem("������ ����");
      
      Hmenu1.addMouseListener(new HelpEvent());
      Hmenu2.addMouseListener(new DeveloperInfo());
      
      menu1.add(fMenu1);menu1.add(fMenu4);menu1.add(fMenu2);menu1.add(fMenu3);menu1.add(fMenu5);
      
      menu2.add(C_menu1);
      C_menu1.add(C_menu1_1);C_menu1.add(C_menu1_2);C_menu1.add(C_menu1_3);C_menu1.add(C_menu1_4);
      
      menu2.addSeparator();
      
      menu2.add(C_menu3);
      for(int i=0;i<6;i++) 
    	  C_menu3.add(C_menu31[i]);
      
      menu3.add(M_menu1);
      M_menu1.add(M_menu1_1);M_menu1.add(M_menu1_2);M_menu1.add(M_menu1_3);
      M_menu1.add(M_menu1_4);M_menu1.add(M_menu1_5);M_menu1.add(M_menu1_6);
      M_menu1.add(M_menu1_7);M_menu1.add(M_menu1_8);M_menu1.add(M_menu1_9);
      M_menu1.add(M_menu1_10);M_menu1.add(M_menu1_11);M_menu1.add(M_menu1_12);
      M_menu1.add(M_menu1_13);
      
      menu4.add(Hmenu1);
      menu4.addSeparator();
      menu4.add(Hmenu2);

      menubar.add(menu1);menubar.add(menu2);
      menubar.add(menu3);menubar.add(menu4);
      
      
   }
   private class MakeNew extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			new Frame();
		}
	} 
  
   private class DeveloperInfo extends MouseAdapter{
      public void mousePressed(MouseEvent e) {
         JFrame frame = new JFrame();
         frame.setTitle("������ ����");
         JPanel panel = new JPanel();
         panel.add(new JTextArea("���Ǵ� ��ǻ���к� 20172672 ���α� \n���Ǵ� ��ǻ���к� 20172696 Ȳ����"));
         frame.add(panel);
         frame.setSize(250,120);
         frame.setLocation(400, 200);
         frame.setVisible(true);
      }
   }
   private class reset implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		node = new NodeFormat(0);
		AttributePane newA = new AttributePane(node,leftPane);
		
		leftPane.setLeftComponent(new MindMap(node, leftPane,pane, attr).getMindMap());
		leftPane.setDividerLocation(leftPane.getWidth()-leftPane.getWidth()/5*2);
		
		textfield.showText(node);
		newA.reset();
		leftPane.setRightComponent(newA.getInfo());
	}
   }
   
   JMenuBar getMenuBar() {
      return menubar;
   }
}