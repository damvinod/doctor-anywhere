package com.doctor.anywhere.serviceImpl;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import com.doctor.anywhere.repository.PatientRepository;
import com.doctor.anywhere.service.PatientService;
import com.doctor.anywhere.to.Address;
import com.doctor.anywhere.to.Patient;
import com.doctor.anywhere.vo.PatientData;
import com.doctor.anywhere.vo.PatientVo;
import com.doctor.anywhere.vo.Rows;

@Service
public class PatientServiceImpl implements PatientService {

  private static final String ROW_COUNT = "rowCount";
  private static final String CURRENT = "current";
  private static final String SORT_PATIENT_FIRST_NAME = "sort[patientFirstName]";
  private static final String ASC = "asc";
  private static final String PATIENT_FIRST_NAME = "patientFirstName";
  private static final String N = "N";
  private static final String IN_ACTIVE = "InActive";
  private static final String ACTIVE = "Active";
  private static final String Y = "Y";

  @Autowired
  private PatientRepository patientRepository;

  private void createAddress(PatientVo patientVo, int i, Address address) throws Exception {
    address.setAddressLine1(patientVo.getAddressLine1().get(i));
    address.setAddressLine2(patientVo.getAddressLine2().get(i));
    address.setCity(patientVo.getCity().get(i));
    address.setCountry(patientVo.getCountry().get(i));
    address.setPostalCode(patientVo.getPostalCode().get(i));

    address.setActiveFlag(Y);
    address.setCreatedTs(createTimestamp());
    address.setModifiedTs(createTimestamp());
  }

  private void createGridRows(Patient patient, Rows rows) throws Exception {
    rows.setPatientId(patient.getPatientId());
    rows.setPatientFirstName(patient.getPatientFirstName());
    rows.setPatientLastName(patient.getPatientLastName());
    rows.setContactNumber(patient.getContactNumber().toString());
    rows.setPatientStatus(patient.getActiveFlag().equals(Y) ? ACTIVE : IN_ACTIVE);
  }

  private void createPatient(PatientVo patientVo, Patient patient) throws Exception {
    patient.setPatientFirstName(patientVo.getPatientFirstName().toUpperCase());
    patient.setPatientLastName(patientVo.getPatientLastName().toUpperCase());
    patient.setContactNumber(patientVo.getContactNumber());
    patient.setActiveFlag(Y);
    patient.setCreatedTs(createTimestamp());
    patient.setModifiedTs(createTimestamp());
  }

  private Timestamp createTimestamp() throws Exception {
    return new Timestamp(System.currentTimeMillis());
  }

  @Override
  public void deletePatient(Long patientId) throws Exception {
    patientRepository.deleteById(patientId);
  }

  @Override
  public PatientData getPatientDetails(MultiValueMap<String, String> formData) throws Exception {

    String sort = formData.containsKey(SORT_PATIENT_FIRST_NAME) ? formData.get(SORT_PATIENT_FIRST_NAME).get(0) : "";
    int current = Integer.valueOf(formData.get(CURRENT).get(0));
    int rowCount = Integer.valueOf(formData.get(ROW_COUNT).get(0));

    Pageable pageable = PageRequest.of(current - 1, rowCount,
        Sort.by(sort.equals(ASC) ? Direction.ASC : Direction.DESC, PATIENT_FIRST_NAME));

    Page<Patient> page = patientRepository.findAll(pageable);

    PatientData patientData = new PatientData();
    patientData.setCurrent(current);
    patientData.setRowCount(rowCount);
    patientData.setTotal(page.getTotalElements());

    for (Patient patient : page.getContent()) {
      Rows rows = new Rows();
      patientData.getRows().add(rows);

      createGridRows(patient, rows);
    }

    return patientData;
  }

  @Override
  public void inactivePatient(Long patientId) throws Exception {
    Patient patient = patientRepository.findById(patientId).orElse(null);

    if (patient != null) {
      patient.setActiveFlag(N);
      patient.setModifiedTs(createTimestamp());
      patientRepository.save(patient);
    }
  }

  @Override
  public Long savePatient(PatientVo patientVo) throws Exception {
    Patient patient = new Patient();

    createPatient(patientVo, patient);
    for (int i = 0; i < patientVo.getAddressLine1().size(); i++) {

      Address address = new Address();
      patient.getAddress().add(address);
      address.setPatient(patient);

      createAddress(patientVo, i, address);
    }

    patientRepository.save(patient);

    return patient.getPatientId();
  }
}
