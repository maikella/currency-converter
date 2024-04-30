package menu;

import service.ConvertCurrencies;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    StringBuilder builder;
    ConvertCurrencies convertCurrencies;
    Scanner scanner;

    public Menu() {
        builder = new StringBuilder();
        convertCurrencies = new ConvertCurrencies();
        scanner = new Scanner(System.in);
    }


    public void menu(){

        builder.append("\n")
                .append("Conversor de moedas")
                .append("\n")
                .append("1 Real Brasileiro > Dolar")
                .append("\n")
                .append("2 Dolar > Real Brasileiro")
                .append("\n")
                .append("3 Euro > Real Brasileiro")
                .append("\n")
                .append("4 Real Brasileiro > Euro")
                .append("\n")
                .append("5 Dolar canadence > Real Brasileiro")
                .append("\n")
                .append("6 Real Brasileiro > Dolar canadence")
                .append("\n")
                .append("7 Sair");

        System.out.println(builder);

        switch (getMenuValue()){
            case 1: convertCurrencies.realToDolar();
                break;
            case 2: convertCurrencies.dolarToReal();
                break;
            case 3: convertCurrencies.euroToReal();
                break;
            case 4: convertCurrencies.realToEuro();
                break;
            case 5: convertCurrencies.dolarCanadenceToReal();
                break;
            case 6: convertCurrencies.realToDolarCanadence();
                break;
            case 7: System.exit(0);
        }
    }

    private int getMenuValue() {
        int choice;
        try {
            choice = scanner.nextInt();
            if(checkMenuValue(choice)){
                throw new IllegalArgumentException("apenas valores de 1 a 7");
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("valor inválido");
        }

        return choice;
    }

    private boolean checkMenuValue(int value){
        if (value >= 1 && value <= 7){
            return false;
        }
        return true;
    }
}