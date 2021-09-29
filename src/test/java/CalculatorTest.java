import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTest {

    @DataProvider(name = "testcases")
    public Object[][] getTestCases() {
        return new Object[][] {
                {10, 0.1}, //базовый позитивный тест, как правило у таких тестов самый высокий приоритет
                {-10, -0.1}, //деление на отрицательное целое число, базовый сценарий
                {0.5, 2}, // деление на вещественное число, результат целое число - базовый сценарий
                {12.4567, 0.0802780832804836}, //полнота предствления чисел в дробной части
                {0, Double.POSITIVE_INFINITY}, // деление на нуль
                {Double.MAX_VALUE, 5.562684646268003E-309}, //максимальное возможное число
                {-Double.MAX_VALUE, -5.562684646268003E-309},//минимальное возможное число
                {Double.MIN_VALUE, Double.POSITIVE_INFINITY},//минимальное положительно число
                {-Double.MIN_VALUE, Double.NEGATIVE_INFINITY},//минимальное отрицательное число
                {1e7, 0.000_0001}, //scientific format разный варинат представления
                {1e+7, 1e-7},//scientific format разный варинат представления
                {1e-7, 1e7},//scientific format разный вваринат представления
                {Double.POSITIVE_INFINITY, 0.0}, // деление на минус бесконченость
                {Double.NEGATIVE_INFINITY, -0.0}, // деление на плюс бесконечность
        };
    }

    @Test(dataProvider = "testcases")
    public void test(double number, double expectedResult) {
        //given
        var calculator = new Calculator();

        //when
        var result = calculator.func(number);

        //then
        assertEquals("not expected result", expectedResult, result);
    }
}