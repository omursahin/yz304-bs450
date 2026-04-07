package eru.testing.calculator;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void shouldSumCorrectly(){
        DummyWriter writer = new DummyWriter();
        DummyReader reader = new DummyReader();
        
        Calculator calculator = new Calculator(reader,writer);
        calculator.calculate();
    }
}
