import com.google.gson.*;
import netscape.javascript.JSObject;

public class FromJson {
    private Gson gson;
    public FromJson() {
gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
    }

    public void deserialize(String json){
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String status = jsonObject.get("result").getAsString();

        if(status.equals("success")){
            System.out.println("conversion_rates");
            JsonArray jb = jsonObject.get("supported_codes").getAsJsonArray();
            System.out.println(jb);
            JsonArray test = jb.get(0).getAsJsonArray();
            System.out.println(test.get(0));
//            JsonElement conversionRates = jsonArray.get(0).getAsJsonObject().get();
//            System.out.println(conversionRates);
        }

    }
}
