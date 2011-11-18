package XPATHsource;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathReader {

	 private String xmlFile;
	 private Document xmlDocument;
	 private XPath xPath;
	 
	 public XPathReader(String xmlFile){
		 this.xmlFile = xmlFile;
		 initObjects();
	 }
	 
	 private void initObjects(){        
	        try {
	            xmlDocument = DocumentBuilderFactory.
				newInstance().newDocumentBuilder().
				parse(xmlFile);            
	            xPath =  XPathFactory.newInstance().
				newXPath();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (SAXException ex) {
	            ex.printStackTrace();
	        } catch (ParserConfigurationException ex) {
	            ex.printStackTrace();
	        }       
	    }
	 
	 public ArrayList<String> read(ArrayList<String> expression, 
				QName returnType){
		    ArrayList<String> l1 = new ArrayList<String>(); 
	        try {
	        	
	        	for(String s : expression)
	        	{
	        		XPathExpression xPathExpression = 
	        			xPath.compile(s);
	        		 l1.add(xPathExpression.evaluate
	        		(xmlDocument, returnType).toString());
	        		 System.out.println(l1.toString());
	        	}
	        	return l1;
	        } catch (XPathExpressionException ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	 
}
