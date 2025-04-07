package dataobjectmap;

public class EconomicsPCEMap extends GenericDataReaderIntoMap {

    // Replace below with your .csv
    public EconomicsPCEMap() {
        super("DataFiles/ThirdPartyDataCSVFiles/Economics-PCE.csv");
    }

    public static void test() {
        EconomicsPCEMap objLookup = new EconomicsPCEMap();
        objLookup.keyValueLookup();
    }

    public static void main(String[] args) {
        test();
    }


}
