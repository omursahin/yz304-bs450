package eru.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @Test
    public void shouldClassifyEquilateral() {
        Triangle.Type result = Triangle.classify(5, 5, 5);
        assertEquals(Triangle.Type.EQUILATERAL, result);
    }

    @Test
    public void shouldClassifyIsoceles() {
        Triangle.Type result = Triangle.classify(4, 5, 5);
        assertEquals(Triangle.Type.ISOSCELES, result);
    }

    @Test
    public void shouldClassifyIsocelesWhenSidesAreOutOfOrder() {
        Triangle.Type result = Triangle.classify(5, 4, 5);
        assertEquals(Triangle.Type.ISOSCELES, result);
    }

    @Test
    public void shouldThrowExceptionWithInvalidTriangle() {
        assertThrows(InvalidTriangleException.class,
                () -> {
                    Triangle.classify(-5, 4, 5);
                });
    }

    @Test
    public void shouldClassifyScalene() {
        Triangle.Type result = Triangle.classify(3, 4, 5);
        assertEquals(Triangle.Type.SCALENE, result);
    }

    @Test
    public void shouldClassifyMaxInteger() {
        Triangle.Type result = Triangle.classify(Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2);
        assertEquals(Triangle.Type.EQUILATERAL, result);
    }

    @Test
    public void shouldNegativeValueException() {
        assertThrows(NegativeValueException.class,
                () -> Triangle.classify(-1, -1, -1));
    }
}
