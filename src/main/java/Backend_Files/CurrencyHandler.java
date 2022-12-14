package Backend_Files;

public abstract class CurrencyHandler {
    String defaultCurrency;
    double rate;

    CurrencyHandler(){
        defaultCurrency = Constants.defautCurrency;
    }

    public abstract void setRate();
    public double toUSD(double amt){
        return amt*rate;
    }

    public double fromUSD(double amt){
        return amt/rate;
    }

}
