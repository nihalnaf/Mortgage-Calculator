import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        float principal = 0;
        float monthlyRate = 0;
        byte years = 0;
        int numberOfPayments = 0;

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextFloat();
            if (principal >= 1000 && principal <= 1000000) {
                break;
            }
            System.out.print("Enter a value between 1000 and 1000000: ");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualRate = scanner.nextFloat();
            if (annualRate >= 1 && annualRate <= 30) {
                monthlyRate = annualRate / PERCENT / MONTHS_IN_YEARS;
                break;
            }
            System.out.print("Enter a value between 1 and 30: ");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEARS;
                break;
            }
            System.out.print("Enter a value between 1 and 30: ");
        }

        double mortgage = principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));


    }
}
