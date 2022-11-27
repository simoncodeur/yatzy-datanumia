import java.util.List;

public class Yatzy {
    /* This class allow the user to score a given roll in a given category */

    // The special scores of the Yatzy game
    private final static Integer SCORE_YATZY = 50;
    private final static Integer SCORE_SMALL_STRAIGHT = 15;
    private final static Integer SCORE_LARGE_STRAIGHT = 20;

    private DiceRoll diceRoll;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        diceRoll = new DiceRoll(d1, d2, d3, d4, d5);
    }

    // Return the sum of all dice
    public int chance() {
        return diceRoll.sum();
    }

    // If all dice have the same number, return {@link Yatzy#SCORE_YATZY}
    public int yatzy() {
        if (diceRoll.containsOccurrence(5)) {
            return SCORE_YATZY;
        }
        return 0;
    }

    // Return the sum of the dice that reads 1
    public int ones() {
        return diceRoll.count(1);
    }

    // Return the sum of the dice that reads 2
    public int twos() {
        return diceRoll.count(2) * 2;
    }

    // Return the sum of the dice that reads 3
    public int threes() {
        return diceRoll.count(3) * 3;
    }

    // Return the sum of the dice that reads 4
    public int fours() {
        return diceRoll.count(4) * 4;
    }

    // Return the sum of the dice that reads 5
    public int fives() {
        return diceRoll.count(5) * 5;
    }

    // Return the sum of the dice that reads 6
    public int sixes() {
        return diceRoll.count(6) * 6;
    }

    // Return the sum of the two highest matching dice
    public int scorePair() {
        List<Integer> pairs = diceRoll.findByOccurrences(2);
        if (!pairs.isEmpty()) {
            // Get the highest pair value of the list
            return pairs.stream().max(Integer::compare).get() * 2;
        } else {
            return 0;
        }
    }

    // If there are two pairs of dice with the same number, return the sum of these dice
    public int twoPairs() {
        List<Integer> pairs = diceRoll.findByOccurrences(2);
        if (pairs.size() ==  2) {
            return (pairs.get(0) + pairs.get(1)) * 2;
        } else {
            // Check if there is a FOAK (which is a valid two pairs) and return 0 if not
            return fourOfAKind();
        }
    }

    // If there are three dice with the same number, return the sum of these dice
    public int threeOfAKind() {
        List<Integer> toak = diceRoll.findByOccurrences(3);
        if (!toak.isEmpty()) {
            return toak.get(0) * 3;
        } else {
            return 0;
        }
    }

    // If there are four dice with the same number, return the sum of these dice
    public int fourOfAKind() {
        List<Integer> foak = diceRoll.findByOccurrences(4);
        if (!foak.isEmpty()) {
            return foak.get(0) * 4;
        } else {
            return 0;
        }
    }

    // If the dice read 1,2,3,4,5, return {@link Yatzy#SCORE_SMALLSTRAIGHT}
    public int smallStraight() {
        // 5 different dice values means that each die is different and if the set miss one value, we have the 5 others values in the roll
        if ((diceRoll.diceValuesSize() == 5) && (!diceRoll.containsDiceValue(6))) {
            return SCORE_SMALL_STRAIGHT;
        } else {
            return 0;
        }
    }

    // If the dice read 2,3,4,5,6, return {@link Yatzy#SCORE_LARGESTRAIGHT}
    public int largeStraight() {
        if ((diceRoll.diceValuesSize() == 5) && (!diceRoll.containsDiceValue(1))) {
            return SCORE_LARGE_STRAIGHT;
        } else {
            return 0;
        }
    }

    // If the dice are two of a kind and three of a kind, return the sum of all the dice
    public int fullHouse() {
        // If there is no single die value, it means there is either one pair and one toak or one Yatzy
        if (!diceRoll.containsOccurrence(1)) {
            return diceRoll.sum();
        } else {
            return 0;
        }
    }
}



