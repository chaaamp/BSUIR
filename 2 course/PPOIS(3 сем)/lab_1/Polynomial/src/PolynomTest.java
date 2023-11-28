


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynomTest {

    @Test
    void getCoefficient() {
        // Arrange
        double[] coefficients = {1.0, 2.0, 3.0};
        Polynom polynom = new Polynom(2, coefficients);

        // Act & Assert
        assertEquals(1.0, polynom.getCoefficient(0));
        assertEquals(2.0, polynom.getCoefficient(1));
        assertEquals(3.0, polynom.getCoefficient(2));
        assertEquals(0.0, polynom.getCoefficient(3));
    }


    @Test
    void add() {
        // Arrange
        double[] coefficients1 = {1.0, 2.0, 3.0};
        double[] coefficients2 = {4.0, 5.0, 6.0};
        Polynom poly1 = new Polynom(2, coefficients1);
        Polynom poly2 = new Polynom(2, coefficients2);

        // Act
        Polynom result = poly1.add(poly2);

        // Assert
        assertEquals("9.0x^2 + 7.0x + 5.0", result.toString());
    }

    @Test
    void subtract() {
        // Arrange
        double[] coefficients1 = {4.0, 5.0, 6.0};
        double[] coefficients2 = {1.0, 2.0, 3.0};
        Polynom poly1 = new Polynom(2,coefficients1);
        Polynom poly2 = new Polynom(2, coefficients2);

        // Act
        Polynom result = poly1.subtract(poly2);

        // Assert
        assertEquals("3.0x^2 + 3.0x + 3.0", result.toString());
    }

    @Test
    void multiply() {
        // Arrange
        double[] coefficients1 = {1.0, 2.0};
        double[] coefficients2 = {3.0, 4.0};
        Polynom poly1 = new Polynom(1, coefficients1);
        Polynom poly2 = new Polynom(1, coefficients2);

        // Act
        Polynom result = poly1.multiply(poly2);

        // Assert
        assertEquals("8.0x^2 + 10.0x + 3.0", result.toString());
    }

    @Test
    void divide() {
        // Arrange
        double[] coefficients1 = {4.0, 5.0, 6.0};
        double[]coefficients2 = {1.0, 2.0};
        Polynom poly1 = new Polynom(2, coefficients1);
        Polynom poly2 = new Polynom(1, coefficients2);

        // Act
        Polynom result = poly1.divide(poly2);

        // Assert
        assertEquals("3.0", result.toString());
    }

    @Test
    void addInPlace() {
        // Arrange
        double[] coefficients1 = {1.0, 2.0, 3.0};
        double[] coefficients2 = {4.0, 5.0, 6.0};
        Polynom poly1 = new Polynom(2,coefficients1);
        Polynom poly2 = new Polynom(2, coefficients2);

        // Act
        poly1.addInPlace(poly2);

        // Assert
        assertEquals("9.0x^2 + 7.0x + 5.0", poly1.toString());
    }

    @Test
    void subtractInPlace() {
        // Arrange
        double[] coefficients1 = {4.0, 5.0, 6.0};
        double[]coefficients2 = {1.0, 2.0, 3.0};
        Polynom poly1 = new Polynom(2, coefficients1);
        Polynom poly2 = new Polynom(2, coefficients2);

        // Act
        poly1.subtractInPlace(poly2);

        // Assert
        assertEquals("3.0x^2 + 3.0x + 3.0", poly1.toString());
    }

    @Test
    public void testEvaluateForConstantPolynomial() {
        // Testing a constant polynomial, e.g., P(x) = 5
        double[] coefficients = {5.0};
        Polynom poly = new Polynom(0, coefficients);

        double x = 2.5;
        assertEquals(5.0, poly.evaluate(x), 0.0001);
    }

    @Test
    public void testEvaluateForLinearPolynomial() {
        // Testing a linear polynomial, e.g., P(x) = 2x + 3
        double[] coefficients = {3.0, 2.0};
        Polynom poly = new Polynom(1, coefficients);

        double x = 4.0;
        assertEquals(11.0, poly.evaluate(x), 0.0001);
    }

    @Test
    public void testEvaluateForQuadraticPolynomial() {
        // Testing a quadratic polynomial, e.g., P(x) = 2x^2 + 3x + 1
        double[] coefficients = {1.0, 3.0, 2.0};
        Polynom poly = new Polynom(2, coefficients);

        double x = 2.0;
        assertEquals(15.0, poly.evaluate(x), 0.0001);
    }

    @Test
    public void testEvaluateForZeroPolynomial() {
        // Testing a zero polynomial, e.g., P(x) = 0
        double[] coefficients = {0.0};
        Polynom poly = new Polynom(0, coefficients);

        double x = 5.0;
        assertEquals(0.0, poly.evaluate(x), 0.0001);
    }

    @Test
    void multiplyInPlace() {
        // Arrange
        double[] coefficients1 = {1.0, 2.0};
        double[] coefficients2 = {3.0, 4.0};
        Polynom poly1 = new Polynom(1, coefficients1);
        Polynom poly2 = new Polynom(1, coefficients2);

        // Act
        poly1.multiplyInPlace(poly2);

        // Assert
        assertEquals("8.0x^2 + 10.0x + 3.0", poly1.toString());
    }

    @Test
    void divideInPlace() {
        // Arrange
        double[] coefficients1 = {4.0, 5.0, 6.0};
        double[] coefficients2 = {1.0, 2.0};
        Polynom poly1 = new Polynom(2,coefficients1);
        Polynom poly2 = new Polynom(1, coefficients2);

        // Act
        poly1.divideInPlace(poly2);

        // Assert
        assertEquals("3.0", poly1.toString());
    }

    @Test
    void testToString() {
        // Arrange
        double[] coefficients = {0.0, 0.0, 0.0, 0.0};
        Polynom poly= new Polynom(3, coefficients);

        // Act & Assert
        assertEquals("0", poly.toString());
    }
}
