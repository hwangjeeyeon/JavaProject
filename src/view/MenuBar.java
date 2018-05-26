package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	private static final long serialVersionUID = -111659266189879540L;
	MenuBar(){
		
		//메뉴 목록
		JMenu menu1 = new JMenu("파일");
		JMenu menu2 = new JMenu("글자");
		JMenu menu3 = new JMenu("화면");
		JMenu menu4 = new JMenu("도움말");
		JMenu C_menu1 = new JMenu("글자체");
		JMenu C_menu2 = new JMenu("글자스타일");
		JMenu C_menu3 = new JMenu("글자크기");
		JMenu M_menu1 = new JMenu("바탕색");
		
		//파일 메뉴 목록
		JMenuItem fMenu1 = new JMenuItem("새파일");
		JMenuItem fMenu2 = new JMenuItem("저장");
		JMenuItem fMenu3 = new JMenuItem("초기화");
		JMenuItem fMenu4 = new JMenuItem("열기");
		JMenuItem fMenu5 = new JMenuItem("다른 이름으로 저장");

		//글자->글자체 메뉴 목록
		JMenuItem C_menu1_1 = new JMenuItem("굴림");
		JMenuItem C_menu1_2 = new JMenuItem("궁서");
		JMenuItem C_menu1_3 = new JMenuItem("돋움");
		
		//글자->글자스타일 메뉴목록
		JMenuItem C_menu2_1 = new JMenuItem("기본");
		JMenuItem C_menu2_2 = new JMenuItem("굵게");
		JMenuItem C_menu2_3 = new JMenuItem("기울기");
		
		//글자->글자크기 메뉴목록
		JMenuItem C_menu3_1 = new JMenuItem("3");
		JMenuItem C_menu3_2 = new JMenuItem("5");
		JMenuItem C_menu3_3 = new JMenuItem("7");
		JMenuItem C_menu3_4 = new JMenuItem("10");
		JMenuItem C_menu3_5 = new JMenuItem("15");
		JMenuItem C_menu3_6 = new JMenuItem("20");
		JMenuItem C_menu3_7 = new JMenuItem("25");
		JMenuItem C_menu3_8 = new JMenuItem("30");
		
		//화면->바탕색 메뉴목록
		JMenuItem M_menu1_1 = new JMenuItem("검정색");
		JMenuItem M_menu1_2 = new JMenuItem("흰색");
		JMenuItem M_menu1_3 = new JMenuItem("빨간색");
		JMenuItem M_menu1_4 = new JMenuItem("노란색");
		JMenuItem M_menu1_5 = new JMenuItem("하늘색");
		JMenuItem M_menu1_6 = new JMenuItem("초록색");
		JMenuItem M_menu1_7 = new JMenuItem("파란색");
		JMenuItem M_menu1_8 = new JMenuItem("보라색");
		
		//도움말 메뉴 목록
		JMenuItem Hmenu1 = new JMenuItem("도움말");
		JMenuItem Hmenu2 = new JMenuItem("개발자 정보");
		
		menu1.add(fMenu1);menu1.add(fMenu4);menu1.add(fMenu2);
		menu1.add(fMenu5);menu1.add(fMenu3);
		
		menu2.add(C_menu1);
		C_menu1.add(C_menu1_1);C_menu1.add(C_menu1_2);C_menu1.add(C_menu1_3);
		menu2.addSeparator();
		menu2.add(C_menu2);
		C_menu2.add(C_menu2_1);C_menu2.add(C_menu2_2);C_menu2.add(C_menu2_3);
		menu2.addSeparator();
		menu2.add(C_menu3);
		C_menu3.add(C_menu3_1);C_menu3.add(C_menu3_2);C_menu3.add(C_menu3_3);
		C_menu3.add(C_menu3_4);C_menu3.add(C_menu3_5);C_menu3.add(C_menu3_6);
		C_menu3.add(C_menu3_7);C_menu3.add(C_menu3_8);
		
		menu3.add(M_menu1);
		M_menu1.add(M_menu1_1);M_menu1.add(M_menu1_2);M_menu1.add(M_menu1_3);
		M_menu1.add(M_menu1_4);M_menu1.add(M_menu1_5);M_menu1.add(M_menu1_6);
		M_menu1.add(M_menu1_7);M_menu1.add(M_menu1_8);
		
		menu4.add(Hmenu1);
		menu4.addSeparator();
		menu4.add(Hmenu2);
		
		this.add(menu1);this.add(menu2);
		this.add(menu3);this.add(menu4);
		
	}
	
	JMenuBar getMenuBar() {
		return this;
	}
}