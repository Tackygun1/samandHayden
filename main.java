
import java.util.*;
public class main {
    public static void main(String[] args) {

        stocks NVIDIA = new stocks("NVIDIA",200, 3);
        NVIDIA.populateListOfValues(); /// must be the first thing called
        System.out.println(NVIDIA.getValue());
        NVIDIA.watchPrice();
        System.out.println(NVIDIA.getValue());
        System.out.println(NVIDIA.getListOfValuesString());
        NVIDIA.watchPrice();
        System.out.println(NVIDIA.getValue());
        NVIDIA.watchPrice();


    }
}
