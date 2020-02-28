import java.lang.Math;



public class Temperature{
    public static enum Scale{C, F};
    public static float temperature;
    public static Scale scale;
    public static float tempC(float temperature){
        float degreesC = Math.round((5*(temperature - 32)/9)*100)/100F;
        return degreesC;
    }   //End of tempC method

    public static float tempF(float temperature){
        float degreesF = Math.round(((9*(temperature)/5) + 32)*100)/100F;
        return degreesF;
    }   //End of tempF method

    public static void tempSet(float t){
        if(scale == Scale.F)
        
    }   //End of tempSet method

    public void scaleSet(){
        scale = Scale.F;


         
    }   //End of scaleSet method

    public void setScaleTemp(float temperature,Scale scale){
        
    }   //End of setScaleTemp method

    public boolean equals(Temperature t){

        return true;
    }   //End of equals method

    public int compareTo(Temperature t){

    }

    


} //    End of Temperature class