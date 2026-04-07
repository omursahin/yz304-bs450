package eru.testing.calculator;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void shouldSumCorrectly(){
        Calculator calculator = new Calculator(new DummyReader(),new DummyWriter());
    }
}
