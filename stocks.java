
import java.util.*;

public class stocks {
    private double money = 1000.00;
    private Map<String, Integer> stocksOwned = new HashMap<String, Integer>();
    public stocks(double startingAmount){
        this.money = startingAmount;
    }
    public void giveStock(String name, int Amount){
        if (stocksOwned.containsKey(name)){
            stocksOwned.put(name, stocksOwned.get(name) + Amount);
        }else{
            stocksOwned.put(name, Amount);

        }
    }
    public Set<Map.Entry<String, Integer>> getMap(){
        return stocksOwned.entrySet();
    }
    public boolean subtractMoney(double amount){
        if (money - amount >= 0){
            money -= amount;
            return true;
        }
        return false;
    }
    public void addMoney(double amount){
        money += amount;
    }
    public double getMoney(){
        return money;
    }
    public void setMoney(double money){
        this.money = money;
    }

}
