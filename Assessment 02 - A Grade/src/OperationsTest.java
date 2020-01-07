import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    void stormAddition() {
        Operations operations = new Operations();
        assertEquals("Added Storm Successfully",operations.AddOperationControl("Name", "10", "10", "Hurricane"));
        assertEquals("Select The Type Of Storm",operations.AddOperationControl("Name", "10", "10", "Other"));
        assertEquals("Failed Input Verification, please ensure that:\n - All field are filled\n - Name is under 16 characters\n - Integers are in the range -500 to 500",operations.AddOperationControl("Name", "10a", "10b", "Hurricane"));
    }

    @Test
    void removeOperationControl() {
        Operations operations = new Operations();
        assertEquals("Failed To Find Storm Name", operations.RemoveOperationControl("Test"));
    }

    @Test
    void searchOperationControl() {
        Operations operations = new Operations();
        assertEquals("Failed To Find Storm Name", operations.SearchOperationControl("Test"));
    }

    @Test
    void updateOperationControl() {
        Operations operations = new Operations();
        assertEquals("Failed To Find Storm Name", operations.UpdateOperationControl("Test"));
    }
    
    @Test
    void validateInput() {
        Operations operations = new Operations();
        assertEquals(true, operations.ValidateInput("Test", "10", "10"));
        assertEquals(false, operations.ValidateInput("Test", "10a", "10b"));
    }

    @Test
    void locateIndex() {
        Operations operations = new Operations();
        Blizzard tst1 = new Blizzard("Test","35","-10");
        Hurricane tst2 = new Hurricane("Test","74","0");
        ArrayList<Storm> tstLst = new ArrayList<Storm>();

        tstLst.add(tst1);
        operations.setCurrentStorms(tstLst);
        assertEquals(true, operations.LocateIndex("Test"));
        assertEquals(false, operations.LocateIndex("None"));
    }

    @Test
    void duplicateCheck() {
        Operations operations = new Operations();
        Blizzard tst1 = new Blizzard("Test","35","-10");
        Hurricane tst2 = new Hurricane("Test","74","0");
        ArrayList<Storm> tstLst = new ArrayList<Storm>();

        tstLst.add(tst1);
        operations.setCurrentStorms(tstLst);
        assertEquals(true, operations.DuplicateCheck("Success"));

        tstLst.add(tst2);
        operations.setCurrentStorms(tstLst);
        assertEquals(false, operations.DuplicateCheck("Test"));
    }

    void sizeTest(){
        Operations operations = new Operations();
        Blizzard tst1 = new Blizzard("Test","35","-10");
        Hurricane tst2 = new Hurricane("Test","74","0");
        Tornado tst3 = new Tornado("Test","40","0");
        Hurricane tst4 = new Hurricane("Test","74","0");
        Blizzard tst5 = new Blizzard("Test","35","-10");

        ArrayList<Storm> tstLst = operations.getCurrentStorms();
        //Addition 1-5
        tstLst.add(tst2);
        tstLst.add(tst3);
        tstLst.add(tst4);
        tstLst.add(tst5);

        //Addition 6-10
        tstLst.add(tst1);
        tstLst.add(tst2);
        tstLst.add(tst3);
        tstLst.add(tst4);
        tstLst.add(tst5);

        //Addition 11-15
        tstLst.add(tst1);
        tstLst.add(tst2);
        tstLst.add(tst3);
        tstLst.add(tst4);
        tstLst.add(tst5);

        //Addition 16-20
        tstLst.add(tst1);
        tstLst.add(tst2);
        tstLst.add(tst3);
        tstLst.add(tst4);
        tstLst.add(tst5);

        //Addition 21-25
        tstLst.add(tst1);
        tstLst.add(tst2);
        tstLst.add(tst3);
        tstLst.add(tst4);
        tstLst.add(tst5);

        operations.setCurrentStorms(tstLst);
        tstLst = operations.getCurrentStorms();

        assertEquals(25, tstLst.size());
    }
}