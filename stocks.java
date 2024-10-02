
public class stocks {
    private String name;
    private double value;
    private int type; // used to dictate the stock's price trend
    private double[] listOfvalues;
    private double ROCPerHour;
    private double ROCPerWeek;
    public stocks(String name, double price, int type, double ROCPerHour, double ROCPerWeek){
        this.name = name;
        this.value = price;
        this.type = type;
        this.ROCPerHour = ROCPerHour; //0-1
        this.ROCPerWeek = ROCPerWeek; //0-1
    }
    public stocks(String name, double price){
        // will randomly set the stock type if you want it to be a surprise
        this.name = name;
        this.value = price;
        this.type = (int)(Math.random()*3);
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
        return this.listOfvalues;
    }
    public static double[] addX(int n, double arr[], double x)
    {
        int i;

        // create a new array of size n+1
        double newarr[] = new double[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }
    public void watchPrice(){
        double[] values = this.getListOfValues();


    }

    public double updateStock(){
        double UpVal;
        if (type == 1){

            if (Math.random()*2 < 1) {
                UpVal = this.getValue() + ROCPerHour * .5 - 1.1 *(ROCPerWeek);
            }else{
                UpVal = this.getValue() - ROCPerHour * .5 + .5 *(ROCPerWeek);
            }


        } else if (type == 2){
            // stock update
            if (Math.random()*2 < 1) {
                UpVal = this.getValue() + ROCPerHour * 2 - Math.sqrt(ROCPerWeek);
            }else{
                UpVal = this.getValue() - ROCPerHour * 2 + Math.sqrt(ROCPerWeek);
            }


        } else if (type == 3){

            if (Math.random()*2 < 1) {
                UpVal = this.getValue() + ROCPerHour * 4 - Math.sqrt(ROCPerWeek);
            }else{
                UpVal = this.getValue() - ROCPerHour * 4 + Math.sqrt(ROCPerWeek);
            }

        } else {
            UpVal = this.getValue();
        }
        return UpVal;
    }

}
