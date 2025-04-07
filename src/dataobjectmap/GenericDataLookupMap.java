package dataobjectmap;

public class GenericDataLookupMap extends GenericDataReaderIntoMap {

    // Replace below with your .csv
    public GenericDataLookupMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/stock_prices.csv");
    }

    public static void test() {
        GenericDataLookupMap objLookup = new GenericDataLookupMap();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }


}
