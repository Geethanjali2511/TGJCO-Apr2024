import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DiceExpression {
    private String expression;

    public DiceExpression(String expression) {
        this.expression = expression.trim(); // Trim the input string
    }

    public int evaluate() {

        int val = 0;
        String[] arrOfUserInput = expression.split(" ");
        int sum = 0;
        for (int j = 0; j < arrOfUserInput.length; j++) {


            if (arrOfUserInput[j].contains("d")) {
                String[] diceArray = arrOfUserInput[j].split("d");//2d4 //d3
                if (diceArray[0].equals("")) {
                    int rolls = 1;
                    int sides = Integer.parseInt(diceArray[1]);for (int i = 0; i < rolls; i++) {
                        sum += DiceRoll.roll(sides);
                    }
                    arrOfUserInput[j] = String.valueOf(sum);

                } else {
                    int rolls = Integer.parseInt(diceArray[0]);
                    int sides = Integer.parseInt(diceArray[1]);
                    for (int i = 0; i < rolls; i++) {
                        sum+= DiceRoll.roll(sides);
                    }
                    arrOfUserInput[j] = String.valueOf(sum);

                }
            }

            System.out.println(arrOfUserInput[j]);

        }

        for (int k = 1; k < arrOfUserInput.length-1; k++) {
            val = Integer.parseInt(arrOfUserInput[0]);
            if (arrOfUserInput[k].equals("+")) {
                val += Integer.parseInt(arrOfUserInput[k + 1]);
            } else if (arrOfUserInput[k].equals("-")) {
                val -= Integer.parseInt(arrOfUserInput[k + 1]);
            } else if (arrOfUserInput[k].equals("*")) {
                val *= Integer.parseInt(arrOfUserInput[k + 1]);
            }
        }
        System.out.println(val);


        return val;

    }

    public static boolean isValidExpression(String diceExpression) {
        String[] parts = diceExpression.split("\\s*[+\\-*/]\\s*");

        for (String part : parts) {
            Pattern pattern = Pattern.compile("((\\d+d\\d+)|(d\\d+))(\\s*[+\\-*/]\\s*(\\d+))?");
            Matcher matcher = pattern.matcher(part);

            if (!matcher.matches()) {
                return false;
            }
        }

        return true;
    }
}