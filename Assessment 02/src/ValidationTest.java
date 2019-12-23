import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void validateInteger() {
    }

    @Test
    void validateStormSize() {
        Blizzard tst1 = new Blizzard("Test","35","-10");
        Hurricane tst2 = new Hurricane("Test","74","0");
        Tornado tst3 = new Tornado("Test","40","0");

        ArrayList<Storm> tstLst = new ArrayList<Storm>();
        tstLst.add(tst1);
        tstLst.add(tst2);
        tstLst.add(tst3);

        //assertEquals(false, validateStormSize(ts));
        assertEquals(false,"-1000");
    }

    @Test
    void validateStormType() {

    }
}