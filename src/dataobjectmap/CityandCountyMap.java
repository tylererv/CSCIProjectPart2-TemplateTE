package dataobjectmap;

public class CityandCountyMap extends GenericDataReaderIntoMap {

    // Replace below with your .csv
    public CityandCountyMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/uscities.csv");
    }

    public static void test() {
        //String fileName = "DataFiles/CityAndPopulation.csv";
        CityandCountyMap objLookup;
        objLookup = new CityandCountyMap();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }


}
