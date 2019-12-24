import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Operations {

    private Validation validation = new Validation();

    private int indexStorm;
    public int getIndexStorm() {
        return indexStorm;
    }

    private ArrayList<Storm> currentStorms = new ArrayList<Storm>();
    public ArrayList<Storm> getCurrentStorms() {
        return currentStorms;
    }
    public void setCurrentStorms(ArrayList<Storm> currentStorms) {
        this.currentStorms = currentStorms;
    }

    //ADDING a Storm to ArrayList
    public String AddOperationControl(String stormName, String stormWindSpeed, String stormTemp, String typeOfStorm){
        if (ValidateInput(stormName, stormWindSpeed, stormTemp)){
            //if (validation.ValidateStormSize(currentStorms)){
                if (validation.ValidateStormType(typeOfStorm) != 4) {
                    if (DuplicateCheck(stormName)) {
                        StormAddition(stormName, stormWindSpeed, stormTemp, validation.ValidateStormType(typeOfStorm));
                        System.out.println(currentStorms);
                        return "Added Storm Successfully";
                    }
                    return "Storm Name Already In Use";
                }
                return "Select The Type Of Storm";
            //}
            //return "Storm Exceeds Maximum Array Size";
        }
        return "Failed Input Verification, please ensure that:\n - All field are filled\n - Name is under 16 characters\n - Integers are in the range -500 to 500";
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
    //ADDING a Storm to ArrayList


    //REMOVING a Storm from ArrayList
    public String RemoveOperationControl(String stormName){
        //Add double name checker
        if (LocateIndex(stormName)){
            currentStorms.remove(indexStorm);
            System.out.println(currentStorms);
            return "Storm Removed Successfully";
        }
        return "Failed To Find Storm Name";
    }
    //REMOVING a Storm from ArrayList


    //SEARCHING for Storm in ArrayList
    public String SearchOperationControl(String stormName){
        if (LocateIndex(stormName)){
            System.out.println(currentStorms);
            return "Displaying Storm Information";
        }
        return "Failed To Find Storm Name";
    }
    //SEARCHING for Storm in ArrayList


    //UPDATING a Storm in ArrayList
    public String UpdateOperationControl(String stormName){
        if (LocateIndex(stormName)){
            System.out.println(currentStorms);
            return "Displaying Storm Information for Update";
        }
        return "Failed To Find Storm Name";
    }


    //SAVING a Storm in ArrayList
    public String SaveOperationControl(String updStormName, String stormName, String stormWindSpeed, String stormTemp){
        if (ValidateInput(stormName, stormWindSpeed, stormTemp)){
            if (LocateIndex(updStormName) ) {
                SaveOperation(stormName, stormWindSpeed, stormTemp);
                System.out.println(currentStorms);
                return "Updated Storm Successfully";
            }
            return "Ensure Storm Name Is Not Already In Use";
        }
        return "Failed Input Verification, please ensure that:\n - All field are filled\n - Name is under 16 characters\n - Integers are in the range -500 to 500";
    }

    public void SaveOperation(String stormNameIn, String stormWindSpeedIn, String stormTempIn){
        Storm sveStorm= currentStorms.get(indexStorm);
        sveStorm.stormName = stormNameIn;
        sveStorm.stormWindSpeed = stormWindSpeedIn;
        sveStorm.stormTemp = stormTempIn;
        currentStorms.set(indexStorm, sveStorm);
    }
    //SAVING a Storm in ArrayList
    //UPDATING a Storm in ArrayList


    //VALIDATING Input
    public boolean ValidateInput(String stormName, String stormWindSpeed, String stormTemp){
        if (validation.ValidateString(stormName) && validation.ValidateInteger(stormWindSpeed) && validation.ValidateInteger(stormTemp)){
            return true;
        }
        return false;
    }

    public boolean ValidateAddition(String stormName, String stormWindSpeed, String stormTemp, int dplValue){
        if (ValidateInput(stormName, stormWindSpeed, stormTemp)){
            //if (validation.ValidateStormSize(currentStorms)) {
                if (AltDuplicateCheck(stormName, dplValue)) {
                    return true;
                }
            //}
        }
        return false;
    }

    public boolean ValidateSaving(String stormName, String stormWindSpeed, String stormTemp){
        if (ValidateInput(stormName, stormWindSpeed, stormTemp)){
            //if (validation.ValidateStormSize(currentStorms)) {
                return true;
            //}
        }
        return false;
    }
    //VALIDATING Input


    //LOCATING Display Index
    public boolean LocateIndex(String stormName) {
        for (int i = 0; i < currentStorms.size(); i++) {
            if (currentStorms.get(i).stormName.equals(stormName)) {
                indexStorm = i;
                return true;
            }
        }
        return false;
    }
    //LOCATING Display Index


    //Validate There is no Duplicates by Checking Whether the List Contains The Same Name
    public boolean DuplicateCheck(String stormName) {
        for (int i = 0; i < currentStorms.size(); i++) {
            if (currentStorms.get(i).stormName.equals(stormName)) {
                return false;
            }
        }

        return true;
    }

    public boolean AltDuplicateCheck(String stormName, int dplValue) {
        for (int i = 0; i < currentStorms.size(); i++) {
            if (currentStorms.get(i).stormName.equals(stormName) && i != dplValue) {
                return false;
            }
        }

        return true;
    }
    //Validate There is no Duplicates by Checking Whether the List Contains The Same Name */

}
