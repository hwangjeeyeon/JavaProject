package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ToolTipManager;

import model.NodeFormat;
import model.PaneInfo;
import controller.FileOpenEvent;
import controller.FileSaveEvent;
import controller.HelpEvent;

public class ToolBar{

   NodeFormat node;
   JToolBar toolBar = new JToolBar();
   ToolBar(NodeFormat a,JSplitPane pane,PaneInfo[] panel,AttributePane attr,TextField text) {
      
      node = a;
      ToolTipManager m = ToolTipManager.sharedInstance();
      m.setInitialDelay(0);
      
      JButton new_bt = new JButton("new");
      new_bt.setToolTipText("새로운 파일 생성");
      
      ImageIcon save = new ImageIcon("image/저장.png");
      JButton save_bt = new JButton(save);
      save_bt.setToolTipText("저장");
      
      JButton open_bt = new JButton("open");
      open_bt.setToolTipText("열기");
      
      JButton help_bt = new JButton("help");
      help_bt.setToolTipText("도움말");
      
      JButton exit_bt = new JButton("exit");
      exit_bt.setToolTipText("종료");
      
      FileSaveEvent saver = new FileSaveEvent(node);
      new_bt.addMouseListener(new MakeNew());
      save_bt.addMouseListener(saver);
      open_bt.addActionListener(new FileOpenEvent(node,pane,panel,attr,text));
      help_bt.addMouseListener(new HelpEvent());
      exit_bt.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
      });
      
      toolBar.add(new_bt);
      toolBar.add(save_bt);
      toolBar.add(open_bt);
      toolBar.add(help_bt);
      toolBar.add(exit_bt);
   }
   
   private class MakeNew extends MouseAdapter{
      public void mousePressed(MouseEvent e) {
         new Frame();
      }
   }
   
   JToolBar getToolBar() {
      return toolBar;
   }
}