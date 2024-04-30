package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CurrencyCode {

    private final List<String> codeList;

    public CurrencyCode() {
        codeList = Arrays.asList("USD","BRL", "EUR", "CAD");
    }

    public List<String> getCodeList() {
        return Collections.unmodifiableList(codeList);
    }

}
