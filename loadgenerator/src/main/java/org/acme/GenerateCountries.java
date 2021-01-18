package org.acme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateCountries {

    private static Map<Integer, String> countries = null;

    public GenerateCountries(String countriesFile) throws IOException {
        countries = Collections.unmodifiableMap(new Reader().getMapFromFile(countriesFile));
    }

    public String getCountry() {
        return countries.get(new Random().nextInt(countries.size()));
    }

}
