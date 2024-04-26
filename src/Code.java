import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Code {

    public void getCode(){
        URL url;
        HttpsURLConnection connection;
        try {

            url = new URL("https://v6.exchangerate-api.com/v6/f43ec2f4eff42f0af3f2f521/codes");
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

        connection.setRequestProperty("accept", "application/json");

        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder builder = new StringBuilder();
       String inputLine;
        while (true){
            try {
                if (((inputLine = bufferedReader.readLine()) != null)){
                    builder.append(inputLine);
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("body");
        System.out.println(builder);

        FromJson fromJson = new FromJson();
        fromJson.deserialize(builder.toString());
    }
}
