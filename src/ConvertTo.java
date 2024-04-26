import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class ConvertTo {
    private static URL url;
    private static HttpsURLConnection connection;
    private static final String USD = "DOLAR AMERICANO";
    private static final String BRL = "REAL BRASILEIRO";
    private static final String EUR = "EURO";
    private static final String CAD = "DOLAR CANADENCE";
    public static void convertTo(double amount, String from, String to){

//        final int AMOUNT = 2000;
//        URL url;
//        HttpsURLConnection connection;
//
//        try {
//            url = new URL(Url.BASE_URL +"USD"+"/"+ code +"/"+amount);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }

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
//        System.out.println("body "+builder.toString());


        JsonElement resultado = JsonParser.parseString(builder.toString()).getAsJsonObject().get("conversion_result");
        System.out.println(amount+" em "+from+" é "+resultado+" em "+to);


    }

    public void realToDolar(){
        double amount = valueForConversion("entre com o valor em real");

        try {
            url = new URL(Url.BASE_URL + Url.URL_CONVERSION +"BRL"+"/"+ "USD" +"/"+amount);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(url);
        System.out.println(System.getenv("APIKEY"));
        convertTo(amount, BRL, USD);

    }


            public void dolarToReal(){
        double amount = valueForConversion("entre com o valor em dolar");

                try {
                    url = new URL(Url.BASE_URL + Url.URL_CONVERSION +"USD"+"/"+ "BRL" +"/"+amount);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                convertTo(amount, USD,BRL);

            }

            public double valueForConversion(String message){
                Scanner scanner = new Scanner(System.in);
                System.out.println(message);
                return scanner.nextDouble();

            }
            public void euroToReal(){
                double amount = valueForConversion("entre com o valor em euro");

                try {
                    url = new URL(Url.BASE_URL + Url.URL_CONVERSION +"EUR"+"/"+ "BRL" +"/"+amount);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                convertTo(amount, EUR,BRL);

            }
            public void realToEuro(){
                double amount = valueForConversion("entre com o valor em real");

                try {
                    url = new URL(Url.BASE_URL + Url.URL_CONVERSION +"BRL"+"/"+ "EUR" +"/"+amount);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                convertTo(amount, BRL, EUR);

            }
            public void dolarCanadenceToReal(){
                double amount = valueForConversion("entre com o valor em dolar canadence");

                try {
                    url = new URL(Url.BASE_URL + Url.URL_CONVERSION +"CAD"+"/"+ "BRL" +"/"+amount);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                convertTo(amount, CAD,BRL);

            }
            public void realToDolarCanadence(){

                double amount = valueForConversion("entre com o valor em real");

                try {
                    url = new URL(Url.BASE_URL + Url.URL_CONVERSION +"BRL"+"/"+ "CAD" +"/"+amount);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                convertTo(amount, BRL, CAD);
            }


}
