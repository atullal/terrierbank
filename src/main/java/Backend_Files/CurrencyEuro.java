package Backend_Files;

public class CurrencyEuro extends CurrencyHandler{
    @Override
    public void setRate() {
        switch (defaultCurrency){
            case "USD":
                rate = Constants.euro_usdRate;
                break;
            case "INR":
                rate = Constants.euro_inrRate;
                break;
            default:
                rate = 1;
        }
    }
}
