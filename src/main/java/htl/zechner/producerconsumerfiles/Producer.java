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
import javax.swing.JFileChooser;

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
        JFileChooser jf;
        int r;
        while (true) {
            jf = new JFileChooser("./files");
            r = jf.showOpenDialog(null);

            synchronized (queue) {
                try {

                    if (r == JFileChooser.APPROVE_OPTION) {
                        queue.put(new Book(jf.getSelectedFile().getPath()));
                        queue.notifyAll();
                    }

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
