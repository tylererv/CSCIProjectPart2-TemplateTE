package dataobjectmap;//package dataobjectmap;

import java.util.Map;
import java.util.TreeMap;

public class TestSongMap {

    public static void main(String[] args) {
        Map<String, String> testKeyValuePairs = new TreeMap<>();
        // Add elements to the map
        testKeyValuePairs.put("Elton John", "#11 Candle in the Wind");
        testKeyValuePairs.put("Irene Cara", "#10 Flashdance");
        testKeyValuePairs.put("Cher", "#15 Believe");
        testKeyValuePairs.put("Elton John", "#521 Goodbye Yellow Brick Road");
        // Now print the map
        testKeyValuePairs.forEach((key, value) -> System.out.print(key + ":" + value + "\n"));
        System.out.println();
    }
}
