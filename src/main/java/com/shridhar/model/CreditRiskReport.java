package com.shridhar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreditRiskReport {
    @JsonIgnore
    private int score;

    @JsonIgnore
    private int weight;
    @JsonIgnore
    private int totalApplicantScore;
    @JsonIgnore
    private int totalApplicantWeight;
    @JsonIgnore
    private double applicantCreditScore;
    @JsonIgnore
    private int totalAssetScore;
    @JsonIgnore
    private int totalAssetWeight;
    @JsonIgnore
    private double assetCreditScore;
    @JsonIgnore
    private int totalApplicationScore;
    @JsonIgnore
    private int totalApplicationWeight;
    @JsonIgnore
    private double applicationCreditScore;
    private String riskClassification;
    private double creditScore;
}