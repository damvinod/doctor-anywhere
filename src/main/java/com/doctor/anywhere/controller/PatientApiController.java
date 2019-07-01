package com.doctor.anywhere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.doctor.anywhere.service.PatientService;

@RestController
public class PatientApiController {

  @Autowired
  private PatientService patientService;

  @RequestMapping(path = "/sg/v1/patient/{patientId}", method = RequestMethod.DELETE)
  public void deletePatient(@PathVariable String patientId) throws Exception {
    patientService.deletePatient(Long.valueOf(patientId.trim()));
  }

  @RequestMapping(path = "/sg/v1/patient/inactive/{patientId}", method = RequestMethod.DELETE)
  public void inactivePatient(@PathVariable String patientId) throws Exception {
    patientService.inactivePatient(Long.valueOf(patientId.trim()));
  }
}
