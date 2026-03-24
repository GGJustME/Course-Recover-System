package com.epda.crs.util;

import java.util.List;

public final class CGPACalculator {

    // Mirrors the grade_point and credit_hours columns from student_course_results + courses
    public record StudentResult(double gradePoint, int creditHours) {}

    private CGPACalculator() {
    }

    /**
     * CGPA = Σ(gradePoint × creditHours) / Σ(creditHours)
     * Returns 0.0 if the list is null or empty (no results recorded yet).
     */
    public static double calculate(List<StudentResult> results) {
        if (results == null || results.isEmpty()) {
            return 0.0;
        }

        double weightedSum = 0.0;
        int totalCredits   = 0;

        for (StudentResult r : results) {
            weightedSum  += r.gradePoint() * r.creditHours();
            totalCredits += r.creditHours();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return weightedSum / totalCredits;
    }
}
