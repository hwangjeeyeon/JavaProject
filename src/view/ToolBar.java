package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ToolTipManager;

public class ToolBar extends JToolBar{
	
	ToolBar() {
		//tb.setFloatable(false);
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		
		JButton new_bt = new JButton("new");
		new_bt.setToolTipText("���ο� ���� ����");
		
		ImageIcon save = new ImageIcon("image/����.png");
		JButton save_bt = new JButton(save);
		save_bt.setToolTipText("����");
		
		this.add(new_bt);
		this.add(save_bt);
	}
	
	JToolBar getToolBar() {
		return this;
	}
}
