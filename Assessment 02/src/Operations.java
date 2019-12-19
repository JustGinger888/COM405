import java.util.ArrayList;

public class Operations {

    private Validation validation = new Validation();

    public int indexStorm;

    private ArrayList<Storm> currentStorms = new ArrayList<Storm>();
    public ArrayList<Storm> getCurrentStorms() {
        return currentStorms;
    }


    public String AddOperationControl(String stormName, String stormWindSpeed, String stormTemp, String typeOfStorm){
        if (ValidateInput(stormName, stormWindSpeed, stormTemp)){
            if (StormSize()){
                if (StormType(typeOfStorm) != 4){
                    StormAddition(stormName, stormWindSpeed, stormTemp, StormType(typeOfStorm));
                    System.out.println(currentStorms);
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
        Hurricane hurricane = new Hurricane(stormName,stormWindSpeed,stormTemp);
        Tornado tornado = new Tornado(stormName,stormWindSpeed,stormTemp);
        Blizzard blizzard = new Blizzard(stormName,stormWindSpeed,stormTemp);

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
    }

    public String RemoveOperationControl(String stormName){
        //Add double name checker
        if (ValidateName(stormName)){
            currentStorms.remove(indexStorm);
            System.out.println(currentStorms);
            return "Select The Type Of Storm";
        }
        return "Failed To Find Storm Name";
    }

    public boolean ValidateName(String stormName) {
        for (int i = 0; i < currentStorms.size(); i++) {
            if (currentStorms.get(i).stormName.equals(stormName)) {
                indexStorm = i;
                return true;
            }
        }
        return false;
    }

    public String SearchOperationControl(String stormName){
        if (ValidateName(stormName)){
            System.out.println(currentStorms);
            return "Displaying Storm Information";
        }
        return "Failed To Find Storm Name";
    }

    public String UpdateOperationControl(String stormName){
        if (ValidateName(stormName)){
            System.out.println(currentStorms);
            return "Displaying Storm Information for Update";
        }
        return "Failed To Find Storm Name";
    }

    public String UpdateSaveOperationControl(String stormName, String stormWindSpeed, String stormTemp, int dplValue){
        if (ValidateInput(stormName, stormWindSpeed, stormTemp)){
            SaveOperation(stormName, stormWindSpeed, stormTemp,dplValue);
            System.out.println(currentStorms);
            return "Added Storm Successfully";
        }
        return "Failed To Verify Input, Ensure Everything Is Added Correct";
    }

    public void SaveOperation(String stormNameIn, String stormWindSpeedIn, String stormTempIn, int dplValue){
        Storm sveStrom= currentStorms.get(dplValue);
        sveStrom.stormName = stormNameIn;
        sveStrom.stormWindSpeed = stormWindSpeedIn;
        sveStrom.stormTemp = stormTempIn;
        currentStorms.set(dplValue, sveStrom);
    }
}
