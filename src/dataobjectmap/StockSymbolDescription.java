package dataobjectmap;

public class StockSymbolDescription extends GenericDataReaderIntoMap {

    public StockSymbolDescription() {
        super("DataFiles/ThirdPartyDataCSVFiles/stock_symbols.csv");
    }

    public static void test() {
        //String fileName = "DataFiles/CityAndPopulation.csv";
        StockSymbolDescription objLookup;
        objLookup = new StockSymbolDescription();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }


}
