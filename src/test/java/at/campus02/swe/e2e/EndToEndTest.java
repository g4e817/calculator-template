package at.campus02.swe.e2e;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;

public class EndToEndTest {

    @Test
    public void testAddThenMultiply() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: (3 + 4) * 5 = 35
        double result = parser.parse(new File("src/test/resources/e2e01.xml"));

        //verify
        assertEquals(35, result, 0);
    }

    @Test
    public void testSubtractDivideModulo() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: ((20 - 8) / 4) % 2 = 3 % 2 = 1
        double result = parser.parse(new File("src/test/resources/e2e02.xml"));

        //verify
        assertEquals(1, result, 0);
    }

    @Test(expected = CalculatorException.class)
    public void testDivisionByZero() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);

        //execute: 9 / 0 -> CalculatorException
        parser.parse(new File("src/test/resources/e2e03.xml"));
    }
}
