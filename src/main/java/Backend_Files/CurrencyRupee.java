package Backend_Files;

public class CurrencyRupee implements CurrencyStratergy{
    @Override
    public double getRate(String defaultCurrency) {
        switch (defaultCurrency){
            case "USD":
                return Constants.inr_usdRate;
            case "EUR":
                return Constants.inr_euroRate;
            default:
                return 1;
        }
    }
}
