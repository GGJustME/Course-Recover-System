package com.epda.crs.model;

import com.epda.crs.enums.RecoveryStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecoveryPlan {

    private Long id;
    private Student student;
    private Course course;
    private String recommendation;
    private RecoveryStatus status;
    private int attemptNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Milestone> milestones = new ArrayList<>();

    public RecoveryPlan() {
    }

    public RecoveryPlan(Long id, Student student, Course course, String recommendation,
                        RecoveryStatus status, LocalDate startDate, LocalDate endDate) {
        this.id             = id;
        this.student        = student;
        this.course         = course;
        this.recommendation = recommendation;
        this.status         = status;
        this.startDate      = startDate;
        this.endDate        = endDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }

    public RecoveryStatus getStatus() { return status; }
    public void setStatus(RecoveryStatus status) { this.status = status; }

    public int getAttemptNumber() { return attemptNumber; }
    public void setAttemptNumber(int attemptNumber) { this.attemptNumber = attemptNumber; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public List<Milestone> getMilestones() { return milestones; }
    public void setMilestones(List<Milestone> milestones) { this.milestones = milestones; }
}
