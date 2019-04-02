/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.producerconsumerfiles;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oskar
 */
public class BookTest {

    public BookTest() {
    }

    /**
     * Test of countW method, of class Book.
     */
    @Test
    public void testCountW() {
        Book b = new Book("./files/test.txt");
        HashMap<String, Integer> test = new HashMap<>();
        test.put("hallo", 2);
        test.put("test", 4);
        test.put("fehler", 1);

        try {
            assertEquals(test, b.countW());
        } catch (IOException ex) {
            Logger.getLogger(BookTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
