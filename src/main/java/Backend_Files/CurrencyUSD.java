package Backend_Files;

public class CurrencyUSD extends CurrencyHandler{
    @Override
    public void setRate() {
        switch (defaultCurrency){
            case "INR":
                rate = Constants.usd_inrRate;
                break;
            case "EUR":
                rate = Constants.usd_euroRate;
                break;
            default:
                rate = 1;
        }
    }
}
