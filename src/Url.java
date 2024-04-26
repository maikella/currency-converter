public interface Url {
//    String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    String USD = "USD", ANG = "ANG", BRL = "BRL", EUR = "EUR";
    String BASE_URL ="https://v6.exchangerate-api.com/v6/"+Authentication.API_KEY;
    String URL_CONVERSION = "/pair/";

}
