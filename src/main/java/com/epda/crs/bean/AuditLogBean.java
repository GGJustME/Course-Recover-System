package com.epda.crs.bean;

import com.epda.crs.model.AuditLog;
import com.epda.crs.service.AuditLogService;
import java.io.Serializable;
import java.util.List;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class AuditLogBean implements Serializable {
    private final AuditLogService auditLogService = new AuditLogService();

    public List<AuditLog> getAuditLogs() { return auditLogService.getAuditLogs(); }
}
