
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DiceExpressionTest {

    int testExpr(String exp) {
        return (new DiceExpression(exp)).evaluate();
    }

    void testMinMax(final String exp, int expectedMin, int expectedMax) {
        List<Integer> results= new ArrayList<>();
        for (int i = 0 ; i < 100; i ++)
            results.add(testExpr(exp));
        assertEquals(expectedMin, results.stream().min(Integer::compare).get());
        assertEquals(expectedMax, results.stream().max(Integer::compare).get());
    }

    @Test
    void test_2d6() {
        testMinMax("2d6", 2, 12);
    }

    @Test
    void test_2d0_6() {
        testMinMax("2d6 + 10", 12, 24);
    }
}