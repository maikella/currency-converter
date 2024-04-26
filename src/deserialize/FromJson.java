package deserialize;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import code.CurrencyCode;

public class FromJson {
    private Gson gson;
    private List<Currency> currencyList;

    public FromJson() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        currencyList = new ArrayList<>();
    }


    public Currencies deserialize(String json){
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String status = jsonObject.get("result").getAsString();

        if(status.equals("success")){
            JsonArray currencies = jsonObject.get("supported_codes").getAsJsonArray();

            JsonArray elements;
            String code, name;
            Currency currency;

            CurrencyCode codeList = getListCode();

            for (int i = 0; i < currencies.size() ; i++) {
                elements = currencies.get(i).getAsJsonArray();
                code = elements.get(0).getAsString();
                for (int j = 0; j < codeList.getCodeList().size() ; j++) {
                    if(code.equals(codeList.getCodeList().get(j))) {
                        name = elements.get(1).getAsString();
                        currency = new Currency(code, name);
                        currencyList.add(currency);
                    }

                }
            }
        }
        return new Currencies(currencyList);

    }

    private CurrencyCode getListCode(){
       return new CurrencyCode(Arrays.asList("USD","BRL", "EUR", "CAD"));
    }
}
