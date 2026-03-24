package com.epda.crs.bean;

import com.epda.crs.enums.RecoveryStatus;
import com.epda.crs.exception.ValidationException;
import com.epda.crs.model.RecoveryPlan;
import com.epda.crs.model.RecoveryRecommendation;
import com.epda.crs.service.RecoveryService;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class RecoveryBean implements Serializable {

    @EJB
    private RecoveryService recoveryService;

    private List<RecoveryPlan> recoveryPlans;
    private RecoveryPlan selectedPlan;
    private int selectedStudentId;
    private int selectedCourseId;
    private RecoveryRecommendation newRecommendation = new RecoveryRecommendation();
    private List<RecoveryRecommendation> recommendations = new ArrayList<>();

    // -----------------------------------------------------------------------
    // Actions
    // -----------------------------------------------------------------------

    public void loadAllPlans() {
        try {
            recoveryPlans = recoveryService.findAll();
        } catch (ValidationException e) {
            addError("Load Plans", e.getMessage());
        } catch (Exception e) {
            addError("Load Plans", "An unexpected error occurred");
        }
    }

    public void loadPlansByStudent() {
        try {
            recoveryPlans = recoveryService.findByStudentId(selectedStudentId);
        } catch (ValidationException e) {
            addError("Load Plans", e.getMessage());
        } catch (Exception e) {
            addError("Load Plans", "An unexpected error occurred");
        }
    }

    public void createPlan() {
        try {
            recoveryService.createPlan(selectedStudentId, selectedCourseId, 0);
            loadAllPlans();
            addInfo("Recovery Plan", "Recovery plan created successfully");
        } catch (ValidationException e) {
            addError("Recovery Plan", e.getMessage());
        } catch (Exception e) {
            addError("Recovery Plan", "An unexpected error occurred");
        }
    }

    public void updatePlanStatus(int planId, RecoveryStatus status) {
        try {
            recoveryService.updateStatus(planId, status);
            loadAllPlans();
            addInfo("Recovery Plan", "Plan status updated successfully");
        } catch (ValidationException e) {
            addError("Recovery Plan", e.getMessage());
        } catch (Exception e) {
            addError("Recovery Plan", "An unexpected error occurred");
        }
    }

    public void addRecommendation() {
        if (selectedPlan == null) return;
        try {
            newRecommendation.setPlanId(selectedPlan.getId());
            recoveryService.addRecommendation(newRecommendation);
            newRecommendation = new RecoveryRecommendation();
            refreshRecommendations();
            addInfo("Recommendation", "Recommendation added successfully");
        } catch (ValidationException e) {
            addError("Recommendation", e.getMessage());
        } catch (Exception e) {
            addError("Recommendation", "An unexpected error occurred");
        }
    }

    public void deleteRecommendation(long recId) {
        if (selectedPlan == null) return;
        try {
            recoveryService.deleteRecommendation(recId);
            refreshRecommendations();
            addInfo("Recommendation", "Recommendation deleted successfully");
        } catch (ValidationException e) {
            addError("Recommendation", e.getMessage());
        } catch (Exception e) {
            addError("Recommendation", "An unexpected error occurred");
        }
    }

    public void prepareNewPlan() {
        selectedStudentId = 0;
        selectedCourseId  = 0;
        newRecommendation = new RecoveryRecommendation();
    }

    // -----------------------------------------------------------------------
    // Getters and setters
    // -----------------------------------------------------------------------

    public List<RecoveryPlan> getRecoveryPlans() { return recoveryPlans; }
    public void setRecoveryPlans(List<RecoveryPlan> recoveryPlans) { this.recoveryPlans = recoveryPlans; }

    public RecoveryPlan getSelectedPlan() { return selectedPlan; }
    public void setSelectedPlan(RecoveryPlan selectedPlan) {
        this.selectedPlan = selectedPlan;
        refreshRecommendations();
    }

    public int getSelectedStudentId() { return selectedStudentId; }
    public void setSelectedStudentId(int selectedStudentId) { this.selectedStudentId = selectedStudentId; }

    public int getSelectedCourseId() { return selectedCourseId; }
    public void setSelectedCourseId(int selectedCourseId) { this.selectedCourseId = selectedCourseId; }

    public RecoveryRecommendation getNewRecommendation() { return newRecommendation; }
    public void setNewRecommendation(RecoveryRecommendation newRecommendation) { this.newRecommendation = newRecommendation; }

    public List<RecoveryRecommendation> getRecommendations() { return recommendations; }
    public void setRecommendations(List<RecoveryRecommendation> recommendations) { this.recommendations = recommendations; }

    // -----------------------------------------------------------------------
    // Private helpers
    // -----------------------------------------------------------------------

    private void refreshRecommendations() {
        if (selectedPlan != null) {
            try {
                recommendations = recoveryService.getRecommendations(
                        selectedPlan.getId().intValue());
            } catch (Exception e) {
                recommendations = new ArrayList<>();
            }
        } else {
            recommendations = new ArrayList<>();
        }
    }

    private void addInfo(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }

    private void addError(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }
}
