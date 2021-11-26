import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DBFValidator {
    private static final String FILENAME = "C:\\Users\\Rustam\\Desktop\\report_katm_48.xml";

    public static void xml_parser() throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            NodeList list = doc.getElementsByTagName("data");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get staff's attribute
                    //String id = element.getAttribute("id");

                    // get text
                    String firstname = element.getElementsByTagName("pinfl").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("number_passport").item(0).getTextContent();
                    String nickname = element.getElementsByTagName("name").item(0).getTextContent();

                    //NodeList salaryNodeList = element.getElementsByTagName("salary");
                    //String salary = salaryNodeList.item(0).getTextContent();

                    // get salary's attribute
                    //String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

                    //System.out.println("Current Element :" + node.getNodeName());
                    //System.out.println("Staff Id : " + id);
                    System.out.println("First Name : " + firstname);
                    System.out.println("Last Name : " + lastname);
                    System.out.println("Nick Name : " + nickname);
                    System.out.println("list: " + list.getLength());
                    //System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);

                }
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }


    }
}
