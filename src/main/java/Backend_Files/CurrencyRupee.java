package Backend_Files;

public class CurrencyRupee extends CurrencyHandler{
    @Override
    public void setRate() {
        switch (defaultCurrency){
            case "USD":
                rate = Constants.inr_usdRate;
                break;
            case "EUR":
                rate = Constants.inr_euroRate;
                break;
            default:
                rate = 1;
        }
    }
}
