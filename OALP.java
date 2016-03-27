/*
 * Kyomin Ku
 * UPI: 5521999
 * 02.10.2014
 * Compsci 220 Assignment 3
 * OALP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class OALP {
    private static ArrayList<Integer> hashTable = new ArrayList<Integer>(Collections.nCopies(1000, 0));
    private static int outDegreeNumber;
    private static ArrayList<Integer> intArray;
    private static ArrayList<Integer> finalArray;
    private static String stringKey = "";
    
    static InputStreamReader input = new InputStreamReader (System.in);
    static BufferedReader br = new BufferedReader(input);
        
    private static void execute() throws IOException {
        int arraySize = Integer.parseInt(br.readLine());
        
        while(arraySize != 0) {
            intArray = new ArrayList<Integer>(arraySize);
            finalArray = new ArrayList<Integer>(intArray.size());
            
            for (int rep = 0; rep < arraySize; rep++) {
                String line = br.readLine();
                if (line.trim().equals("")) {
                    intArray.add(0);
                } else {
                    String[] readLine = line.split("\\s+");
                    outDegreeNumber = readLine.length;
                    intArray.add(outDegreeNumber);
                }
            }
            
            while (!intArray.isEmpty()) {
                int biggest = intArray.get(0);
                
                int index = 0;
                for (int j = 1; j < intArray.size(); j++) {
                    if (biggest < intArray.get(j)) {
                        biggest = intArray.get(j);
                        index = j;
                    }
                }
                
                finalArray.add(biggest);
                intArray.remove(index);
            }
            
            for (int i = 0; i < finalArray.size(); i++) {
                stringKey = stringKey + finalArray.get(i);
            }
            
            if ((stringKey.length() % 2 == 0) || (stringKey.length() < 3)) {
                stringKey = stringKey + 0;
            }
            
            int midPoint = stringKey.length() / 2;
            
            char middle1 = stringKey.charAt(midPoint - 1);
            char middle2 = stringKey.charAt(midPoint);
            char middle3 = stringKey.charAt(midPoint + 1);
            
            int middleNumber = Integer.parseInt("" + middle1 + middle2 + middle3);
            
            int squared = middleNumber  * middleNumber;
            String squaredString = "" + squared;
            if ((squaredString.length() % 2 == 0) || (squaredString.length() < 3)) {
                squaredString = squaredString + 0;
            }
            
            if (squaredString.length() < 3) {
                squaredString = squaredString + 0;
            }
            
            midPoint = squaredString.length() / 2;
            
            middle1 = squaredString.charAt(midPoint - 1);
            middle2 = squaredString.charAt(midPoint);
            middle3 = squaredString.charAt(midPoint + 1);
            
            int key = Integer.parseInt("" + middle1 + middle2 + middle3);
            
            if (hashTable.get(key) == 0) {
                hashTable.set(key, 1);
            } else {
                key = (key + 1) % 1000;
                while (hashTable.get(key % 1000) == 1) {
                    key = key + 1;
                }
                
                hashTable.set(key, 1);
            }
            
            arraySize = Integer.parseInt(br.readLine());
        }

        
        for (int i = 0; i < hashTable.size(); i++) {
            System.out.println("" + hashTable.get(i));
        }
    }
 
    
    public static void main(String[] arguments) throws IOException {
        if (arguments.length != 0) {
            throw new RuntimeException("RuntimeException.");
        }
        
        OALP.execute();
    }
    
}
