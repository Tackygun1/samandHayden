import java.util.HashMap;
import  java.util.Map;

public class Poker
{
     private static  Map<Character, Integer> createRankMap(){
          Map<Character, Integer> map = new HashMap<>();
          map.put('2', 2);
          map.put('3', 3);
          map.put('4', 4);
          map.put('5', 5);
          map.put('6', 6);
          map.put('7', 7);
          map.put('8', 8);
          map.put('9', 9);
          map.put('T', 10);
          map.put('J', 11);
          map.put('Q', 12);
          map.put('K', 13);
          map.put('A', 14);
          return map;
     }

     public static void main(String[] args){
          System.out.println(createRankMap());
     }


}
