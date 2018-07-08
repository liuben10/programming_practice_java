package Calculator;


import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void simpleEvaluate() {
        int result = Calculator.calculate("3 + 4");
        Assert.assertEquals(result, 7);
    }
}
