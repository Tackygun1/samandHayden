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
    private Map<String, Integer> playerCards = new HashMap<>();
    private Map<String, Integer> dealerCards = new HashMap<>();
    private Map<String, Integer> deck;
    public blackJack(double amount){
        betAmount = amount;
    }
    public void populateDeck(){deck = createRankMap();}
    public String toString(){
        String stringDeck = "";
        for (String key : playerCards.keySet()){
            stringDeck = stringDeck +" "+key;
        }
        return stringDeck;
    }
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

    public void giveCard(String action){
        // gives a card to both the dealer and player
        populateDeck();
        System.out.println(this.toString());
        if (action == "both"){
            int i = (int)(Math.random()*26);
            int r = (int)(Math.random()*26);
            int b = 0;
            int e = 0;
            String card1 ="";
            String card2 ="";
            for (String card : deck.keySet()){
                if (e == i){
                  playerCards.put(card, deck.get(card));
                  card1 = card;
                }
                e++;
                if (r == b){
                    dealerCards.put(card, deck.get(card));
                    card2 = card;
                }
                b++;
            }
            deck.remove(card1);
            deck.remove(card2);
        } else if (action == "player"){
            int i = (int)(Math.random()*26);
            int e = 0;
            String card1 ="";
            for (String card : deck.keySet()){
                playerCards.put(card, deck.get(card));
                card1 = card;
            }
            deck.remove(card1);

        }else if (action == "dealer"){
            int i = (int)(Math.random()*26);
            int e = 0;
            String card1 ="";
            for (String card : deck.keySet()){
                dealerCards.put(card, deck.get(card));
                card1 = card;
            }
            deck.remove(card1);

        }


    }

    public static void main(String[] args) {
        blackJack game = new blackJack(100);
        game.giveCard("both");
        game.giveCard("both");
        System.out.println(game.calculateAmount(game.playerCards));


    }




}
