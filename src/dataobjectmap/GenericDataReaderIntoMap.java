package dataobjectmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GenericDataReaderIntoMap {
    public Map<String, String> keyValuePairs;
    public String keyTitle;
    public String valueTitle;

    public GenericDataReaderIntoMap(String fileName) {
        // Step 1: Define the map
        //Map<String, String> testKeyValuePairs = new HashMap<>();
        Map<String, String> testKeyValuePairs = new TreeMap<>();
        // Step 2: read the CSV file data into the map
        String line;
        String csvSplitBy = ",";
        int lineno = 0;
        String data[];
        try (BufferedReader br =
                     new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                if (lineno == 0) {
                    // Save the header
                    //String[] data = line.split(csvSplitBy, -1);
                    data = line.split(",", 2);
                    if (data.length == 2) {
                        this.keyTitle = data[0];
                        this.valueTitle = data[1];
                    }
                }
                else if (lineno > 0) {
                    data = line.split(",", 2);
                    if (data.length == 2) {
                        String keyInput = data[0].trim();
                        String valueInput = data[1].trim();
                        //System.out.println("Insert now");
                        // Resolve issue of multiple values with the same key here
                        testKeyValuePairs.put(keyInput,
                                valueInput);
                    }
                }
                lineno++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        keyValuePairs = testKeyValuePairs;
    }

    // Static method for single call from CSCI211MenuManager
    public void keyValueLookup() {
        // Test - Create the loaded Map object and
        // Interact with user
        Map ourKeyValuePairs = this.keyValuePairs;
        // Test operation with user input
        Scanner symbolscanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a key (" +
                    this.keyTitle +
                    ") or 'quit' to exit: ");
            String key = symbolscanner.nextLine().trim();
            if (key.equalsIgnoreCase("quit")) {
                //symbolscanner.close();
                break;
            }
            String value = (String) ourKeyValuePairs.get(key);
            if (value != null) {
                System.out.println("Value (" +
                        this.valueTitle +
                        "): " + value);
            } else {
                System.out.println("Key not found.");
            }
        }
        System.out.println("Thank you for using the Key-Value Lookup program");
    }

    public static void test() {
        String fileName = "DataFiles/ThirdPartyDataCSVFiles/TopSongs5000Edited.csv";
        GenericDataReaderIntoMap ourGenericDataReaderIntoMap =
                new GenericDataReaderIntoMap(fileName);
        ourGenericDataReaderIntoMap.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }
}