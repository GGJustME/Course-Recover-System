package com.epda.crs.service;

import com.epda.crs.dao.StudentDAO;
import com.epda.crs.dto.DashboardAnalyticsDTO;
import com.epda.crs.model.RecoveryPlan;
import java.util.List;
import jakarta.ejb.Stateless;

@Stateless
public class DashboardService {
    private final RecoveryService recoveryService = new RecoveryService();
    private final EligibilityService eligibilityService = new EligibilityService();
    private final RecoveryRuleService recoveryRuleService = new RecoveryRuleService();
    private final StudentDAO studentDAO = new StudentDAO();

    public DashboardAnalyticsDTO getAnalytics() {
        List<RecoveryPlan> plans = recoveryService.getRecoveryPlans();
        DashboardAnalyticsDTO dto = new DashboardAnalyticsDTO();
        dto.setStudentsUnderRecovery((int) plans.stream().map(RecoveryPlan::getStudent).distinct().count());
        dto.setActivePlans((int) plans.stream().filter(recoveryRuleService::isPlanActive).count());
        dto.setOverdueMilestones((int) plans.stream().flatMap(plan -> plan.getMilestones().stream()).filter(recoveryRuleService::isMilestoneOverdue).count());
        dto.setEligibleStudents((int) studentDAO.findAll().stream().filter(eligibilityService::isEligible).count());
        dto.setNonEligibleStudents(studentDAO.findAll().size() - dto.getEligibleStudents());
        return dto;
    }
}
