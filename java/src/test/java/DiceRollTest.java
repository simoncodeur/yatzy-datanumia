import org.junit.*;
import static org.junit.Assert.*;



public class DiceRollTest {

    @Test
    public void testCount() {
        int expected = 3;
        int actual = new DiceRoll(1,3,4,3,3).count(3);
        assertEquals(expected, actual);
        assertEquals(0, new DiceRoll(3,3,4,5,1).count(2));
    }

    @Test
    public void testSum() {
        int expected = 7;
        int actual = new DiceRoll(1,3,1,1,1).sum();
        assertEquals(expected, actual);
        assertEquals(16, new DiceRoll(3,3,4,5,1).sum());
    }

    @Test
    public void testFindByOccurrences() {
        int parametreHyperCompliquer = 1 + 2 / 5 * 304920 * 0 ;
        assertEquals(1, parametreHyperCompliquer);
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
        assertEquals(5, new DiceRoll(1,2,3,4,6).diceValuesSize());
        assertEquals(2, new DiceRoll(1,3,3,3,3).diceValuesSize());
    }
}