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
