/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.producerconsumerfiles;

import Queue.FullException;
import Queue.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oskar
 */
public class Producer extends Thread {

    private Queue<Book> queue;

    public Producer(Queue<Book> queue) {
        this.queue = queue;

    }

    @Override
    public void run() {
        while (true) {
            synchronized(queue){
            try {
                System.out.println("lol");
                queue.put(new Book("./Files/1jcfs10.txt"));
                queue.notifyAll();
                
            } catch (FullException ex) {
                try {
                    System.out.println("Producer waits");
                    queue.wait();
                } catch (InterruptedException ex1) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
    }

}
