package controller;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import model.NodeFormat;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.awt.Color;
import java.io.File;


public class FileParser {

   private NodeFormat a;
   FileParser(NodeFormat a,String path) {
	   this.a=a;
      try {

    	 File file = new File(path);
         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
         Document doc = docBuilder.parse(file);
               
         doc.getDocumentElement().normalize();
          
         NodeList nList = doc.getElementsByTagName("Node");
               
         NodeFormat node= new NodeFormat(nList.getLength());
         node.setNumber(nList.getLength());
         for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp); 
           
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element cElement = (Element) nNode;
               node.setName(temp, cElement.getAttribute("Name"));
               Node eElement=cElement.getFirstChild().getNextSibling();
               
               Element kElement = (Element) eElement;
               node.setParentName(temp, kElement.getAttribute("ParentName"));
               eElement=eElement.getNextSibling().getNextSibling();
               
               kElement = (Element)eElement;
               node.setX(temp, Integer.parseInt(kElement.getAttribute("X")));
               eElement=eElement.getNextSibling().getNextSibling();
               
               kElement = (Element)eElement;
               node.setY(temp, Integer.parseInt(kElement.getAttribute("Y")));
               eElement=eElement.getNextSibling().getNextSibling();
               
               kElement = (Element)eElement;
               node.setWidth(temp, Integer.parseInt(kElement.getAttribute("Width")));
               eElement=eElement.getNextSibling().getNextSibling();
               
               kElement = (Element)eElement;
               node.setHeight(temp, Integer.parseInt(kElement.getAttribute("Height")));
               eElement=eElement.getNextSibling().getNextSibling();
               
               kElement = (Element)eElement;
               node.setDepth(temp, Integer.parseInt(kElement.getAttribute("Depth")));
               eElement=eElement.getNextSibling().getNextSibling();
               
               kElement = (Element)eElement;
               node.setColor(temp,stringToColor(kElement.getAttribute("Color")));
               eElement=eElement.getNextSibling().getNextSibling();
               
               kElement = (Element)eElement;
               node.setNumber(Integer.parseInt(kElement.getAttribute("Number")));
               eElement=eElement.getNextSibling().getNextSibling();
              
            }
         }
         a.changeNode(node);
          } catch (Exception e) {
         e.printStackTrace();
          }

 }
   
 public NodeFormat getNode() {
	 return a;
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