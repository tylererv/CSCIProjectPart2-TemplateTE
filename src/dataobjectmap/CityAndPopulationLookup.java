package dataobjectmap;

public class CityAndPopulationLookup extends GenericDataReaderIntoMap {

    public CityAndPopulationLookup() {
        super("DataFiles/ThirdPartyDataCSVFiles/CityAndPopulation.csv");
    }

    public static void test() {
        //String fileName = "DataFiles/CityAndPopulation.csv";
        CityAndPopulationLookup objLookup;
        objLookup = new CityAndPopulationLookup();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }
}
