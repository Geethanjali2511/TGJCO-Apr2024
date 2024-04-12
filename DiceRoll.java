public class DiceRoll {

    // Static method to roll a die with a specified number of sides
    public static int roll(int sides) {
        int min = 0;
        int max = sides;
        // Implement dice rolling logic
        int diceRoll = 1;
        diceRoll += (int) (Math.random() * (max - min + 1) + min);

        return diceRoll;
    }

}