import java.util.Scanner;

public class DiceRoller {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a dice expression to roll..");
        String diceExpression = scanner.nextLine();

        DiceExpression expression = new DiceExpression(diceExpression);
        expression.evaluate();



        scanner.close();
    }
}