package menu;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import deserialize.Code;
import deserialize.Currencies;
import url.Url;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertTo {

    private Currencies currencies;
    private final String USD, BRL, CAD, EUR;
    private final String USD_CODE, BRL_CODE, CAD_CODE, EUR_CODE;

    public ConvertTo() {
        currencies = Code.getCode();

        USD = currencies.getCurrencyList().get(3).getNAME();
        BRL = currencies.getCurrencyList().get(0).getNAME();
        EUR = currencies.getCurrencyList().get(2).getNAME();
        CAD = currencies.getCurrencyList().get(1).getNAME();

        USD_CODE = currencies.getCurrencyList().get(3).getCODE();
        BRL_CODE = currencies.getCurrencyList().get(0).getCODE();
        EUR_CODE = currencies.getCurrencyList().get(2).getCODE();
        CAD_CODE = currencies.getCurrencyList().get(1).getCODE();
    }

    private HttpsURLConnection connection;
    private URL url;

    public void convertTo(double amount, String from, String to){

        try {
            connection = (HttpsURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }

        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder builder = new StringBuilder();

        String inputLine;

        while(true){
            try {
                if (((inputLine = bufferedReader.readLine()) != null)){
                    builder.append(inputLine);
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        JsonElement resultado = JsonParser.parseString(builder.toString()).getAsJsonObject().get("conversion_result");
        System.out.println(amount+" em "+from+" é "+resultado+" em "+to);


    }

    public void realToDolar(){
        double amount = valueForConversion("entre com o valor em "+ BRL);
        urlConvert(BRL_CODE, USD_CODE, amount);
        convertTo(amount, BRL, USD);

    }


    public void dolarToReal(){
        double amount = valueForConversion("entre com o valor em"+ USD);
        urlConvert(USD_CODE, BRL_CODE, amount);
        convertTo(amount, USD,BRL);

    }

    public double valueForConversion(String message){
        double amount;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

            try {
                amount = scanner.nextDouble();
            }catch (InputMismatchException e){
                throw new InputMismatchException("valor inválido");
            }

        return amount;

    }
    public void euroToReal(){
        double amount = valueForConversion("entre com o valor em "+ EUR);
        urlConvert(EUR_CODE, BRL_CODE, amount);
        convertTo(amount, EUR,BRL);

    }
    public void realToEuro(){
        double amount = valueForConversion("entre com o valor em "+ BRL);
        urlConvert(BRL_CODE, EUR_CODE, amount);
        convertTo(amount, BRL, EUR);

    }
    public void dolarCanadenceToReal(){
        double amount = valueForConversion("entre com o valor em "+ CAD);
        urlConvert(CAD_CODE, BRL_CODE, amount);
        convertTo(amount, CAD,BRL);

    }
    public void realToDolarCanadence(){

        double amount = valueForConversion("entre com o valor em "+BRL);
        urlConvert(BRL_CODE, CAD_CODE, amount);
        convertTo(amount, BRL, CAD);
    }

    private void urlConvert(String fromCode, String toCode, double amount){
        try {
            url = new URL(Url.BASE_URL + Url.URL_CONVERSION +fromCode+"/"+toCode+"/"+amount);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}