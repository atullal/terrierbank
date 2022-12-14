package Backend_Files;

public abstract class CurrencyHandler {
    String defaultCurrency;
    double rate;

    CurrencyHandler(){
        defaultCurrency = Constants.defautCurrency;
    }

    public abstract void setRate();
    public double convert(double amt){
        return amt*rate;
    }

//    public double fromDefault(double amt){
//        return amt/rate;
//    }

}
