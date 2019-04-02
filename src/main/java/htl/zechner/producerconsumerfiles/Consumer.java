/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.producerconsumerfiles;

import Queue.EmptyException;
import Queue.Queue;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oskar
 */
public class Consumer extends Thread {

    private Queue<Book> queue;
    private HashMap<String, Integer> map;

    public Consumer(Queue<Book> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Book b = null;

            synchronized (queue) {
                try {
                    b = queue.get();
                    queue.notifyAll();
                } catch (EmptyException ex) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " waits");
                        queue.wait();
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    continue;
                }
            }

            try {
                Thread.sleep(1000);

                map = b.countW();
                int count = 0;
                for (String string : map.keySet()) {
                    count = map.get(string);
                    if (count > 1) {
                        System.out.println(string + " " + count);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
