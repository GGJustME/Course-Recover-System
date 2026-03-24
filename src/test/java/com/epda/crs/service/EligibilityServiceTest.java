package com.epda.crs.service;

import com.epda.crs.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EligibilityServiceTest {
    private final EligibilityService eligibilityService = new EligibilityService();

    @Test
    void studentIsEligibleWhenCgpaAndFailedCoursesMeetRule() {
        Student student = new Student(1L, "S1", "Demo Student", "BCS", 1, 1, 2.5, 2);
        Assertions.assertTrue(eligibilityService.isEligible(student));
    }

    @Test
    void studentIsNotEligibleWhenCgpaTooLow() {
        Student student = new Student(1L, "S1", "Demo Student", "BCS", 1, 1, 1.8, 2);
        Assertions.assertFalse(eligibilityService.isEligible(student));
    }
}
