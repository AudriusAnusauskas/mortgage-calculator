import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args){
        Scanner aScanner = new Scanner(System.in);
        int a = aScanner.nextInt();
//        double a = 100;
        if(a % 5 == 0 && a % 3 == 0){
            System.out.println("FizzBuzz");
        } else if (a % 3 == 0){
            System.out.println("Buzz");
        } else if (a % 5 == 0) {
            System.out.println("Fizz");
        } else System.out.println(a);
    }
}
