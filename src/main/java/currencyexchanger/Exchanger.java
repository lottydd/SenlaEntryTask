package currencyexchanger;

import java.util.Scanner;

public class Exchanger {
    private final CurrencyConverter currencyConverter;
    private final Scanner scanner;

    public Exchanger() {
        this.currencyConverter = new CurrencyConverter();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        currencyConverter.printAvailableCurrencies();

        String sourceCurrency = getValidCurrency("Введите валюту для обмена: ");
        String targetCurrency = getValidCurrency("Введите валюту для получения: ");
        double currencyAmount = getValidAmount("Введите сумму для конвертации: ");

        double result = currencyConverter.convert(currencyAmount, sourceCurrency, targetCurrency);
        System.out.printf("При конвертации %.2f %s в %s вы получите %.2f%n", currencyAmount, sourceCurrency, targetCurrency, result);

        scanner.close();
    }

    private String getValidCurrency(String prompt) {
        String currency;
        while (true) {
            System.out.print(prompt);
            currency = scanner.next().toUpperCase();
            if (isValidCurrency(currency)) {
                break;
            } else {
                System.out.println("Валюта введена неверно. Пожалуйста, попробуйте снова.");
            }
        }
        return currency;
    }

    private boolean isValidCurrency(String currency) {
        return currency.equals("EUR") || currency.equals("CNY") || currency.equals("USD") ||
                currency.equals("GPB") || currency.equals("RUB");
    }

    private double getValidAmount(String prompt) {
        double amount;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Сумма должна быть положительной. Пожалуйста, попробуйте снова.");
                }
            } else {
                System.out.println("Введите корректное числовое значение для суммы.");
                scanner.next(); 
            }
        }
        return amount;
    }
}
