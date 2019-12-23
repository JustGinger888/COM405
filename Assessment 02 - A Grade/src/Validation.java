import java.util.ArrayList;

public class Validation {

    //Validate String Not Implemented
    public boolean ValidateString(String tmp) {
        return true;
    }
    //Validate String Not Implemented


    //VALIDATE Integer by Attempting to Parse it from Its Initial String Input
    public boolean ValidateInteger(String tmp) {
        try {
            Integer.parseInt(tmp);
        } catch (Exception e) {
            System.out.println("Invalid input, numbers only");
            return false;
        }
        if (Integer.parseInt(tmp) > -500 && Integer.parseInt(tmp) < 500) {
            return true;
        }
        else{
            return false;
        }
    }
    //VALIDATE Integer by Attempting to Parse it from Its Initial String Input


    //VALIDATE The Size Of A Storm
    public boolean ValidateStormSize(ArrayList currentStorms){
        if (currentStorms.size() > 20){
            return false;
        }
        return true;
    }
    //VALIDATE The Size Of A Storm


    //VALIDATE That A Storm Has Been Chosen
    public int ValidateStormType(String typeOfStorm){
        switch(typeOfStorm){
            case "Hurricane":
                return 1;

            case "Tornado":
                return 2;

            case "Blizzard":
                return 3;

            default:
                return 4;
        }
    }
    //VALIDATE That A Storm Has Been Chosen

}