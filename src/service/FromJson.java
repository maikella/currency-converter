package service;

import model.CurrencyCode;
import com.google.gson.*;
import model.Currency;

import java.util.ArrayList;
import java.util.List;

public class FromJson {
    private final ServiceConsumer serviceConsumer;
    private String response;

    public FromJson() {
        serviceConsumer = new ServiceConsumer();
    }

    public String getCode(String url, String code) {

        response = serviceConsumer.sendGet(url);

        String nameCode = "";

        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();

        String status = jsonObject.get("result").getAsString();

        if (status.equals("success")) {

            JsonArray currencies = jsonObject.get("supported_codes").getAsJsonArray();

            JsonArray elements;
            String codesJson, codeName;
            Currency currency;

            List<Currency> currencyList = new ArrayList<>();
            CurrencyCode currencyCode = new CurrencyCode();

            String codesMyList;


            for (int i = 0; i < currencies.size(); i++) {
                elements = currencies.get(i).getAsJsonArray();
                codesJson = elements.get(0).getAsString();

                for (int j = 0; j < currencyCode.getCodeList().size(); j++) {

                    codesMyList = currencyCode.getCodeList().get(j);

                    if (codesJson.equals(codesMyList)) {
                        codeName = elements.get(1).getAsString();
                        currency = new Currency(codesJson, codeName);
                        currencyList.add(currency);
                    }

                }
            }

            String codeMyList;

            for (Currency value : currencyList) {
                codeMyList = value.getCODE();

                if (codeMyList.equals(code)) {
                    nameCode = value.getNAME();

                }
            }

        }

        return nameCode;
    }

    public void getResultConversion(String url, String fromName, String toName, double amount){

        StringBuilder builder = new StringBuilder();

        response = serviceConsumer.sendGet(url);

        JsonElement resultado = JsonParser.parseString(response).getAsJsonObject().get("conversion_result");

        builder.append(amount)
                .append(" em ")
                .append(fromName)
                .append(" é ")
                .append(resultado)
                .append(" em ")
                .append(toName);

        System.out.println(builder);
    }
}