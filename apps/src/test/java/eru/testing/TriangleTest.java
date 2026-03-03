package eru.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @Test
    public void shouldClassifyEquilateral() {
        Triangle.Type type = Triangle.classify(10, 10, 10);
        assertEquals(Triangle.Type.EQUILATERAL, type);
    }

    @Test
    public void shouldClassifyIsoceles() {
        Triangle.Type type = Triangle.classify(8, 10, 10);
        assertEquals(Triangle.Type.ISOSCELES, type);
    }

    @Test
    public void shouldClassifyIsocelesWhenSidesAreOutOfOrder() {
        Triangle.Type type = Triangle.classify(10, 8, 10);
        assertEquals(Triangle.Type.ISOSCELES, type);
    }

    @Test
    public void shouldThrowExceptionWithInvalidTriangle() {
        assertThrows(InvalidTriangleException.class, () -> {
            Triangle.classify(0, 0, 0);
        });
    }

    @Test
    public void shouldThrowExceptionNegativeValue() {
        assertThrows(NegativeValueException.class, () -> {
            Triangle.classify(1, 1, -1);
        });
    }

    @Test
    public void shouldEdgeValueMin() {
        assertThrows(NegativeValueException.class, () -> {
            Triangle.classify(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
    }

    @Test
    public void shouldEdgeValueMax() {
        assertThrows(NegativeValueException.class, () -> {
            Triangle.classify(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);
        });
    }
}
