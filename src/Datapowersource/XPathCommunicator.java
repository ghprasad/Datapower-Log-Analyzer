package DatapowerSource;

import java.util.ArrayList;

import javax.xml.xpath.XPathConstants;

import XPATHsource.XPathReader;

public class XPathCommunicator {
	XPathReader reader;
	
	public XPathCommunicator(String xmlFile){
		String x = "C:\\Users\\Akshay\\Desktop\\Sem 3\\Complexity IT services\\error-report.xml";
		reader = new XPathReader(x);
	}
	
	public ArrayList<String> getOutput(Query q){
		
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<Expression> exp = new ArrayList<Expression>();
		
	//	for(Expression e :exp){
			l.add("/LOG/cli-log/Time20100827T190925Z/Message_Type");//+e.getFilterValue()+"='"+e.getUserValue()+"']/Details");
		//	l.add("/LOG/cli-log/Time20100827T190925Z[Identifier='1']/Error_Type");
	//	}
		
		return reader.read(l,XPathConstants.STRING);
		
	}
	
	

}
