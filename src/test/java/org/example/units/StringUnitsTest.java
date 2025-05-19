package org.example.units;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUnitsTest {

    @ParameterizedTest
    @ValueSource(strings = {"clc", "clock", "pallindrome"})
    @DisplayName("Pallindrome")
    void isPallindrome(String word) {
        assertTrue(StringUnits.isPallindrome(word));
    }
    @ParameterizedTest
    @CsvSource({"clc, true", "clock, false"})
    @DisplayName("Pallindrome With expected Result")
    void isPallindromeWithExpectedResult(String string, boolean expectedResult){
        assertEquals(expectedResult, StringUnits.isPallindrome(string));
    }

    @Test
    @Disabled
    void containsSubstr() {
    }
}