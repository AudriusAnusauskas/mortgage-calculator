import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner principalScanner = new Scanner(System.in);
        System.out.print("Principal: ");
        String principal = principalScanner.next();
        Scanner annualInterestRateScanner = new Scanner(System.in);
        System.out.print("Annual Interest Rate: ");
        String annualInterestRate = annualInterestRateScanner.next();
        Scanner periodScanner = new Scanner(System.in);
        System.out.print("Period (years): ");
        String period = periodScanner.next();

        double monthlyInterestRate = Double.parseDouble(annualInterestRate)/1200;
        double principalDouble = Double.parseDouble(principal);
        double periodDouble = Double.parseDouble(period) * 12;

        ;

        double mortgageRate = principalDouble * ((monthlyInterestRate * Math.pow((1+monthlyInterestRate),periodDouble))/(Math.pow((1+monthlyInterestRate),periodDouble) - 1));

        NumberFormat result = NumberFormat.getCurrencyInstance();
        System.out.println(result.format(mortgageRate));


    }
}