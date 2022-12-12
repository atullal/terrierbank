package Stock;

import Database.Model;

public class Stock implements Model {

    //Stock ID, uniquely identifies the
    private int sid;
    //Represents the stock name
    private String stockName;
    private double marketValue;

    public Stock(int sid, String stockName, double marketValue){
        this.sid = sid;
        this.stockName = stockName;
        this.marketValue = marketValue;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public void save() {

    }
}
