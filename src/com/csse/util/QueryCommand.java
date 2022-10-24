package com.csse.util;

import javax.xml.transform.TransformerFactoryConfigurationError;

import java.io.File;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;

/*
* Use to perform query connection
*
* @throws  SAXException
* 				-Encapsulate a general SAX error or warning
* @throws IOException
* 				-Exception produced by failed or interrupted I/O operations
*
* @throws ParserConfigurationException
* 				-Indicate a serious configuration error
*
*/

public class QueryCommand extends Configuration {
	

	public static String query(String id) throws TransformerFactoryConfigurationError,Exception {
		
		 NodeList _nodeList;
		 Element _element= null;
		
			
		_nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(ApplicationConstants.QueryCommand.EMPLOYEE_QUERY_PATH))
				.getElementsByTagName(ApplicationConstants.QueryCommand.TAG_NAME);
		
		for (int x = 0; x < _nodeList.getLength(); x++) {
			
			_element = (Element) _nodeList.item(x);
			
			if (_element.getAttribute(ApplicationConstants.QueryCommand.ATTRIBUTETAG).equals(id))
				break;
		}
		return _element.getTextContent().trim();
	}

}
