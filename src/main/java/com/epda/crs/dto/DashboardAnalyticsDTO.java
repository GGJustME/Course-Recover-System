package com.epda.crs.dto;

public class DashboardAnalyticsDTO {

    private int totalStudents;
    private int studentsUnderRecovery;
    private int eligibleStudents;
    private int nonEligibleStudents;
    private int activePlans;
    private int overdueMilestones;

    public DashboardAnalyticsDTO() {
    }

    public DashboardAnalyticsDTO(int totalStudents, int studentsUnderRecovery,
                                  int eligibleStudents, int nonEligibleStudents,
                                  int activePlans, int overdueMilestones) {
        this.totalStudents        = totalStudents;
        this.studentsUnderRecovery = studentsUnderRecovery;
        this.eligibleStudents     = eligibleStudents;
        this.nonEligibleStudents  = nonEligibleStudents;
        this.activePlans          = activePlans;
        this.overdueMilestones    = overdueMilestones;
    }

    public int getTotalStudents() { return totalStudents; }
    public void setTotalStudents(int totalStudents) { this.totalStudents = totalStudents; }

    public int getStudentsUnderRecovery() { return studentsUnderRecovery; }
    public void setStudentsUnderRecovery(int studentsUnderRecovery) { this.studentsUnderRecovery = studentsUnderRecovery; }

    public int getEligibleStudents() { return eligibleStudents; }
    public void setEligibleStudents(int eligibleStudents) { this.eligibleStudents = eligibleStudents; }

    public int getNonEligibleStudents() { return nonEligibleStudents; }
    public void setNonEligibleStudents(int nonEligibleStudents) { this.nonEligibleStudents = nonEligibleStudents; }

    public int getActivePlans() { return activePlans; }
    public void setActivePlans(int activePlans) { this.activePlans = activePlans; }

    public int getOverdueMilestones() { return overdueMilestones; }
    public void setOverdueMilestones(int overdueMilestones) { this.overdueMilestones = overdueMilestones; }
}
