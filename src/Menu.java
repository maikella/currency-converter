import java.util.Scanner;

public class Menu {

    StringBuilder builder;
    ConvertTo convertTo;
    Scanner scanner;

    public Menu() {
        builder = new StringBuilder();
        convertTo = new ConvertTo();
        scanner = new Scanner(System.in);

    }


    public void menu(){
        builder.append("Conversor de moedas").append("\n")
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
//                convertTo.dolarToReal();

//        convertTo.euroToReal();
        int choice = scanner.nextInt();

        switch (choice){
           case 1: convertTo.realToDolar();
           break;
            case 2: convertTo.dolarToReal();
            break;
            case 3: convertTo.euroToReal();
            break;
            case 4: convertTo.realToEuro();
            break;
            case 5: convertTo.dolarCanadenceToReal();
            break;
            case 6: convertTo.realToDolarCanadence();
            break;
            case 7: System.exit(0);
        }

    }
}
