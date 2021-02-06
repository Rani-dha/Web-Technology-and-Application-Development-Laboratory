import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  

public class DomParser {
    
    public String[] searchcollege(String search){
		String[] str=new String[5];
	try {   
	File ipfile = new File("\\input.xml");  
	DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();  
	DocumentBuilder db = dbfact.newDocumentBuilder();  
	Document doc = db.parse(ipfile);  
	doc.getDocumentElement().normalize();  
	System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	NodeList nodeList = doc.getElementsByTagName("college");  
	  
	for (int i = 0; i < nodeList.getLength(); i++)   
	{  
			Node node = nodeList.item(i);  
			System.out.println("\nNode Name :" + node.getNodeName());  
			if (node.getNodeType() == Node.ELEMENT_NODE)   
				{  
						Element eElement = (Element) node;
						if(eElement.getAttribute("counselling_code").equals(search)){
							str[0]=eElement.getAttribute("counselling_code ");
							str[1]=eElement.getElementsByTagName("collegeName").item(0).getTextContent();  
							str[2]=eElement.getElementsByTagName("nickname").item(0).getTextContent();  
							str[3]=eElement.getElementsByTagName("clgDistrict").item(0).getTextContent(); 
							return str;
						}
				}  
	}  
	}   
catch (Exception e)   
{  
	e.printStackTrace();  
}  
return null;
}
}
