import java.text.NumberFormat;
import java.util.Scanner;

public class Main {


    public Main() {
    }

    public static void main(String[] args) {
        double principal = readNumber("Principal: ", 1000.0, 1000000.0);
        double annualInterestRate = readNumber("Annual Interest Rate: ", 0.0, 30.0);
        double period = readNumber("Period (years): ", 1.0, 30.0);

        double mortgageRate = calculateMortgage(principal, annualInterestRate, period);
        NumberFormat result = NumberFormat.getCurrencyInstance();
        System.out.println(result.format(mortgageRate));
    }

    public static double calculateMortgage(double principal, double annualInterestRate, double period) {
        final byte MONTHS_YEAR = 12;
        final byte PERCENT = 100;
        double monthlyInterestRate = annualInterestRate / MONTHS_YEAR / PERCENT;
        double payments = period * MONTHS_YEAR;
        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1.0 + monthlyInterestRate, payments)
                / (Math.pow(1.0 + monthlyInterestRate, payments) - 1.0));

        return mortgage;
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }

            System.out.println("Enter a value between " + min + " and " + max );
        }
        return value;
    }
}
