package com.epda.crs.util;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CGPACalculatorTest {
    @Test
    void calculateReturnsWeightedAverage() {
        double cgpa = CGPACalculator.calculate(Arrays.asList(4.0, 3.0, 2.0), Arrays.asList(3, 4, 2));
        Assertions.assertEquals(3.11, cgpa, 0.01);
    }
}
