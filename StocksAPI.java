import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class StocksAPI {

    private String key = "your_api_key_here"; // Store your API key securely

    public static String getStock(String name) {
        try {
            // Construct the URL with the API key                                                       // key // 
            String urlString = "https://financialmodelingprep.com/api/v3/stock/list?apikey=" + "hjich22OqLi2XqKZpdMwuL3d8cm0WqyM";
            URL url = new URL(urlString);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
                StringBuilder jsonString = new StringBuilder();
                for (String line; (line = reader.readLine()) != null;) {
                    jsonString.append(line);
                }

                // Parse the JSON string into a List of Maps (dictionaries)
                Gson gson = new Gson();
                List<Map<String, Object>> stockList = gson.fromJson(jsonString.toString(), new TypeToken<List<Map<String, Object>>>(){}.getType());

                // Print out each stock as a dictionary (Map)
                for (Map<String, Object> stock : stockList) {
                    String stockSymbol = (String) stock.get("symbol"); // Access the "symbol" key
                    if (stockSymbol != null && stockSymbol.equalsIgnoreCase(name)) {
                        System.out.println("Stock found: " + stock);
                        return stock.toString();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
public static String getGeneralInfo(String symbol, String action){
    try {
        // Construct the URL with the API key                                                       // key //
        String urlString = "https://financialmodelingprep.com/api/v3/profile/"+symbol+"?apikey=hjich22OqLi2XqKZpdMwuL3d8cm0WqyM";
        URL url = new URL(urlString);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            StringBuilder jsonString = new StringBuilder();
            for (String line; (line = reader.readLine()) != null;) {
                jsonString.append(line);
            }
            // Parse the JSON string into a List of Maps (dictionaries)
            Gson gson = new Gson();
            List<Map<String, Object>> stockList = gson.fromJson(jsonString.toString(), new TypeToken<List<Map<String, Object>>>(){}.getType());

            // Print out each stock as a dictionary (Map)
            for (Map<String, Object> stock : stockList) {
                String stockSymbol = (String) stock.get("symbol"); // Access the "symbol" key
                if (stockSymbol != null && stockSymbol.equalsIgnoreCase(symbol)) {
                    if (action.equals("description")){return (String) stock.get("description");}
                    if (action.equals("sector")){return (String) stock.get("sector");}
                    if (action.equals("exchange")){return (String) stock.get("exchange");}
                    if (action.equals("range")){return (String) stock.get("range");}
                    if (action.equals("changes")){return String.valueOf(stock.get("changes"));}
                    if (action.equals("price")){return String.valueOf(stock.get("price"));}
                    if (action.equals("industry")){return (String) stock.get("industry");}

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

        return "nothing found";
}

    public static void main(String[] args){
        getStock("AIQ");
        System.out.println(getGeneralInfo("AIQ","description"));
        System.out.println("test");
    }


}