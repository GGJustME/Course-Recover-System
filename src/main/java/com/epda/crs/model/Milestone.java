package com.epda.crs.model;

import com.epda.crs.enums.MilestoneStatus;
import java.time.LocalDate;

public class Milestone {

    private Long id;
    private Long recoveryPlanId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private MilestoneStatus status;

    public Milestone() {
    }

    public Milestone(Long id, Long recoveryPlanId, String title, String description,
                     LocalDate dueDate, MilestoneStatus status) {
        this.id             = id;
        this.recoveryPlanId = recoveryPlanId;
        this.title          = title;
        this.description    = description;
        this.dueDate        = dueDate;
        this.status         = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRecoveryPlanId() { return recoveryPlanId; }
    public void setRecoveryPlanId(Long recoveryPlanId) { this.recoveryPlanId = recoveryPlanId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public MilestoneStatus getStatus() { return status; }
    public void setStatus(MilestoneStatus status) { this.status = status; }
}
