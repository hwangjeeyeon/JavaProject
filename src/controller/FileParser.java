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