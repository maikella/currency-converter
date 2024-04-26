package code;

import java.util.Collections;
import java.util.List;

public final class CurrencyCode {

    private final List<String> codeList;

    public CurrencyCode(List<String> codeList) {
        this.codeList = codeList;
    }

    public List<String> getCodeList() {
        return Collections.unmodifiableList(codeList);
    }

}
