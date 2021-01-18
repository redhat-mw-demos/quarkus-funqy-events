package org.acme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Reader {


    public Map<Integer, String> getMapFromFile(String fileName) throws IOException {
        Map<Integer, String> temp = new HashMap<>();
        int count = 0;
        try{
            InputStream is = getClass().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for (String line; (line = br.readLine()) != null; ) {
                temp.put(count, line);
                count++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }
}
