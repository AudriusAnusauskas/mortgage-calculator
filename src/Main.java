import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner principalScanner = new Scanner(System.in);
        double principal = 0;
        while (true) {
            System.out.print("Principal (1000 - 1000000): ");
            principal = principalScanner.nextDouble();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("loan must be between $1000 and $1000000, enter valid value");
        }

        Scanner annualInterestRateScanner = new Scanner(System.in);
        double annualInterestRate = 0;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = annualInterestRateScanner.nextDouble();
            if (annualInterestRate > 0 && annualInterestRate < 30)
                break;
            System.out.println("Annual interest rate must be between 0% and 30%. Enter a va;id value: ");
        }

        Scanner periodScanner = new Scanner(System.in);
        int period = 0;
        while (true) {
            System.out.print("Period (years): ");
            period = periodScanner.nextInt();
            if (period >= 1 && period <= 30)
                break;
            System.out.println("Period must be between 1 and 30 years. Enter a valid period.");
        }
        double monthlyInterestRate = annualInterestRate / 1200;
        int payments = period * 12;

        double mortgageRate = principal * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), payments)) / (Math.pow((1 + monthlyInterestRate), payments) - 1));

        NumberFormat result = NumberFormat.getCurrencyInstance();
        System.out.println(result.format(mortgageRate));
   }
}