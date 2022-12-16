package Stock;

import Account.SecurityAccount;
import User.User;

import java.util.ArrayList;
import java.util.Date;

public class StockMarket {
    private static StockMarket stockMarket;
    private static int stockNotExists = -1;


    private ArrayList<StockPosition> stockPositions;
    private ArrayList<Stock> stocks;
    private StockMarket(){
        initializeStockPositions();
        this.stocks = new ArrayList<>();
        ArrayList<Stock> stockArrayList = StockDatabase.getStocks();
        if(stockArrayList != null) {
            this.stocks = stockArrayList;
        }
    }

    private void initializeStockPositions() {
        stockPositions = new ArrayList<StockPosition>();
    }

    public static StockMarket getInstance(){
        if(stockMarket == null){
            stockMarket = new StockMarket();
        }
        return stockMarket;
    }



    //Buy stocks
    public StockPosition buyStock(Stock stock, User user , SecurityAccount secAccnt, int shares){
        //Get the stock by 
        double stockValue = stock.getMarketValue() * shares;
        int stockPos = stockPositions.size() + 1;
        Date date = new Date();
        StockPosition sp = new StockPosition(stockPos , stock, user , secAccnt ,stock.getMarketValue(), shares, date);

        //Check if the user has enough amount
        if(secAccnt.getAmount() >= stockValue){
            secAccnt.setBal(secAccnt.getAmount() - stockValue);
            addStock(sp);
        }
        else{
            System.out.println("Not Enough Money!");
            //Redirect to the buyStock page
        }

        return sp;
    }

    public StockPosition sellStock(int stockPos, User user , SecurityAccount secAccnt ){
        StockPosition sp = null;
        Double curValue;
        Double profit;
        for(int i = 0; i < stockPositions.size() ; i++){
            if(stockPos == stockPositions.get(i).getStockPos()){
                curValue = stockPositions.get(i).getStock().getMarketValue() * stockPositions.get(i).getNumShares();
                profit = curValue - stockPositions.get(i).getStockValue();
                secAccnt.setBal(stockPositions.get(i).getAcc().getAmount() + curValue);
                sp = stockPositions.get(i);
                stockPositions.remove(i);
                return sp;
            }

            }
            return sp;

    }

    public Double viewProfits(User user){
        double profits = 0;
        double stockProfit;
        for(int i = 0; i < stockPositions.size() ; i++){
            if(user.equals(stockPositions.get(i).getUser())){
                double curValue = stockPositions.get(i).getStock().getMarketValue() * stockPositions.get(i).getNumShares();
                stockProfit = curValue - stockPositions.get(i).getStockValue();
                profits += stockProfit;

            }
        }
        return profits;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    private void addStock(StockPosition sp) {
        stockPositions.add(sp);
    }

    public void listStock(int sid, String name, String symbol, Double value) {
        Stock stock = new Stock(sid, name, symbol, value);
        stock.save();
        this.stocks.add(stock);
    }

    public void listStock(Stock stock) {
        this.stocks.add(stock);
    }

    public ArrayList<StockPosition> returnOpenPosition(User user){
        ArrayList<StockPosition> openPositions = new ArrayList<StockPosition>();
        for(int i = 0; i < stockPositions.size() ; i++){
            if(user.getId() == stockPositions.get(i).getUser().getId() ){
                openPositions.add(stockPositions.get(i));
            }

        }
        return stockPositions;
    }
}
