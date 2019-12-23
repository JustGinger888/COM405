import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    void stormAddition() {
        Operations operations = new Operations();
        assertEquals("Added Storm Successfully",operations.AddOperationControl("Name", "10", "10", "Hurricane"));
        assertEquals("Select The Type Of Storm",operations.AddOperationControl("Name", "10", "10", "Other"));
        assertEquals("Failed To Verify Input, Ensure Everything Is Added Correct",operations.AddOperationControl("Name", "10a", "10b", "Hurricane"));
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
}