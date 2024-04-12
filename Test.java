import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DiceExpressionTest {

    int testExpr(String exp) {
        return (new DiceExpression(exp)).evaluate();
    }

    void testMinMax(final String exp, int expectedMin, int expectedMax) {
        List<Integer> results= new ArrayList<>();
        for (int i = 0 ; i < 1000; i ++)
            results.add(testExpr(exp));
        assertEquals(expectedMin, Collections.min(results));
        assertEquals(expectedMax, Collections.max(results));
    }

    @Test
    void test_2d6() {
        testMinMax("2d6", 2, 12);
    }

    @Test
    void test_2d0_6() {
        testMinMax("2d6 + 10", 12, 24);
    }

    @Test
    void testIsValidExpression(){
        assertTrue(DiceExpression.isValidExpression("2d6 + 10"));
    }
}