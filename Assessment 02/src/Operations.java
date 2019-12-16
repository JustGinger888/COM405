import java.util.ArrayList;

public class Operations {

    private Validation validation = new Validation();

    private ArrayList<Storm> currentStorms = new ArrayList<Storm>();

    private Hurricane hurricane = new Hurricane();
    private Tornado tornado = new Tornado();
    private Blizzard blizzard = new Blizzard();

    public String AddOperationControl(String stormName, String stormWindSpeed, String stormTemp, String typeOfStorm){
        if (ValidateInput(stormName, stormWindSpeed, stormTemp)){
            if (StormSize()){
                if (StormType(typeOfStorm) != 4){
                    StormAddition(stormName, stormWindSpeed, stormTemp, StormType(typeOfStorm));
                    return "Added Storm Successfully";
                }
                return "Select The Type Of Storm";
            }
            return "Storm Exceeds Maximum Array Size";
        }
        return "Failed To Verify Input, Ensure Everything Is Added Correct";
    }

    public boolean ValidateInput(String stormName, String stormWindSpeed, String stormTemp){
        if (validation.ValidateString(stormName) && validation.ValidateInteger(stormWindSpeed) && validation.ValidateInteger(stormTemp)){
            return true;
        }
        return false;
    }

    public boolean StormSize(){
        if (currentStorms.size() >= 20){
            return false;
        }
        return true;
    }

    public int StormType(String typeOfStorm){
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

    public void StormAddition(String stormName, String stormWindSpeed, String stormTemp, int StormType){
        switch (StormType){
            case 1:
                currentStorms.add(hurricane);
                break;
            case 2:
                currentStorms.add(tornado);
                break;
            case 3:
                currentStorms.add(blizzard);
                break;
        }
            System.out.println(currentStorms);

    }
}
