
package RainbowReef.Graphics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author micaellamorales
 */
public class Util {
    
    /**
     *  It takes the path of a file and load its contents to an ArrayList of integers. 
     * 
     * @param path
     * @return the ArrayList
     */
    public static ArrayList loadFile(String path) {
        int num;
        String line;
        BufferedReader reader;
        StringTokenizer tokenizer;
        ArrayList<Integer> file = new ArrayList();
        try {
            reader = new BufferedReader(new FileReader(path));
            if(reader.ready()){
                while((line = reader.readLine()) != null){
                    tokenizer = new StringTokenizer(line);
                    while(tokenizer.hasMoreTokens()){
                        num = Integer.parseInt(tokenizer.nextToken());
                        file.add(num);
                    }
                }
                
            }
            reader.close();
        } catch (IOException e) {
            System.out.print(e);
        }
        return file;
    }
    
}
