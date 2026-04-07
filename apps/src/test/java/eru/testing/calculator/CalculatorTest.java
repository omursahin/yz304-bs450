package eru.testing.calculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    void shouldPlusCorrrectly(){
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);

        when(reader.readDouble()).thenReturn(10.0, 20.0);
        when(reader.readWord()).thenReturn("+");
        Calculator calculator = new Calculator(reader,writer);

        calculator.calculate();

        verify(writer).write("10.0 + 20.0 = 30.0");

    }
}
