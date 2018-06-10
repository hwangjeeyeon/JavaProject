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
	   
      //메뉴 목록
      JMenu menu1 = new JMenu("파일");
      JMenu menu2 = new JMenu("글자");
      JMenu menu3 = new JMenu("화면");
      JMenu menu4 = new JMenu("도움말");
      JMenu C_menu1 = new JMenu("글자체");
      JMenu C_menu3 = new JMenu("글자크기");
      JMenu M_menu1 = new JMenu("바탕색");
      
      //파일 메뉴 목록
      JMenuItem fMenu1 = new JMenuItem("새파일");
      JMenuItem fMenu2 = new JMenuItem("저장");
      JMenuItem fMenu3 = new JMenuItem("초기화");
      JMenuItem fMenu4 = new JMenuItem("열기");
      JMenuItem fMenu5 = new JMenuItem("노드추가");

      fMenu1.addMouseListener(new MakeNew());
      fMenu2.addMouseListener(new FileSaveEvent(node));
      fMenu3.addActionListener(new reset());
      fMenu4.addActionListener(new FileOpenEvent(node,leftPane,Pane,attr,text));
      fMenu5.addActionListener(new addNewNodeEvent(node,leftPane,Pane,attr));
     
      
      //글자->글자체 메뉴 목록
      JMenuItem C_menu1_1 = new JMenuItem("고딕");
      JMenuItem C_menu1_2 = new JMenuItem("굴림");
      JMenuItem C_menu1_3 = new JMenuItem("궁서");
      JMenuItem C_menu1_4 = new JMenuItem("돋움");
      
      C_menu1_1.addActionListener(new FontStyleEvent(pane));
      C_menu1_2.addActionListener(new FontStyleEvent(pane));
      C_menu1_3.addActionListener(new FontStyleEvent(pane));
      C_menu1_4.addActionListener(new FontStyleEvent(pane));
      
      //글자->글자크기 메뉴목록
      JMenuItem C_menu31[] = new JMenuItem[6];
      for(int i=0;i<6;i++) {
    	  C_menu31[i]= new JMenuItem(Integer.toString(5*i));
    	  C_menu31[i].addActionListener(new ChangeFontSizeEvent(pane,5*i));
      }
      
      //화면->바탕색 메뉴목록
      JMenuItem M_menu1_1 = new JMenuItem("검정색");
      JMenuItem M_menu1_2 = new JMenuItem("흰색");
      JMenuItem M_menu1_3 = new JMenuItem("빨간색");
      JMenuItem M_menu1_4 = new JMenuItem("노란색");
      JMenuItem M_menu1_5 = new JMenuItem("회색");
      JMenuItem M_menu1_6 = new JMenuItem("초록색");
      JMenuItem M_menu1_7 = new JMenuItem("파란색");
      JMenuItem M_menu1_8 = new JMenuItem("적자색");
      JMenuItem M_menu1_9 = new JMenuItem("청록색");
      JMenuItem M_menu1_10 = new JMenuItem("연한 회색");
      JMenuItem M_menu1_11= new JMenuItem("오렌지색");
      JMenuItem M_menu1_12= new JMenuItem("핑크색");
      JMenuItem M_menu1_13= new JMenuItem("진한 회색");
      
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
      
      //도움말 메뉴 목록
      JMenuItem Hmenu1 = new JMenuItem("도움말");
      JMenuItem Hmenu2 = new JMenuItem("개발자 정보");
      
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
         frame.setTitle("개발자 정보");
         JPanel panel = new JPanel();
         panel.add(new JTextArea("숭실대 컴퓨터학부 20172672 전민규 \n숭실대 컴퓨터학부 20172696 황지연"));
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