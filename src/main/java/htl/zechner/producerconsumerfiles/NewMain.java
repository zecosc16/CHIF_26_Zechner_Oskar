/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.producerconsumerfiles;

import Queue.Queue;

/**
 *
 * @author oskar
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Book> b = new Queue<>(3);
        Producer p = new Producer(b);
        Consumer c1 = new Consumer(b);
        Consumer c2 = new Consumer(b);
        c1.setName("c1");
        c2.setName("c2");
        p.start();
        c1.start();
        c2.start();
    }
    
}
