import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chanceScoresSumOfAllDice() {
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test
    public void yatzyScores50() {
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy(1,2,3,3,3).yatzy());
    }

    @Test
    public void testOnes() {
        assertEquals(2, new Yatzy(1,1,3,4,5).ones());
    }

    @Test
    public void testTwos() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
    }

    @Test
    public void testThrees() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
    }

    @Test
    public void testFours() {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
    }

    @Test
    public void testFives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
    }

    @Test
    public void testSixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).scorePair());
        assertEquals(0, new Yatzy(1,2,3,4,5).scorePair());
    }

    @Test
    public void testTwoPairs() {
        assertEquals(16, new Yatzy(3,3,5,4,5).twoPairs());
        assertEquals(0, new Yatzy(3,2,5,5,5).twoPairs());
    }

    @Test
    public void testThreeOfAKind() {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfAKind());
        assertEquals(0, new Yatzy(3,2,3,4,5).threeOfAKind());
    }

    @Test
    public void testFourOfAKind() {
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfAKind());
        assertEquals(0, new Yatzy(1,2,3,3,5).fourOfAKind());
    }

    @Test
    public void testSmallStraight() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(0, new Yatzy(2,3,4,5,6).smallStraight());
    }

    @Test
    public void testLargeStraight() {
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy(2,2,2,5,6).largeStraight());
    }

    @Test
    public void testFullHouse() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
    }
}
