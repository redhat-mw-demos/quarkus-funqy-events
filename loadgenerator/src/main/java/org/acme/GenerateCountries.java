package org.acme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateCountries {

    private static Map<Integer, String> countries = null;

    public GenerateCountries(String countriesFile){
        countries = Collections.unmodifiableMap(getMapFromFile(countriesFile));
    }

    public String getCountry() {
        return countries.get(new Random().nextInt(countries.size()));
    }

    public Map<Integer, String> getMapFromFile(String countriesFile) {
        Map<Integer, String> temp = new HashMap<>();
        int count = 0;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(countriesFile))) {
                for (String line; (line = br.readLine()) != null; ) {
                    temp.put(count, line);
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

}
