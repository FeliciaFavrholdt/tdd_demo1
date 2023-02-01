import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");
        Calculator calculator = new Calculator();
        int actual = calculator.add(1, 2);
        int expected = 3;
        assertEquals(expected, actual);
    }
}
