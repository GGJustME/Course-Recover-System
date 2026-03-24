package com.epda.crs.model;

import java.time.LocalDateTime;

public class RecoveryRecommendation {

    private Long id;
    private Long planId;
    private String recommendation;
    private Long addedBy;
    private LocalDateTime addedAt;

    public RecoveryRecommendation() {
    }

    public RecoveryRecommendation(Long id, Long planId, String recommendation,
                                  Long addedBy, LocalDateTime addedAt) {
        this.id             = id;
        this.planId         = planId;
        this.recommendation = recommendation;
        this.addedBy        = addedBy;
        this.addedAt        = addedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlanId() { return planId; }
    public void setPlanId(Long planId) { this.planId = planId; }

    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }

    public Long getAddedBy() { return addedBy; }
    public void setAddedBy(Long addedBy) { this.addedBy = addedBy; }

    public LocalDateTime getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDateTime addedAt) { this.addedAt = addedAt; }
}
