import java.util.ArrayList;
import java.util.regex.Pattern;

public class Validation {

    private String userResponse;


    /*
    validating String by checking whether it contains a number
    */
    public boolean ValidateString(String tmp) {

        return true;
    }


    /*
    validating integer by attempting to parse it from its initial string input
    */
    public boolean ValidateInteger(String tmp) {
        //try {
        //    Integer.parseInt(tmp);
        //} catch (Exception e) {
         //   System.out.println("Invallid input, numbers only");

           // return false;

        //}
        return true;
    }

    public boolean ValidateStormSize(ArrayList currentStorms){
        if (currentStorms.size() >= 20){
            return false;
        }
        return true;
    }

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
}