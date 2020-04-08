package icmit.oodb.Lab3;

import icmit.oodb.Lab3.domain.Person;
import icmit.oodb.Lab3.domain.Uchet;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;

public class XMLService {
    public static void saveUchetData(Uchet uchet) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Uchet.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(uchet, new File("XML/uchet.xml"));
    }

    public static Uchet loadUchetFromXML() throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Uchet.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (Uchet) un.unmarshal(new File("XML/uchet.xml"));
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return null;
    }

    //Поиск женщин среди персонала
    public static List<String> getPersonnelMale(Document doc, XPath xPath) throws XPathExpressionException {
        List<String> list = new ArrayList<>();
        XPathExpression xPathExpression = xPath.compile("/Uchet/personnels/personnel/person[gender='male']/surname/text()");
        NodeList nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        for (int o = 0; o < nodes.getLength();o++){
            list.add(nodes.item(o).getNodeValue());
        }
        return list;
    }

    //Поиск по ID
    public static List<String> getPersonnelID (Document doc, XPath xPath, long prsID) throws XPathExpressionException {
        List<String> list = new ArrayList<>();
        XPathExpression xPathExpression = xPath.compile("/Uchet/personnels/personnel[ID= "+ prsID +"]/person/surname/text()");
        NodeList nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        for (int o = 0; o < nodes.getLength();o++){
            list.add(nodes.item(o).getNodeValue());
        }
        return list;
    }

    // изменяем значение существующего элемента
    public static void updateElementValue(Document doc, int prsID) {
        NodeList nodes = doc.getElementsByTagName("applicants");
        Element lang = null;

        for(int i=0; i<nodes.getLength();i++){
            lang = (Element) nodes.item(i);
            Node surname = lang.getElementsByTagName("surname").item(prsID).getFirstChild();
            surname.setNodeValue("Pavel");
            Node genger = lang.getElementsByTagName("gender").item(prsID).getFirstChild();
            genger.setNodeValue(String.valueOf(Person.Gender.male));
        }
    }

    //Поиск по ID
    public static List<String> getPersonnID (Document doc, XPath xPath, long prsID) throws XPathExpressionException {
        List<String> list = new ArrayList<>();
        XPathExpression xPathExpression = xPath.compile("/Uchet/personnels/personnel[ID= "+ prsID +"]/person/surname/text()");
        NodeList nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        for (int o = 0; o < nodes.getLength();o++){
            list.add(nodes.item(o).getNodeValue());
        }
        return list;
    }

}
