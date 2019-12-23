import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void validateInteger() {
    }

    @Test
    void validateStormSize() {
        Validation validation = new Validation();

        Blizzard tst1 = new Blizzard("Test","35","-10");
        Hurricane tst2 = new Hurricane("Test","74","0");
        Tornado tst3 = new Tornado("Test","40","0");
        Hurricane tst4 = new Hurricane("Test","74","0");
        Blizzard tst5 = new Blizzard("Test","35","-10");

        ArrayList<Storm> tstLst = new ArrayList<Storm>();
        //Addition 1-5
        tstLst.add(tst1);
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

        //Addition 21
        tstLst.add(tst1);

        assertEquals(false, validation.ValidateStormSize(tstLst));
    }

    @Test
    void validateStormType() {

    }
}