package Stock;

import Account.SecurityAccount;
import User.User;

public class StockPosition {
    //Uniquely identifies this stock
    private int stockPos;

    //stock
    private Stock stock;
    //User
    private User user;
    //Number of shares

    //The security account number of the
    private SecurityAccount secAccnt;
    private int numShares;
    //Stock Value
    private double stockValue;

    private double purchasedValue;

    public StockPosition(int stockPos, Stock s, User u, SecurityAccount acc, int numShares ){

        this.stockPos= stockPos;
        this.stock = s;
        this.user = u;
        this.secAccnt = acc;
        this.numShares = numShares;
        stockValue = numShares * stock.getMarketValue();
        purchasedValue = s.getMarketValue();

    }

    public void setStockValue(double stockValue) {
        this.stockValue = stockValue;
    }

    public double getStockValue() {
        return stockValue;
    }

    public int getStockPos() {
        return stockPos;
    }

    public Stock getStock() {
        return stock;
    }

    public User getUser() {
        return user;
    }

    public SecurityAccount getAcc() {
        return secAccnt;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public int getNumShares() {
        return numShares;
    }
    @Override
    public String toString(){
        return "Stock{" +
                "sid=" + stockPos +
                ", stock='" + stock.getStockName() + '\'' +
                ", User='" + user.getUserName() + '\'' +
                ", Account=" + secAccnt.getAccountNumber() +
                ", NumShares='" + numShares + '\'' +
                '}';
    }
}
