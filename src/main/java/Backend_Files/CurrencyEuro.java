package Backend_Files;

public class CurrencyEuro implements CurrencyStratergy{
    @Override
    public double getRate(String defaultCurrency) {
        switch (defaultCurrency){
            case "USD":
                return Constants.euro_usdRate;
            case "INR":
                return Constants.euro_inrRate;
            default:
                return 1;
        }
    }
}
