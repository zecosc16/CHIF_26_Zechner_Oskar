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

/**
 *
 * @author oskar
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book b = new Book("./files/1jcfs10.txt");
          HashMap<String,Integer> map;
        try {
            map = b.countW();
            for (String s : map.keySet()) {
                
                    System.out.println(s+" "+map.get(s));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NewMain1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
