package dataobjectmap;

public class ArtistandSongMap extends GenericDataReaderIntoMap {

    // Replace below with your .csv
    public ArtistandSongMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/TopSongs5000Edited.csv");
    }

    public static void test() {
        ArtistandSongMap objLookup = new ArtistandSongMap();
        objLookup.keyValueLookup();
    }
    //testing Branch

    public static void main(String[] args) {
        test();
    }


}
