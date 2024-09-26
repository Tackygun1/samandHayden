
public class stocks {
    private String name;
    private double value;
    private int type; // used to dictate the stock's price trend
    private double[] listOfvalues;
    public stocks(String name, double price, int type){
        this.name = name;
        this.value = price;
        this.type = type;
    }
    public stocks(String name, double price){
        // will randomly set the stock type if you want it to be a surprise
        this.name = name;
        this.value = price;
        this.type = (int)(Math.random()*2);
    }
    public double getValue(){
        return value;
    }
    public String getName(){
        return name;
    }
    public void changeValue(double newValue){
        this.value = newValue;
    }
    public double updateStock(){
        if (type == 1){

        }
        return 0.0;
    }

}
