package Stock;

import Database.Model;

public class Stock implements Model {

    //Stock ID, uniquely identifies the
    private int sid;
    //Represents the stock name
    private String symbol;
    private String stockName;
    private double marketValue;

    public Stock(int sid, String symbol, String stockName, double marketValue){
        this.sid = sid;
        this.symbol = symbol;
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
    public void update() {

    }

    @Override
    public void save() {

    }

    @Override
    public String toString() {
        return "Stock{" +
                "sid=" + sid +
                ", symbol='" + symbol + '\'' +
                ", stockName='" + stockName + '\'' +
                ", marketValue=" + marketValue +
                '}';
    }
}
