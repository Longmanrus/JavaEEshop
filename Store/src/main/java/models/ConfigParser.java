package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ConfigParser {
	
    public static HashMap<String,String> parceConfig(int id, String filePath ) throws XPathExpressionException, FileNotFoundException {
        HashMap <String, String> map = new HashMap<>();
        var factory = XPathFactory.newInstance();
        var parser = factory.newXPath();
        var query = parser.compile("/Configs/Config[@id="+"'"+id+"'"+"]/*");
        NodeList nodeList = (NodeList)query.evaluate(new InputSource(new FileReader(filePath)), XPathConstants.NODESET);
        for (var i = 0; i<nodeList.getLength(); i++ ) {
            map.put(nodeList.item(i).getNodeName(), nodeList.item(i).getTextContent());
        }
        return map;
    }
    
}
