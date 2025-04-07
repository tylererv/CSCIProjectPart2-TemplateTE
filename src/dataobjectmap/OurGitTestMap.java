package dataobjectmap;

public class OurGitTestMap extends GenericDataReaderIntoMap {

    // Replace below with your .csv
    public OurGitTestMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/CityAndPopulation.csv");
    }

    public static void test() {
        OurGitTestMap objLookup = new OurGitTestMap();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }


}
