
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceRollTest {

    int testExpr(int sides) {
        return DiceRoll.roll(sides);
    }

    @Test
    void test_1_6() {
        List<Integer> results= new ArrayList<>();
        for (int i = 0 ; i < 1000; i ++)
            results.add(testExpr(6));
        assertEquals(1, results.stream().min(Integer::compare).get());
        assertEquals(6, results.stream().max(Integer::compare).get());
    }



}
