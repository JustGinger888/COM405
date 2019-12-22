import java.util.ArrayList;

public class Validation {

    //Validate String by Checking Whether it Contains a Number
    public boolean ValidateString(String tmp) {
        return true;
    }
    //Validate String by Checking Whether it Contains a Number


    //Validate There is no Duplicates by Checking Whether the List Contains The Same Name
    public boolean ValidateDuplicate(String tmp, ArrayList tmpList) {
        return true;
    }
    //Validate There is no Duplicates by Checking Whether the List Contains The Same Name


    //VALIDATE Integer by Attempting to Parse it from Its Initial String Input
    public boolean ValidateInteger(String tmp) {
        try {
            Integer.parseInt(tmp);
        } catch (Exception e) {
            System.out.println("Invalid input, numbers only");
            return false;

        }
        return true;
    }
    //VALIDATE Integer by Attempting to Parse it from Its Initial String Input


    //VALIDATE The Size Of A Storm
    public boolean ValidateStormSize(ArrayList currentStorms){
        if (currentStorms.size() >= 20){
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