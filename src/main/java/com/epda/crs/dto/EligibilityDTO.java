package com.epda.crs.dto;

public class EligibilityDTO {

    private int studentId;
    private String studentCode;
    private String studentName;
    private double cgpa;
    private int failedCourseCount;
    private boolean eligible;
    private String reason;
    private int semester;
    private int yearOfStudy;

    public EligibilityDTO() {
    }

    public EligibilityDTO(int studentId, String studentCode, String studentName,
                          double cgpa, int failedCourseCount,
                          boolean eligible, String reason) {
        this.studentId        = studentId;
        this.studentCode      = studentCode;
        this.studentName      = studentName;
        this.cgpa             = cgpa;
        this.failedCourseCount = failedCourseCount;
        this.eligible         = eligible;
        this.reason           = reason;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudentCode() { return studentCode; }
    public void setStudentCode(String studentCode) { this.studentCode = studentCode; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    public int getFailedCourseCount() { return failedCourseCount; }
    public void setFailedCourseCount(int failedCourseCount) { this.failedCourseCount = failedCourseCount; }

    public boolean isEligible() { return eligible; }
    public void setEligible(boolean eligible) { this.eligible = eligible; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public int getYearOfStudy() { return yearOfStudy; }
    public void setYearOfStudy(int yearOfStudy) { this.yearOfStudy = yearOfStudy; }

    // Alias expected by design spec (field stored as failedCourseCount internally)
    public int getFailedCourses() { return failedCourseCount; }
    public void setFailedCourses(int failedCourses) { this.failedCourseCount = failedCourses; }
}
