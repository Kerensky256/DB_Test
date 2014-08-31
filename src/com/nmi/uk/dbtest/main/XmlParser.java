package com.nmi.uk.dbtest.main;

import com.sun.xml.internal.ws.developer.ValidationErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Darren on 25/08/2014.
 */
public class XmlParser {

    String filename;

    public XmlParser(String filename){
        this.filename = filename;
    }


    public ArrayList<Book> parseXml(){
        try{

            JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
            Library libTest = new Library();
            libTest.setName("TEST LIBRARY");


            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("C:\\Users\\Darren\\Documents\\projects\\DB_Test\\resources\\bethesda-library.xsd"));

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            try {
                File XMLfile = new File("C:\\Users\\Darren\\Documents\\projects\\DB_Test\\resources\\bethesda-library.xml");
                Library bangor = (Library) jaxbUnmarshaller.unmarshal(XMLfile);
                System.out.println("Library name:" + bangor.getName());
                ArrayList<Book> listOfBooks = bangor.getListOfBooks();

                System.out.println("Validating......");
                JAXBSource source = new JAXBSource(jaxbContext, bangor);
                Validator validator = schema.newValidator();
                //validator.validate(source);
                validator.setErrorHandler(new ValidationErrorHandler() {
                    @Override
                    public void warning(SAXParseException exception) throws SAXException {

                    }

                    @Override
                    public void error(SAXParseException exception) throws SAXException {

                    }

                    @Override
                    public void fatalError(SAXParseException exception) throws SAXException {
                        System.out.println("XML file does not conform to schema");
                    }
                });

                int i=0;

                for(Book book:listOfBooks)
                {
                    i++;
                    System.out.println("Book:" + i + " " + book.getTitle() + "," + book.getAuthor());
                }

                return listOfBooks;

            } catch(javax.xml.bind.UnmarshalException e) {
                System.out.println("The XMl file does not contain all of/the correct elements for import");
                e.printStackTrace();
            }

            // validate the xml format before going any further;



        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } //catch (IOException e) {
        // e.printStackTrace();
        //}

        return null;
    }
}
