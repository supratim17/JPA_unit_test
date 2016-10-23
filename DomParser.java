package com.mindtree.xml;

import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.mindtree.entity.*;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {
	
	public static ArrayList<Employee> parseData()
	{
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try{
			File input = new File("data.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(input);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element: "+doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("employee");
			for(int i=0;i<nList.getLength();i++)
			{
				Node node = nList.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE)
				{
					Element element = (Element) node;
					String fname=element.getElementsByTagName("firstname").item(0).getTextContent();
					String lname=element.getElementsByTagName("lastname").item(0).getTextContent();
					String desig=element.getElementsByTagName("designation").item(0).getTextContent();
					double salary=Double.valueOf(element.getElementsByTagName("salary").item(0).getTextContent());
					Employee empTemp = new Employee(fname,lname,desig,salary);
					empList.add(empTemp);
				}
			}
			/*for(Employee emp:empList)
			{
				System.out.println(emp.toString());
			}*/
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return empList;
	}
}
