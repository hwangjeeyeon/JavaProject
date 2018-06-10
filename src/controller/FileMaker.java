package controller;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.NodeFormat;

public class FileMaker {
   
   public FileMaker(NodeFormat a,String path) throws IOException{
      try
      {
         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
   
         // ��Ʈ ������Ʈ
         Document doc = docBuilder.newDocument();
         Element rootElement = doc.createElement("MindMap");
         doc.appendChild(rootElement);
         for(int i=0;i<a.getNumber();i++) {
            Element Node = doc.createElement("Node");
            Node.setAttribute("Name", a.getName(i));
            rootElement.appendChild(Node);
            Element ParentName = doc.createElement("ParentName");
            ParentName.setAttribute("ParentName",a.getParentName(i));
            Node.appendChild(ParentName);
            Element X = doc.createElement("X");
            X.setAttribute("X",Integer.toString(a.getX(i)));
            Node.appendChild(X);
            Element Y = doc.createElement("Y");
            Y.setAttribute("Y",Integer.toString(a.getY(i)));
            Node.appendChild(Y);
            Element Width = doc.createElement("Width");
            Width.setAttribute("Width",Integer.toString(a.getWidth(i)));
            Node.appendChild(Width);
            Element Height = doc.createElement("Height");
            Height.setAttribute("Height",Integer.toString(a.getHeight(i)));
            Node.appendChild(Height);
            Element Depth = doc.createElement("Depth");
            Depth.setAttribute("Depth",Integer.toString(a.getDepth(i)));
            Node.appendChild(Depth);
            Element Color = doc.createElement("Color");
            Color.setAttribute("Color",colorToString(a.getColor(i)));
            Node.appendChild(Color);
            Element Number = doc.createElement("Number");
            Number.setAttribute("Number", Integer.toString(a.getNumber()));
            Node.appendChild(Number);
                
         }        
         
         // XML ���Ϸ� ����
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
   
         transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         DOMSource source = new DOMSource(doc);
         StreamResult result;
         try {
            File file = new File(path+".xml");
            result = new StreamResult(new FileOutputStream(file));
            transformer.transform(source, result);
            while(!file.exists())
                 file.createNewFile();
            
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         }   

			JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�!");
      }
      catch (ParserConfigurationException pce)
      {
         pce.printStackTrace();
      }
      catch (TransformerException tfe)
      {
         tfe.printStackTrace();
      }
   }
   
   private String colorToString(Color a) {
	     if(a==Color.GRAY || a== Color.gray)
	        return "ȸ��";
	     else if(a==Color.black||a==Color.BLACK)
	        return "������";
	     else if(a==Color.blue || a==Color.BLUE)
	        return "�Ķ���";
	     else if(a==Color.cyan || a==Color.CYAN)
	        return "û�ϻ�";
	     else if(a==Color.DARK_GRAY || a==Color.darkGray)
	        return "���� ȸ��";
	     else if(a==Color.GREEN || a==Color.green)
	        return "�ʷϻ�";
	     else if(a==Color.LIGHT_GRAY || a== Color.lightGray)
	        return "���� ȸ��";
	     else if(a==Color.MAGENTA || a==Color.MAGENTA)
	        return "���ڻ�";
	     else if(a==Color.ORANGE || a==Color.orange)
	        return "��������";
	     else if(a==Color.pink|| a==Color.PINK)
	        return "��ũ��";
	     else if(a==Color.red||a==Color.RED)
	        return "������";
	     else if(a==Color.WHITE||a==Color.white)
	        return "���";
	     else if(a==Color.yellow||a==Color.YELLOW)
	        return "�����";
	     else
	        return "�������� �ʴ� ���Դϴ�";
	   }
}