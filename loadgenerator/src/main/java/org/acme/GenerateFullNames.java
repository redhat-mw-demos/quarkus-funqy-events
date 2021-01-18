package org.acme;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


public class GenerateFullNames {

    private static Map<Integer, String> fNames = null;

    private static Map<Integer, String> lNames = null;


    public GenerateFullNames(String fNameFile, String lNameFile) throws IOException{
        fNames = Collections.unmodifiableMap(new Reader().getMapFromFile(fNameFile));
        lNames = Collections.unmodifiableMap(new Reader().getMapFromFile(lNameFile));
    }


    public String getNextLastName() {
        return lNames.get(1);
    }

    public String getNextFirstName() {
        return fNames.get(1);
    }


    public String getNextFullName() {
        return getNextFirstName() + " " + getNextLastName();
    }

}