



public class TemperatureDriver{
    public static void main(String[] args){
        float test = Temperature.tempSet(33);
        test = Temperature.tempC(test);
        System.out.println(test);
    }
}