package Backend_Files;

public class CurrencyUSD implements CurrencyStratergy{
    @Override
    public double getRate(String defaultCurrency) {
        switch (defaultCurrency){
            case "INR":
                return Constants.usd_inrRate;
            case "EUR":
                return Constants.usd_euroRate;
            default:
                return 1;
        }
    }
}
