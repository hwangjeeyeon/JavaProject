package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	private static final long serialVersionUID = -111659266189879540L;
	MenuBar(){
		
		//�޴� ���
		JMenu menu1 = new JMenu("����");
		JMenu menu2 = new JMenu("����");
		JMenu menu3 = new JMenu("ȭ��");
		JMenu menu4 = new JMenu("����");
		JMenu C_menu1 = new JMenu("����ü");
		JMenu C_menu2 = new JMenu("���ڽ�Ÿ��");
		JMenu C_menu3 = new JMenu("����ũ��");
		JMenu M_menu1 = new JMenu("������");
		
		//���� �޴� ���
		JMenuItem fMenu1 = new JMenuItem("������");
		JMenuItem fMenu2 = new JMenuItem("����");
		JMenuItem fMenu3 = new JMenuItem("�ʱ�ȭ");
		JMenuItem fMenu4 = new JMenuItem("����");
		JMenuItem fMenu5 = new JMenuItem("�ٸ� �̸����� ����");

		//����->����ü �޴� ���
		JMenuItem C_menu1_1 = new JMenuItem("����");
		JMenuItem C_menu1_2 = new JMenuItem("�ü�");
		JMenuItem C_menu1_3 = new JMenuItem("����");
		
		//����->���ڽ�Ÿ�� �޴����
		JMenuItem C_menu2_1 = new JMenuItem("�⺻");
		JMenuItem C_menu2_2 = new JMenuItem("����");
		JMenuItem C_menu2_3 = new JMenuItem("����");
		
		//����->����ũ�� �޴����
		JMenuItem C_menu3_1 = new JMenuItem("3");
		JMenuItem C_menu3_2 = new JMenuItem("5");
		JMenuItem C_menu3_3 = new JMenuItem("7");
		JMenuItem C_menu3_4 = new JMenuItem("10");
		JMenuItem C_menu3_5 = new JMenuItem("15");
		JMenuItem C_menu3_6 = new JMenuItem("20");
		JMenuItem C_menu3_7 = new JMenuItem("25");
		JMenuItem C_menu3_8 = new JMenuItem("30");
		
		//ȭ��->������ �޴����
		JMenuItem M_menu1_1 = new JMenuItem("������");
		JMenuItem M_menu1_2 = new JMenuItem("���");
		JMenuItem M_menu1_3 = new JMenuItem("������");
		JMenuItem M_menu1_4 = new JMenuItem("�����");
		JMenuItem M_menu1_5 = new JMenuItem("�ϴû�");
		JMenuItem M_menu1_6 = new JMenuItem("�ʷϻ�");
		JMenuItem M_menu1_7 = new JMenuItem("�Ķ���");
		JMenuItem M_menu1_8 = new JMenuItem("�����");
		
		//���� �޴� ���
		JMenuItem Hmenu1 = new JMenuItem("����");
		JMenuItem Hmenu2 = new JMenuItem("������ ����");
		
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