import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TornadoTest {

    @Test
    void calculations() {
        Tornado tst1 = new Tornado("Test","40","0");
        Tornado tst2 = new Tornado("Test","73","0");
        Tornado tst3 = new Tornado("Test","112","0");
        Tornado tst4 = new Tornado("Test","158","0");
        Tornado tst5 = new Tornado("Test","206","0");
        Tornado tst6 = new Tornado("Test","262","0");
        Tornado tst7 = new Tornado("Test","20","0");

        assertEquals(0, tst1.Calculations(tst1.stormWindSpeed,tst1.stormTemp));
        assertEquals(1, tst2.Calculations(tst2.stormWindSpeed,tst2.stormTemp));
        assertEquals(2, tst3.Calculations(tst3.stormWindSpeed,tst3.stormTemp));
        assertEquals(3, tst4.Calculations(tst4.stormWindSpeed,tst4.stormTemp));
        assertEquals(4, tst5.Calculations(tst5.stormWindSpeed,tst5.stormTemp));
        assertEquals(5, tst6.Calculations(tst6.stormWindSpeed,tst6.stormTemp));
        assertEquals(6, tst7.Calculations(tst7.stormWindSpeed,tst7.stormTemp));
    }

    @Test
    void categoryAdvice() {
        Tornado tst1 = new Tornado("Test","40","0");
        Tornado tst2 = new Tornado("Test","73","0");
        Tornado tst3 = new Tornado("Test","112","0");
        Tornado tst4 = new Tornado("Test","158","0");
        Tornado tst5 = new Tornado("Test","206","0");
        Tornado tst6 = new Tornado("Test","262","0");
        Tornado tst7 = new Tornado("Test","20","0");

        assertEquals("F0\nFind safe room/shelter, shield yourself from debris", tst1.CategoryAdvice(tst1.stormWindSpeed,tst1.stormTemp));
        assertEquals("F1\nFind safe room/shelter, shield yourself from debris", tst2.CategoryAdvice(tst2.stormWindSpeed,tst2.stormTemp));
        assertEquals("F2\nFind underground shelter, crouch near to the floor covering your head with your hand", tst3.CategoryAdvice(tst3.stormWindSpeed,tst3.stormTemp));
        assertEquals("F3\nFind underground shelter, crouch near to the floor covering your head with your hand", tst4.CategoryAdvice(tst4.stormWindSpeed,tst4.stormTemp));
        assertEquals("F4\nFind underground shelter, crouch near to the floor covering your head with your hand", tst5.CategoryAdvice(tst5.stormWindSpeed,tst5.stormTemp));
        assertEquals("F5\nFind underground shelter, crouch near to the floor covering your head with your hand", tst6.CategoryAdvice(tst6.stormWindSpeed,tst6.stormTemp));
        assertEquals("Unclassified\nThere is no need to panic", tst7.CategoryAdvice(tst7.stormWindSpeed,tst7.stormTemp));
    }
}