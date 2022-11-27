import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;



public class DiceRollTest {

    @Test
    public void testCount() {
        assertEquals(2, new DiceRoll(2,4,4,5,1).count(4));
    }

    @Test
    public void testSum() {
        assertEquals(10, new DiceRoll(2,1,1,5,1).sum());
    }

    @Test
    public void testFindByOccurrences() {
        DiceRoll diceRoll = new DiceRoll(2,2,1,5,1);
        assertTrue(Arrays.asList(2,1).containsAll(diceRoll.findByOccurrences(2)));
        assertTrue(diceRoll.findByOccurrences(5).isEmpty());
    }

    @Test
    public void testContainsDiceValue() {
        DiceRoll diceRoll = new DiceRoll(1,2,3,2,6);
        assertFalse(diceRoll.containsDiceValue(4));
        assertTrue(diceRoll.containsDiceValue(1));
    }

    @Test
    public void testContainsOccurrence() {
        DiceRoll diceRoll = new DiceRoll(1,2,3,3,6);
        assertFalse(diceRoll.containsOccurrence(4));
        assertTrue(diceRoll.containsOccurrence(2));
    }

    @Test
    public void testDiceValuesSize() {
        assertEquals(2, new DiceRoll(1,3,3,3,3).diceValuesSize());
    }
}