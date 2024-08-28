package kleimyonov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //Что будет происходить перед тестом и после теста -->
    @BeforeAll
    static void setUp() {
        System.out.println("Testing start...");
    }
    @AfterAll //or AfterAll & BeforeAll - один раз, а не после каждого теста
    static void setDown() {
        System.out.println("Testing end...");
    }
    //  <--

    @ParameterizedTest
    @Timeout(1000) //Если не выполнится за 1000 ms, то автоматически не пройдётся
    @CsvSource({
            "3,3, 6",
            "4,4, 8",
            "30, 23, 53"
    })
    void add(int left, int right, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.add(left,right);
        Assertions.assertEquals(expected, result);

        assertNotNull(result); //проверка на null
    }

    @Test
    void miltiply() {
        Calculator calculator = new Calculator();
        int result = calculator.miltiply(4, 7);
        Assertions.assertEquals(28, result);

    }

    @ParameterizedTest
    @CsvSource({
            "3,6, 0",
            "72,3, 24"
    })
    void divide(int left, int right, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.divide(left, right);
        Assertions.assertEquals(expected, result);
    }
}