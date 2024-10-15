package currencyexchanger;

public class Currency {
    private String currencyName;
    private double rateToRUB;

    public Currency(String currencyName, double rateToRUB) {
        this.currencyName = currencyName;
        this.rateToRUB = rateToRUB;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setRateToRUB(double rateToRUB) {
        this.rateToRUB = rateToRUB;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public double getRateToRUB() {
        return rateToRUB;
    }

    public double convertFromRub(double currencyAmount) {
        return currencyAmount / rateToRUB;
    }

    public double convertToRub(double currencyAmount) {
        return currencyAmount * rateToRUB;
    }
}
