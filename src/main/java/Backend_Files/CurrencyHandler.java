package Backend_Files;

public class CurrencyHandler {
    private String defaultCurrency;
    private CurrencyStratergy currency;

    public CurrencyHandler(String currency){
        defaultCurrency = Constants.defautCurrency;
        switch (currency){
            case "INR":
                this.currency = new CurrencyRupee();
                break;
            case "USD":
                this.currency = new CurrencyUSD();
                break;
            default:
                this.currency = new CurrencyEuro();
        }
    }

    public double convert(double amt){
        return amt*currency.getRate(defaultCurrency);
    }

//    public double fromDefault(double amt){
//        return amt/rate;
//    }

}
