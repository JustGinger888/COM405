import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HurricaneTest {

    @Test
    void calculations() {
        Hurricane tst1 = new Hurricane("Test","74","0");
        Hurricane tst2 = new Hurricane("Test","96","0");
        Hurricane tst3 = new Hurricane("Test","111","0");
        Hurricane tst4 = new Hurricane("Test","130","0");
        Hurricane tst5 = new Hurricane("Test","157","0");
        Hurricane tst6 = new Hurricane("Test","40","0");

        assertEquals(1, tst1.Calculations(tst1.stormWindSpeed,tst1.stormTemp));
        assertEquals(2, tst2.Calculations(tst2.stormWindSpeed,tst2.stormTemp));
        assertEquals(3, tst3.Calculations(tst3.stormWindSpeed,tst3.stormTemp));
        assertEquals(4, tst4.Calculations(tst4.stormWindSpeed,tst4.stormTemp));
        assertEquals(5, tst5.Calculations(tst5.stormWindSpeed,tst5.stormTemp));
        assertEquals(6, tst6.Calculations(tst6.stormWindSpeed,tst6.stormTemp));
    }

    @Test
    void categoryAdvice() {
        Hurricane tst1 = new Hurricane("Test","74","0");
        Hurricane tst2 = new Hurricane("Test","96","0");
        Hurricane tst3 = new Hurricane("Test","111","0");
        Hurricane tst4 = new Hurricane("Test","130","0");
        Hurricane tst5 = new Hurricane("Test","157","0");
        Hurricane tst6 = new Hurricane("Test","40","0");

        assertEquals("Category 1\nClose storm shutters and stay away from windows", tst1.CategoryAdvice(tst1.stormWindSpeed,tst1.stormTemp));
        assertEquals("Category 2\nClose storm shutters and stay away from windows", tst2.CategoryAdvice(tst2.stormWindSpeed,tst2.stormTemp));
        assertEquals("Category 3\nCoastal regions are encouraged to evacuate", tst3.CategoryAdvice(tst3.stormWindSpeed,tst3.stormTemp));
        assertEquals("Category 4\nEvacuate", tst4.CategoryAdvice(tst4.stormWindSpeed,tst4.stormTemp));
        assertEquals("Category 5\nEvacuate", tst5.CategoryAdvice(tst5.stormWindSpeed,tst5.stormTemp));
        assertEquals("Tropical Storm\nClose storm shutters and stay away from windows", tst6.CategoryAdvice(tst6.stormWindSpeed,tst6.stormTemp));
    }
}