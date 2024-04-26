package deserialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Currencies {
    private List<Currency> currencyList;


    public Currencies(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public List<Currency> getCurrencyList() {
        return Collections.unmodifiableList(currencyList);
    }

    @Override
    public String toString() {
        return currencyList.toString();
    }
}