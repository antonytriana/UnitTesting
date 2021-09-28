package com.antony.unittesting;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Antony
 */
public class CalculadoraTest {

    static Calculadora calc;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll()");
        calc = new Calculadora();
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach()");
        calc.clear();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach()");
    }

    @Test
    public void testCalculadoraSuma() {
        System.out.println("testCalculadoraSuma()");
        int resultado = calc.add(8, 2);
        int esperado = 10;
        assertEquals(esperado, resultado);

    }

    @Test
    public void testCalculadoraAnsSuma() {
        System.out.println("testCalculadoraAnsSuma()");
        calc.add(3, 2);
        int resultado = calc.ans();
        int esperado = 5;
        assertEquals(esperado, resultado);
    }

    @Test
    public void testCalculadoraResta() {
        System.out.println("testCalculadoraResta()");
        int resultado = calc.sub(5, 3);
        int esperado = 2;
        assertEquals(esperado, resultado);
    }

    @Test
    public void testCalculadoraDividir() {
        System.out.println("testCalculadoraDividir()");
        calc.div(5, 2);
    }

    @Test
    public void testCalculadoraDividirPorCero() {
        System.out.println("testCalculadoraDividirPorCero()");
        assertThrows(ArithmeticException.class, () -> {
            calc.div(5, 0);
        });
    }

    @ParameterizedTest
    @CsvSource({"3,1,4", "2,3,5", "3,3,6"})
    public void testCalculadoraSumaVariadas(int a, int b, int expected) {
        System.out.println("testCalculadoraSumaVariadas()");
        assertEquals(expected, calc.add(a, b));
    }
}
