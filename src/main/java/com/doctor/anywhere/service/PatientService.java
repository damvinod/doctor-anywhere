package com.doctor.anywhere.service;

import org.springframework.util.MultiValueMap;
import com.doctor.anywhere.vo.PatientData;
import com.doctor.anywhere.vo.PatientVo;

public interface PatientService {

  public void deletePatient(Long patientId) throws Exception;

  public PatientData getPatientDetails(MultiValueMap<String, String> formData) throws Exception;

  public void inactivePatient(Long valueOf) throws Exception;

  public Long savePatient(PatientVo patientVo) throws Exception;

}
