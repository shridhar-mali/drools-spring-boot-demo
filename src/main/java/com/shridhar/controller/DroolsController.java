package com.shridhar.controller;

import com.shridhar.model.Applicant;
import com.shridhar.model.CreditRiskReport;
import com.shridhar.model.Request;
import com.shridhar.model.Response;
import com.shridhar.service.DroolsPOCService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/v1/drools")
public class DroolsController {
    private final DroolsPOCService droolsPOCService;

    public DroolsController(DroolsPOCService droolsPOCService) {
        this.droolsPOCService = droolsPOCService;
    }

    @PostMapping("/simple-object-from-drl")
    public ResponseEntity<Response> getSimpleResponseFromDRL(@RequestBody Request request) {
        Response response = droolsPOCService.getSimpleResponseFromDRL(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/simple-object")
    public ResponseEntity<Response> getSimpleResponse(@RequestBody Request request) {
        Response response = droolsPOCService.getSimpleResponse(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/applicant-risk")
    public ResponseEntity<CreditRiskReport> getApplicantRisk(@RequestBody Applicant applicant) {
        CreditRiskReport creditRiskReport = droolsPOCService.getApplicantRisk(applicant);
        return new ResponseEntity<>(creditRiskReport, HttpStatus.OK);
    }

    @PostMapping("/object-with-sub-object")
    public ResponseEntity<Response> getObjectWithSubObject(@RequestBody Request request) {
        Response response = droolsPOCService.getObjectWithSubObject(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/object-list")
    public ResponseEntity<List<Response>> getObjectsList(@RequestBody Request request) {
        var responses = droolsPOCService.getObjectsList(request);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
