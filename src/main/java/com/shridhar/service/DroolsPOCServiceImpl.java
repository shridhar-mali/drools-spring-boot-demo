package com.shridhar.service;

import com.shridhar.model.Applicant;
import com.shridhar.model.CreditRiskReport;
import com.shridhar.model.Request;
import com.shridhar.model.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroolsPOCServiceImpl implements DroolsPOCService {
    public static final Logger LOGGER = LogManager.getLogger(DroolsPOCService.class);
    private final KieContainer kieContainer;

    public DroolsPOCServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public Response getSimpleResponse(Request request) {
        LOGGER.info("request: {}", request);
        Response response = new Response();
        KieSession kieSession = kieContainer.newKieSession();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("simpleObject").setFocus();
        kieSession.setGlobal("logger", LOGGER);
        kieSession.insert(request);
        kieSession.insert(response);
        kieSession.fireAllRules();
        kieSession.dispose();
        LOGGER.info("response: {}", response);
        return response;
    }

    @Override
    public Response getSimpleResponseFromDRL(Request request) {
        LOGGER.info("request: {}", request);
        Response response = new Response();
        KieSession kieSession = kieContainer.newKieSession();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("simpleObject-in-drl").setFocus();
        kieSession.setGlobal("logger", LOGGER);
        kieSession.insert(request);
        kieSession.insert(response);
        kieSession.fireAllRules();
        kieSession.dispose();
        LOGGER.info("response: {}", response);
        return response;
    }

    @Override
    public Response getObjectWithSubObject(Request request) {
        LOGGER.info("request: {}", request);
        Response response = new Response();
        KieSession kieSession = kieContainer.newKieSession();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("objectWithSubObject").setFocus();
        kieSession.setGlobal("logger", LOGGER);
        kieSession.insert(request);
        kieSession.insert(response);
        kieSession.fireAllRules();
        kieSession.dispose();
        LOGGER.info("response: {}", response);
        return response;
    }

    @Override
    public List<Response> getObjectsList(Request request) {
        LOGGER.info("request: {}", request);
        List<Response> responses = new ArrayList<>();
        KieSession kieSession = kieContainer.newKieSession();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("simpleTestList").setFocus();
        kieSession.setGlobal("responses", responses);
        kieSession.setGlobal("logger", LOGGER);
        kieSession.insert(request);
        kieSession.fireAllRules();
        kieSession.dispose();
        LOGGER.info("response: {}", responses);
        return responses;
    }

    @Override
    public CreditRiskReport getApplicantRisk(Applicant applicant) {
        LOGGER.info("applicant: {}", applicant);
        KieSession kieSession = kieContainer.newKieSession();
        CreditRiskReport creditRiskReport = new CreditRiskReport();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("applicantRisk").setFocus();
        kieSession.setGlobal("logger", LOGGER);
        kieSession.insert(applicant);
        kieSession.insert(creditRiskReport);
        kieSession.fireAllRules();
        kieSession.dispose();
        LOGGER.info("creditRiskReport: {}", creditRiskReport);
        return creditRiskReport;
    }
}
