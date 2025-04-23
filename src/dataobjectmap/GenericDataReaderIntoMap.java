package dataobjectmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class GenericDataReaderIntoMap {
    public Map<String, String> keyValuePairs;
    public String keyTitle;
    public String valueTitle;
    private Map<String, Integer> keyLineNumbers;
    public long startTime;
    public long endTime;

    public static long getTime() {
        return System.currentTimeMillis();
    }

    public GenericDataReaderIntoMap(String fileName) {
        Map<String, String> testKeyValuePairs = new LinkedHashMap<>();
        keyLineNumbers = new HashMap<>();

        String line;
        int lineno = 0;
        String data[];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                if (lineno == 0) {
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

                        if (!keyLineNumbers.containsKey(keyInput)) {
                            keyLineNumbers.put(keyInput, lineno);
                        }

                        if (testKeyValuePairs.containsKey(keyInput)) {
                            String existingValue = testKeyValuePairs.get(keyInput);
                            testKeyValuePairs.put(keyInput, existingValue + "\n" + lineno + ", " + valueInput);
                        } else {
                            testKeyValuePairs.put(keyInput, lineno + ", " + valueInput);
                        }
                    }
                }
                lineno++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        keyValuePairs = testKeyValuePairs;
    }

    public void keyValueLookup() {
        Map<String, String> ourKeyValuePairs = this.keyValuePairs;
        Scanner symbolscanner = new Scanner(System.in);
        while (true) {
            int counter = 0;
            System.out.print("\nEnter a key (" +
                    this.keyTitle +
                    ") or 'quit' to exit: ");
            String searchKey = symbolscanner.nextLine().trim();

            // Get start Time
            startTime = getTime();

            if (searchKey.equalsIgnoreCase("quit")) {
                break;
            }

            // Separate solo entries and collaborations
            StringBuilder soloValues = new StringBuilder();
            List<Map.Entry<String, String>> collaborations = new ArrayList<>();

            for (Map.Entry<String, String> entry : ourKeyValuePairs.entrySet()) {
                String key = entry.getKey();

                if (key.toLowerCase().contains(searchKey.toLowerCase())) {

                    // Check if this is an exact match (solo) or a collaboration
                    if (key.equalsIgnoreCase(searchKey)) {
                        // Solo artist
                        counter += entry.getValue().split("\n").length;;
                        if (soloValues.isEmpty()) {
                            soloValues.append("Value (").append(this.valueTitle).append("): \n\n");
                        }
                        soloValues.append(entry.getValue());
                    } else {
                        // Collaboration
                        counter += entry.getValue().split("\n").length;
                        collaborations.add(entry);
                    }
                }
            }
            System.out.println("\nFound " + counter + " entries.");

            // Sort collaborations by line number
            collaborations.sort(Comparator.comparingInt(e -> keyLineNumbers.getOrDefault(e.getKey(), Integer.MAX_VALUE)));

            // Display results
            boolean foundAny = false;

            // Display solo entries first
            if (soloValues.length() > 0) {
                System.out.println(soloValues.toString());
                foundAny = true;
            }

            // Display collaborations second
            if (!collaborations.isEmpty()) {
                if (foundAny) {
                    System.out.println("\nCollaborations:");
                } else {
                    System.out.println("Value (" + this.valueTitle + "):");
                    System.out.println("\nCollaborations:");
                }

                for (Map.Entry<String, String> collab : collaborations) {
                    String artistName = collab.getKey();
                    String[] songs = collab.getValue().split("\n");

                    // Process each song individually to format them properly
                    for (int i = 0; i < songs.length; i++) {
                        if (i == 0) {
                            // First song includes the artist name
                            System.out.println(artistName + ": " + songs[i]);
                        } else {
                            // Subsequent songs should also include the artist name
                            System.out.println(artistName + ": " + songs[i]);
                        }
                    }
                }
                foundAny = true;
            }

            if (!foundAny) {
                System.out.println("Key not found.\n");
            }
            System.out.println("\nElapsed Time for Lookup:");
            endTime = getTime();
            System.out.println("Milliseconds: " + (endTime - startTime));
            System.out.printf("Seconds: %.3f%n", (endTime - startTime) / 1000.0);

        }
    }

    public static void test() {
        String fileName = "DataFiles/ThirdPartyDataCSVFiles/TopSongs5000Edited.csv";
        GenericDataReaderIntoMap ourGenericDataReaderIntoMap =
                new GenericDataReaderIntoMap(fileName);
        ourGenericDataReaderIntoMap.keyValueLookup();
        System.out.println("\nEnd\n");
    }

    public static void main(String[] args) {

        test();
    }
}
