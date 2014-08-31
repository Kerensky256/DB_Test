package com.nmi.uk.dbtest.main;

/*
import java.util.*;
import javax.ws.rs.core.Application;
import org.eclipse.persise
/**
 * Created by Darren on 27/08/2014.
 */

/*
public class JSONToJPA {
}
*/



import javax.xml.bind.*;
import javax.xml.stream.XMLStreamReader;
//import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Iterator;

import java.io.FileReader;

public class JSONToJPA {

    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();

        //Object obj = parser.parse(new FileReader("C:\\Users\\Darren\\Documents\\projects\\DB_Test\\resources\\bangor-library.json"));

        JAXBContext jc = JAXBContext.newInstance(Library.class);
        JSONObject jsonObj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Darren\\Documents\\projects\\DB_Test\\resources\\bangor-library.json"));

        String name = (String) jsonObj.get("name");
        JSONArray bookList = (JSONArray) jsonObj.get("books");

        System.out.println("Library: " + name);
        Iterator i = bookList.iterator();
        while(i.hasNext()){
            JSONObject innerObj = (JSONObject) i.next();
            System.out.println("title "+ innerObj.get("name") +
                    " author " + innerObj.get("author") + " category " + innerObj.get("category"));

        }



/*
        Configuration config = new Configuration();
        MappedNamespaceConvention con = new MappedNamespaceConvention(config);
        XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(obj, con);


        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Library customer = (Library) unmarshaller.unmarshal(xmlStreamReader);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
*/

    }

}
