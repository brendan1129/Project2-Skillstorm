package com.skillstorm.group8.taxprep.models;

public enum MaritalStatus {
    SINGLE("Single"),
    MARRIED_FILING_JOINTLY("Married Filing Jointly"),
    MARRIED_FILING_SEPARATELY("Married Filing Separately"),
    HEAD_OF_HOUSEHOLD("Head of Household");
    
    private String status;

    MaritalStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
