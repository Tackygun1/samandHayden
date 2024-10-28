import java.util.HashMap;
import  java.util.Map;
import java.util.List;

public class blackJack {
    private static  Map<String, Integer> createRankMap() {
        Map<String, Integer> map = new HashMap<>();
        // half deck //
        map.put("2H", 2);map.put("2D", 2);
        map.put("3H", 3);map.put("3D", 3);
        map.put("4H", 4);map.put("4D", 4);
        map.put("5H", 5);map.put("5D", 5);
        map.put("6H", 6);map.put("6D", 6);
        map.put("7H", 7);map.put("7D", 7);
        map.put("8H", 8);map.put("8D", 8);
        map.put("9H", 9);map.put("9D", 9);
        map.put("10H", 10);map.put("10D", 10);
        map.put("JH", 10);map.put("JD", 10);
        map.put("QH", 10);map.put("QD", 10);
        map.put("KH", 10);map.put("KD", 10);
        map.put("AH", 11);map.put("AD", 11);
        return map;
    }
    private double betAmount;
    private int playerRankAmount;
    private int dealerRankAmount;
    private Map<String, Integer> playerCards;
    private Map<String, Integer> dealerCards;
    private Map<String, Integer> deck;
    public blackJack(double amount){
        betAmount = amount;
    }
    public void populateDeck(){deck = createRankMap();}
    public Map<String, Integer> getCards(String type){
        if (type.equals("dealerCards"))
            return dealerCards;
        if (type.equals("playerCards"))
            return playerCards;
        else
            return deck;
    }
    public int calculateAmount(Map<String, Integer> cards){
        int amount = 0;
        for (int i : cards.values()) {
            amount += i;
        }
        if (amount > 21){
            if (cards.containsKey("AH")){
                amount -= 10;
            }
            if (cards.containsKey("AD")){
                amount -= 10;
            }

        }
        return amount;
    }
    public String calculateBust(String player){
        if (player.equals("player")){
            playerRankAmount = calculateAmount(playerCards);
            if (playerRankAmount <= 21){
                return "no bust";
            }
        }
        if (player.equals("dealer")){
            dealerRankAmount = calculateAmount(dealerCards);
            if (dealerRankAmount <= 21){
                return "no bust";
            }
        }

        return "bust";
    }




}
