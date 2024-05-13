package service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ServiceConsumer {

    public String sendGet(String urlQuery){

        HttpsURLConnection connection = getHttpsURLConnection(urlQuery);

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

        connection.disconnect();
        System.out.println("1 "+builder.toString());
        return builder.toString();
    }

    private HttpsURLConnection getHttpsURLConnection(String urlQuery) {

        HttpsURLConnection connection;
        URL url;

        try {
            url = new URL(urlQuery);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

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

        return connection;
    }
}