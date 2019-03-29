/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.producerconsumerfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author oskar
 */
public class Book {
    private  String inputfilename;
    private String text;

    public Book(String inputfilename, String text) {
        this.inputfilename = inputfilename;
        this.text = text;
    }
    
    
    public HashMap<String,Integer> countW() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(inputfilename));
       
        
        bw.close();
    }
}
