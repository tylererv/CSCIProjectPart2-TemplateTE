package dataobjectmap;

public class StockPriceLookupMap extends GenericDataReaderIntoMap {

    // Replace below with your .csv - for constructor
    public StockPriceLookupMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/stock_prices.csv");
    }

    public static void test() {
        StockPriceLookupMap objLookup = new StockPriceLookupMap();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }


}
