package eru.testing.calculator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Disabled
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

    @Test
    void shouldMinusCorrrectly(){
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);

        when(reader.readDouble()).thenReturn(20.0, 10.0);
        when(reader.readWord()).thenReturn("-");
        Calculator calculator = new Calculator(reader,writer);

        calculator.calculate();

        verify(writer).write("20.0 - 10.0 = 10.0");

    }

    @Test
    void shouldMultiplyCorrrectly(){
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);

        when(reader.readDouble()).thenReturn(20.0, 10.0);
        when(reader.readWord()).thenReturn("*");
        Calculator calculator = new Calculator(reader,writer);

        calculator.calculate();

        verify(writer).write("20.0 * 10.0 = 200.0");

    }

    @Test
    void shouldDivideCorrrectly(){
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);

        when(reader.readDouble()).thenReturn(20.0, 10.0);
        when(reader.readWord()).thenReturn("/");
        Calculator calculator = new Calculator(reader,writer);

        calculator.calculate();

        verify(writer).write("10.0 / 2.0 = 5.0");

    }

    @Test
    void shouldNonMathOperatorMessageCorrrectly(){
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);

        when(reader.readDouble()).thenReturn(20.0, 10.0);
        when(reader.readWord()).thenReturn("Ersoy", "*");
        Calculator calculator = new Calculator(reader,writer);

        calculator.calculate();

        verify(writer).write("Please try again (enter an operator):");

    }

    @Test
    void shouldNonValidDouble(){
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);

        when(reader.readDouble())
                .thenThrow(new InputMismatchException())
                .thenReturn(20.0, 10.0);

        when(reader.readWord()).thenReturn("*");
        Calculator calculator = new Calculator(reader,writer);

        calculator.calculate();

        verify(writer).write("Please try again (enter a number):");

    }
}
