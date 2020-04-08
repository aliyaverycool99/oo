package icmit.oodb.Lab3;


import icmit.oodb.Lab3.domain.Uchet;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class MainLoad {
    public static void main(String[] args) throws JAXBException, ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {
//Считать файл
        Uchet uchet = XMLService.loadUchetFromXML();
        System.out.println(uchet);
//Сортировка
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document document = null;
        builder = builderFactory.newDocumentBuilder();
        document = builder.parse("XML/uchet.xml");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        List<String> PersonnelMale = XMLService.getPersonnelMale(document, xPath);
        Collections.sort(PersonnelMale);
        System.out.println("Мужчины кадровики по алфавиту: "+ PersonnelMale.toString());

//Поиск по критерию
        long prsID = 1;
        List<String> PersonnelID = XMLService.getPersonnelID(document, xPath, prsID);
        System.out.println("Поиск кадровика по ID " + prsID +": "+ PersonnelID.toString());

//Изменение файла
        XMLService.updateElementValue(document, 1);
        document.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("XML/uchet.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML успешно изменен!");

        System.out.println(XMLService.loadUchetFromXML());

    }
}
