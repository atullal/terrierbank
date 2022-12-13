package Stock;

import Account.SecurityAccount;
import User.User;

import java.util.ArrayList;

public class StockMarket {
    private static StockMarket stockMarket;
    private static int stockNotExists = -1;


    private ArrayList<StockPosition> stockPositions;
    private StockMarket(){
        initializeStockPositions();

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
        double stockValue = stock.getMarketValue() * shares;
        int stockPos = stockPositions.size() + 1;
        StockPosition sp = new StockPosition(stockPos , stock, user , secAccnt , shares);

        //Check if the user has enough amount
        if(secAccnt.getAmount() >= stockValue){
            secAccnt.setAmount(secAccnt.getAmount() - stockValue);
            addStock(sp);
        }
        else{
            System.out.println("Not Enough Money!");
            //Redirect to the buyStock page
        }

        return sp;
    }

    public StockPosition sellStock(int stockPos){
        StockPosition sp = null;
        Double curValue;
        Double profit;
        for(int i = 0; i < stockPositions.size() ; i++){
            if(stockPos == stockPositions.get(i).getStockPos()){
                curValue = stockPositions.get(i).getStock().getMarketValue() * stockPositions.get(i).getNumShares();
                profit = curValue - stockPositions.get(i).getStockValue();
                stockPositions.get(i).getAcc().setAmount(stockPositions.get(i).getAcc().getAmount() + profit);
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

    private void addStock(StockPosition sp) {
        stockPositions.add(sp);
    }

    public ArrayList<StockPosition> returnOpenPosition(User user){
        ArrayList<StockPosition> openPositions = new ArrayList<StockPosition>();
        for(int i = 0; i < stockPositions.size() ; i++){
            if(user.equals(stockPositions.get(i).getUser())){
                openPositions.add(stockPositions.get(i));
            }

        }
        return stockPositions;
    }
}
