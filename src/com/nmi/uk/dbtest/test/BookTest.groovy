package com.nmi.uk.dbtest.test
import groovy.util.GroovyTestCase;
import com.nmi.uk.dbtest.main.*
import spock.lang.*

/**
 * Created by Darren on 23/08/2014.
 */
class BookTest extends spock.lang.Specification {

    def "testSetTitle"() {
        given: "A new Book class is created"
        def Book testBook = new Book()

        when: "Call the set method"
        testBook.setTitle("Alien")

        then: "Name matches"
        testBook.title == "Alien"


    }

    def "testGetTitle"() {
        given: "A new Book class is created"
        def Book testBook = new Book()

        when: "set method"
        testBook.setTitle("Alien")

        then: "getting"
        testBook.getTitle() == "Alien"
    }

    void testGetAuthor() {

    }

    void testSetAuthor() {

    }

    void testGetCategory() {

    }

    void testSetCategory() {

    }
}
