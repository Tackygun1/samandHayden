import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class stocks {
    private int day = 0;
    private String name;
    private double value;
    private int type; // used to dictate the stock's price trend
    private ArrayList<Double> listOfvalues = new ArrayList<Double>();

    private double ROCPerHour;
    private double ROCPerWeek;
    public stocks(String name, double price, int type){
        this.name = name;
        this.value = price;
        this.type = type;
    }
    public stocks(String name, double price){
        // will randomly set the stock type if you want it to be a surprise
        this.name = name;
        this.value = price;
        this.type = (int)(Math.random()*3);
    }
    public void populateListOfValues(){
        this.listOfvalues.add(value);
        this.listOfvalues.add(value);
        this.listOfvalues.add(value);
        this.listOfvalues.add(value);
        this.listOfvalues.add(value);
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
    public double[] getListOfValues(){
        double[] temp = new double[listOfvalues.size()];

        return Arrays.stream(temp).toArray();
    }
    public String getListOfValuesString(){
        double[] temp = new double[listOfvalues.size()];
        System.out.println(Arrays.stream(temp).toArray().toString());

        return Arrays.stream(temp).toArray().toString();
    }


    public void updateROCs(){
        this.ROCPerHour = this.getListOfValues()[listOfvalues.toArray().length-1] - this.getListOfValues()[listOfvalues.toArray().length -3];
        this.ROCPerWeek = this.getListOfValues()[listOfvalues.toArray().length-1] - this.getListOfValues()[listOfvalues.toArray().length -5];
    }



    public void watchPrice(){
        double[] values = this.getListOfValues();
        for (double i : values){
            listOfvalues.add(i);
        }
    }

    public double updateStock(){
        double UpVal;
        updateROCs();
        if (type == 1){

            if (Math.random()*2 < 1) {
                UpVal = (this.getValue() + ROCPerHour * .1 - 1.1 *(ROCPerWeek)/this.getValue());
            }else{
                UpVal = (this.getValue() - ROCPerHour * .2 + .5 *(ROCPerWeek)/this.getValue());
            }


        } else if (type == 2){
            // stock update
            if (Math.random()*2 < 1) {
                UpVal = (this.getValue() + ROCPerHour * .12 - Math.sqrt(ROCPerWeek)/this.getValue());
            }else{
                UpVal = (this.getValue() - ROCPerHour * .52 + Math.sqrt(ROCPerWeek)/this.getValue());
            }


        } else if (type == 3){

            if (Math.random()*2 < 1) {
                UpVal = (this.getValue() + ROCPerHour * 1.1 - Math.sqrt(ROCPerWeek)/this.getValue());
            }else{
                UpVal = (this.getValue() - ROCPerHour * 1.3 + Math.sqrt(ROCPerWeek)/this.getValue());
            }

        } else {
            UpVal = this.getValue();
        }
        changeValue(UpVal);
        return UpVal;
    }

}
