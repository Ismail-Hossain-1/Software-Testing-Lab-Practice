package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator= new Calculator();
        assertEquals(5, calculator.add(0, 3));
    }

    @Test
    void sub() {
    }
    @Test
    void divide(){
        Calculator calculator= new Calculator();
        assertEquals(1, calculator.divide(3, 0));
    }
}