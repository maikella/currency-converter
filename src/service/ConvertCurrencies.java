package service;

import url.Url;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertCurrencies {

    private final FromJson fromJson;
    private final String USD_CODE, BRL_CODE, EUR_CODE, CAD_CODE;
    private String fromName, toName;
    private double amount;


    public ConvertCurrencies() {

        fromJson = new FromJson();

        USD_CODE = "USD";
        BRL_CODE = "BRL";
        EUR_CODE = "EUR";
        CAD_CODE = "CAD";
    }


    public void realToDolar(){
        amount = valueForConversion(BRL_CODE, USD_CODE);
        conversion(BRL_CODE, USD_CODE, amount);
    }

    public void dolarToReal(){
        amount = valueForConversion(USD_CODE, BRL_CODE);
        conversion(USD_CODE, BRL_CODE, amount);
    }

    public void euroToReal(){
        amount = valueForConversion(EUR_CODE, BRL_CODE);
        conversion(EUR_CODE, BRL_CODE, amount);
    }
    public void realToEuro(){
        amount = valueForConversion(BRL_CODE, EUR_CODE);
        conversion(BRL_CODE, EUR_CODE, amount);
    }
    public void dolarCanadenceToReal(){
        amount = valueForConversion(CAD_CODE, BRL_CODE);
        conversion(CAD_CODE, BRL_CODE, amount);
    }
    public void realToDolarCanadence(){
        amount = valueForConversion(BRL_CODE, CAD_CODE);
        conversion(BRL_CODE, CAD_CODE, amount);
    }

    private void conversion(String fromCode, String toCode, double amount){

        String urlConverter = Url.BASE_URL + Url.CONVERSION_URL +fromCode+"/"+toCode+"/"+amount;

        fromJson.getResultConversion(urlConverter, fromName, toName, amount);

    }

    private String getCodeName(String code) {

        String url = Url.CODE_URL;

        return  fromJson.getCode(url, code);
    }
    private double valueForConversion(String from, String to){

        fromName = getCodeName(from);
        toName = getCodeName(to);

        Scanner scanner = new Scanner(System.in);
        System.out.println("entre com o valor em " + fromName +" que deseja converter para "+ toName);

        try {
            amount = scanner.nextDouble();
        }catch (InputMismatchException e){
            throw new InputMismatchException("valor inválido");
        }

        return amount;

    }

}