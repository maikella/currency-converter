package url;

import auth.Authentication;

public interface Url {
    String BASE_URL ="https://v6.exchangerate-api.com/v6/"+ Authentication.API_KEY;
    String CONVERSION_URL = "/pair/";
    String CODE_URL = BASE_URL+"/codes/";

}
