import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiceRoll {
    /* The DiceRoll class process the dice roll in input, 
    and regroup methods processing the value of the dice and/or their occurrence */

    private List<Integer> diceSet;
    private Map<Integer,Integer> diceOccurrences;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        // List of the dice values in the dice roll
        diceSet = Arrays.asList(d1, d2, d3, d4, d5);
        // Map, with the dice value as key and the number of occurrence as value
        diceOccurrences = new HashMap<>();
        diceSet.forEach(d -> diceOccurrences.put(d, diceOccurrences.getOrDefault(d,0)+1));
    }

    // Return the number of occurrences of the input value
    public int count(int targetValue) {
        return diceOccurrences.getOrDefault(targetValue, 0);
    }

    // Return the sum of the dice roll
    public int sum() {
        return diceSet.stream()
            .reduce(0, Integer::sum);
    }

    // Return a list of dice values which have the number of occurrences specified
    public List<Integer> findByOccurrences(int targetOccurrences) {
        return diceOccurrences.keySet().stream()
            .filter(k -> diceOccurrences.get(k) >= targetOccurrences)
            .collect(Collectors.toList());
    }

    // Return true if the value specified is found in the roll
    public boolean containsDiceValue(int diceValue) {
        return diceOccurrences.containsKey(diceValue);
    }

    // Return true if the number of occurrence specified is found in the roll
    public boolean containsOccurrence(int occurrence) {
        return diceOccurrences.containsValue(occurrence);
    }

    // Return the number of different value found in the roll
    public int diceValuesSize() {
        return diceOccurrences.size();
    }
}

