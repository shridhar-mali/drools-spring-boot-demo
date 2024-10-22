package com.shridhar.service;

import com.shridhar.model.Applicant;
import com.shridhar.model.CreditRiskReport;
import com.shridhar.model.Request;
import com.shridhar.model.Response;

import java.util.List;

public interface DroolsPOCService {
    Response getSimpleResponse(Request request);
    Response getSimpleResponseFromDRL(Request request);
    Response getObjectWithSubObject(Request request);
    List<Response> getObjectsList(Request request);
    CreditRiskReport getApplicantRisk(Applicant applicant);
}
