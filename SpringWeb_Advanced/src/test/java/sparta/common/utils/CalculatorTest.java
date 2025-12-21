package sparta.common.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setup() {
        System.out.println("BeforeEach 메서드 실행");
        calculator = new Calculator();
    }
    @AfterEach
    void clear() {
        System.out.println("단일 테스트 끝");
    }

    @Test
    void add() {
        System.out.println("add 메서드 실행");

        // - given
        int num1 = 2;
        int num2 = 3;

        // - when
        int result = calculator.add(num1, num2);

        // - then
        assertEquals(5, result);
    }

    @Test
    void subtract() {
        System.out.println("subtract 메서드 실행");

        int result = calculator.subtract(5, 3);

        assertEquals(2, result);
    }

    @Test
    void divice_success() {
        System.out.println("나누기 성공 케이스 테스트");

        int result = calculator.divide(10, 2);

        assertEquals(5, result);
    }

    @Test
    @DisplayName("나누기 실패 케이스 테스트 - 숫자를 0으로 나눌때")
    void divide_fail() {
        System.out.println("나누기 실패 케이스 테스트");

        assertThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0));

        // - ArithmeticException 발생
//        int result = calculator.divide(10, 0);
//
//        assertEquals(0, result);
    }
}