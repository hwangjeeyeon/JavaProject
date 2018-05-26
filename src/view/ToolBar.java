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
		new_bt.setToolTipText("货肺款 颇老 积己");
		
		ImageIcon save = new ImageIcon("image/历厘.png");
		JButton save_bt = new JButton(save);
		save_bt.setToolTipText("历厘");
		
		this.add(new_bt);
		this.add(save_bt);
	}
	
	JToolBar getToolBar() {
		return this;
	}
}
