import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    private static final byte MONTHS_YEAR = 12;
    private static final byte PERCENT = 100;

    public Main() {
    }

    public static void main(String[] args) {

        Scanner principalScanner = new Scanner(System.in);
        String principal = String.valueOf(principalScanner);
        double principalDb = Double.valueOf(readNumber(principal, 1000.0, 1000000.0));

        Scanner annualInterestRateScanner = new Scanner(System.in);
        String annualInterestRate = String.valueOf(annualInterestRateScanner);
        double annualInterestRateDb = Double.valueOf(readNumber(annualInterestRate, 0.0, 30.0));

        Scanner periodScanner = new Scanner(System.in);
        String period = String.valueOf(periodScanner);
        double periodDb = Double.valueOf(readNumber(period, 1.0, 30.0));

        double mortgageRate = calculateMortgage(principalDb, annualInterestRateDb, periodDb);
        NumberFormat result = NumberFormat.getCurrencyInstance();
        System.out.println(result.format(mortgageRate));
    }

    public static double calculateMortgage(double principal, double annualInterestRate, double period) {
        double monthlyInterestRate = annualInterestRate / MONTHS_YEAR / PERCENT;
        double payments = period * MONTHS_YEAR;
        return principal * (monthlyInterestRate * Math.pow(1.0 + monthlyInterestRate, payments) / (Math.pow(1.0 + monthlyInterestRate, payments) - 1.0));
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal (" + min + " - " + max + "): ");
            double value = scanner.nextDouble();
            if (value >= min && value <= max) {
                return value;
            }

            System.out.println("loan must be between " + min + " and " + max + " , enter valid value");
        }
    }
}
