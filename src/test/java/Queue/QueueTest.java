/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import htl.zechner.producerconsumerfiles.Book;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oskar
 */
public class QueueTest {
    


    /**
     * Test of put method, of class Queue.
     */
    @Test
    public void testPut()  {
        try {
            Queue<Book> q = new Queue<>(2);
            q.put(new Book("./files/h.txt"));
            q.put(new Book("./files/test.txt"));
            q.put(new Book("./files/12375.txt"));
        } catch (FullException ex) {
            assertEquals(true, true);
            return;
        }
        assertEquals(false, true);
    }

    /**
     * Test of get method, of class Queue.
     */
    @Test
    public void testGet() throws FullException  {
        Queue<Book> q = new Queue<>(2);
        try {
            q.get();
        } catch (EmptyException ex) {
            assertEquals(true, true);
            return;
        }
         assertEquals(true, false);
    }
    
}
