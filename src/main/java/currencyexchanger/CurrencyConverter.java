package currencyexchanger;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private final Map<String, Currency> currencyMap = new HashMap<>();

    public CurrencyConverter() {
        currencyMap.put("RUB", new Currency("RUB", 1.0));
        currencyMap.put("EUR", new Currency("EUR", 104.23));
        currencyMap.put("CNY", new Currency("CNY", 13.49));
        currencyMap.put("USD", new Currency("USD", 95.60));
        currencyMap.put("GPB", new Currency("GPB", 124.80));
    }

    public double convert(double amount, String sourceCurrency, String targetCurrency) {
        Currency source = currencyMap.get(sourceCurrency);
        Currency target = currencyMap.get(targetCurrency);
        if (source == null) {
            throw new IllegalArgumentException("Валюта для конвертации введена неверно");
        }
        if(target == null){
            throw new IllegalArgumentException("Валюта в которую вы хотите конвертировать введена неверно ");
        }
        double amountInRub = source.convertToRub(amount);
        return target.convertFromRub(amountInRub);
    }

    public void printAvailableCurrencies() {
        System.out.println("Список доступных валют для обмена:" + currencyMap.keySet());
    }


}



