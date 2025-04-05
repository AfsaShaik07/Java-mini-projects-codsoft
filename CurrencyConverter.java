
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------ Currency Converter ------");
        System.out.println("Available Currencies: ");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. INR (Indian Rupee)");

        System.out.print("Enter base currency (USD/EUR/INR): ");
        String baseCurrency = sc.next().toUpperCase();

        System.out.print("Enter target currency (USD/EUR/INR): ");
        String targetCurrency = sc.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        if (convertedAmount == -1) {
            System.out.println("Invalid Currency Selection.");
        } else {
            System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
        }
    }

    public static double convertCurrency(String base, String target, double amount) {
        double rate = 0;

        if (base.equals("USD") && target.equals("INR")) {
            rate = 83.58;
        } else if (base.equals("INR") && target.equals("USD")) {
            rate = 0.012;
        } else if (base.equals("USD") && target.equals("EUR")) {
            rate = 0.93;
        } else if (base.equals("EUR") && target.equals("USD")) {
            rate = 1.07;
        } else if (base.equals("INR") && target.equals("EUR")) {
            rate = 0.011;
        } else if (base.equals("EUR") && target.equals("INR")) {
            rate = 89.25;
        } else if (base.equals(target)) {
            rate = 1;
        } else {
            return -1; // Invalid Currency
        }
        return amount * rate;
    }
}
