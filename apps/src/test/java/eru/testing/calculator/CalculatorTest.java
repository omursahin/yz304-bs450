package eru.testing.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void shouldSumCorrectly(){
//        DummyWriter writer = new DummyWriter();
//        DummyReader reader = new DummyReader();

        StubWriter writer = new StubWriter();
        StubReader reader = new StubReader();

        Calculator calculator = new Calculator(reader,writer);
        calculator.calculate();
        assertEquals("10.0 + 10.0 = 20.0", writer.getValue());
    }
}
