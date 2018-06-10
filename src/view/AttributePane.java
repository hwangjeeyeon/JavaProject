package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.NoticeAttributeEvent;
import model.NodeFormat;

public class AttributePane{
     
     JPanel panel, panel2;
     JTextField text = new JTextField(10);
     JTextField x = new JTextField(10);
     JTextField y = new JTextField(10);
     JTextField w = new JTextField(10);
     JTextField h = new JTextField(10);
     JTextField color = new JTextField(10);
     NodeFormat node;
     AttributePane temp;
     public AttributePane(NodeFormat a,JSplitPane frame){
      node = a;
      panel = new JPanel();
      panel2 = new JPanel();
    
      JLabel label = new JLabel("Attribute Pane",SwingConstants.CENTER);
      label.setOpaque(true); 
      label.setBackground(Color.blue);
      label.setForeground(Color.white);
      label.setPreferredSize(new Dimension(150,30));
      
      JScrollPane scrollBar = new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      GridLayout grid = new GridLayout(6, 2);
      grid.setHgap(-70);
      grid.setVgap(55);
      
      panel2.setLayout(grid);
      panel2.add(new JLabel("TEXT:"));
      
      text.setEditable(false);
      panel2.add(text); 
      panel2.add(new JLabel("X:"));
      
      panel2.add(x);
      panel2.add(new JLabel("Y:"));
      
      panel2.add(y);
      panel2.add(new JLabel("W:"));
      
      panel2.add(w);
      panel2.add(new JLabel("H:"));
      
      panel2.add(h);
      panel2.add(new JLabel("Color:"));

      panel2.add(color);
            
      JButton change = new JButton("변경");
      change.setSize(200,20);
      change.setBackground(Color.RED);
      change.setPreferredSize(new Dimension(150,30));
      
      panel.setLayout(new BorderLayout());
      panel.add(label, BorderLayout.NORTH);
      panel.add(scrollBar, BorderLayout.CENTER);
      panel.add(change, BorderLayout.SOUTH);
      change.addActionListener(new NoticeAttributeEvent(a, frame, text,x,y,w,h,color));
   }
     
   public JPanel getInfo() {
      return panel;
   }
   
   void getTemp(AttributePane a) {
	   this.temp=a;
   }
   
   public void showNodeInfo(int i) {
      text.setText(node.getName(i));
      x.setText(Integer.toString(node.getX(i)));
      y.setText(Integer.toString(node.getY(i)));
      w.setText(Integer.toString(node.getWidth(i)));
      h.setText(Integer.toString(node.getHeight(i)));
      color.setText(colorToString(node.getColor(i)));
   }
   
   public void reset() {
	   text.setText("");
	   x.setText("");
	   y.setText("");
	   w.setText("");
	   h.setText("");
	   color.setText("");
   }
   
   private String colorToString(Color a) {
     if(a==Color.GRAY || a== Color.gray)
        return "Gray";
     else if(a==Color.black||a==Color.BLACK)
        return "Black";
     else if(a==Color.blue || a==Color.BLUE)
        return "Blue";
     else if(a==Color.cyan || a==Color.CYAN)
        return "Cyan";
     else if(a==Color.DARK_GRAY || a==Color.darkGray)
        return "Dark Gray";
     else if(a==Color.GREEN || a==Color.green)
        return "Green";
     else if(a==Color.LIGHT_GRAY || a== Color.lightGray)
        return "Light Gray";
     else if(a==Color.MAGENTA || a==Color.MAGENTA)
        return "Magenta";
     else if(a==Color.ORANGE || a==Color.orange)
        return "Orange";
     else if(a==Color.pink|| a==Color.PINK)
        return "Pink";
     else if(a==Color.red||a==Color.RED)
        return "Red";
     else if(a==Color.WHITE||a==Color.white)
        return "White";
     else if(a==Color.yellow||a==Color.YELLOW)
        return "Yellow";
     else
        return "지원하지 않는 색입니다";
   }
}