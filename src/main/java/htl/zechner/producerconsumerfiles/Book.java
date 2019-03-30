/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.producerconsumerfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author oskar
 */
public class Book {

    private String inputfilename;

    public Book(String inputfilename) {
        this.inputfilename = inputfilename;
    }

    public HashMap<String, Integer> countW() throws IOException {

        HashMap<String, Integer> m = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(inputfilename));
        String[] w;
        String s;
        while ((s = br.readLine()) != null) {
            w = s.split(" ");
            for (String string : w) {
                if (m.containsKey(string)) {
                    int k = m.get(string);
                    m.put(string, ++k);
                } else {
                    m.put(string, 1);
                }
            }
        }

        br.close();
        
        return m;
    }
}
