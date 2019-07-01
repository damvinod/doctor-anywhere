package com.doctor.anywhere.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.doctor.anywhere.service.PatientService;
import com.doctor.anywhere.vo.PatientData;
import com.doctor.anywhere.vo.PatientVo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PatientController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

  @Autowired
  private PatientService patientService;

  @RequestMapping(path = "/addNewPatient", method = RequestMethod.POST)
  public @ResponseBody Long addItems(@RequestParam("patientData") String patientData,
      HttpServletRequest request) throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    LOGGER.info("patientData..." + patientData);
    PatientVo patientVo = mapper.readValue(patientData, PatientVo.class);

    Long id = patientService.savePatient(patientVo);

    return id;
  }

  @PostMapping(path = "/getAllPatient", produces = "application/json; charset=utf-8",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public @ResponseBody PatientData getAllPatient(
      @RequestBody MultiValueMap<String, String> formData) throws Exception {

    LOGGER.info("Form Data:" + formData);
    return patientService.getPatientDetails(formData);
  }

  @RequestMapping("/home")
  public ModelAndView home(Map<String, Object> model) {
    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("patient");
    return modelAndView;
  }

  @RequestMapping("/")
  public ModelAndView login(Map<String, Object> model) {
    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("login");
    return modelAndView;
  }
}
