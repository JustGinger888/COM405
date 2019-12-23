import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlizzardTest {

    @Test
    void calculations() {
        Blizzard tst1 = new Blizzard("Test","35","-10");
        Blizzard tst2 = new Blizzard("Test","45","-12");
        Blizzard tst3 = new Blizzard("Test","25","-8");

        assertEquals(1, tst1.Calculations(tst1.stormWindSpeed,tst1.stormTemp));
        assertEquals(2, tst2.Calculations(tst2.stormWindSpeed,tst2.stormTemp));
        assertEquals(3, tst3.Calculations(tst3.stormWindSpeed,tst3.stormTemp));
    }

    @Test
    void categoryAdvice() {
        Blizzard tst1 = new Blizzard("Test","35","-10");
        Blizzard tst2 = new Blizzard("Test","45","-12");
        Blizzard tst3 = new Blizzard("Test","25","-8");

        assertEquals("Blizzard\nKeep warm, do not travel unless absolutely essential", tst1.CategoryAdvice(tst1.stormWindSpeed,tst1.stormTemp));
        assertEquals("Severe Blizzard\nKeep warm, avoid all travel", tst2.CategoryAdvice(tst2.stormWindSpeed,tst2.stormTemp));
        assertEquals("Snowstorm\nTake care and avoid travel if possible", tst3.CategoryAdvice(tst3.stormWindSpeed,tst3.stormTemp));
    }
}