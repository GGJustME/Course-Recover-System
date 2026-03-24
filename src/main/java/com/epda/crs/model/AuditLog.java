package com.epda.crs.model;

import java.time.LocalDateTime;

public class AuditLog {

    private Long id;
    private String actorUsername;
    private String actionType;
    private String entityName;
    private Long entityId;
    private String details;
    private LocalDateTime createdAt;

    public AuditLog() {
    }

    public AuditLog(Long id, String actorUsername, String actionType, String entityName,
                    Long entityId, String details, LocalDateTime createdAt) {
        this.id            = id;
        this.actorUsername = actorUsername;
        this.actionType    = actionType;
        this.entityName    = entityName;
        this.entityId      = entityId;
        this.details       = details;
        this.createdAt     = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getActorUsername() { return actorUsername; }
    public void setActorUsername(String actorUsername) { this.actorUsername = actorUsername; }

    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }

    public String getEntityName() { return entityName; }
    public void setEntityName(String entityName) { this.entityName = entityName; }

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
