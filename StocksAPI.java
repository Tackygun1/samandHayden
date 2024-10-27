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
                    System.out.println(stock);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


    public void printStockList(){
        try {
            URL url = new URL("https://financialmodelingprep.com/api/v3/stock/list?apikey="+key);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
                for (String line; (line = reader.readLine()) != null;) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        getStock("hey");
        System.out.println("test");
    }


}