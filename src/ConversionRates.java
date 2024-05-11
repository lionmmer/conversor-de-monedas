import java.util.Map;

public class ConversionRates {
    private Map<String, Double> rates;

    public ConversionRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}
