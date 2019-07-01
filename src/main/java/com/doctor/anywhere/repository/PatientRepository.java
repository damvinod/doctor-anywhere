package com.doctor.anywhere.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.doctor.anywhere.to.Patient;

@Repository
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long> {

  List<Patient> findAllByActiveFlag(String activeFlag);

  Patient findByPatientId(Long patientId);
}
