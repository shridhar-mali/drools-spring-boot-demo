package com.shridhar.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Applicant {
    private Integer age;
    private Residence residence;
    private Integer repaymentPeriod;
    private Integer margin;
    private Long assetCost;
    private AssetSubType assetSubType;
    private boolean hasGuarantor;
}
