package com.nmi.uk.dbtest.main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;



/**
 * Created by Darren on 21/08/2014.
 */
public class StartApp {

    // file name of XML file and path
    File filename = new File("path to file");

    public static void main(String[] args) {
        XmlParser parse = new XmlParser("filename");


        int i=0;
        for(Book book: parse.parseXml()){
            i++;
            System.out.println("Book:" + i + " " + book.getTitle() + "," + book.getAuthor());
        }
    }
}
