package com.doctor.anywhere.to;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "PATIENT")
@SequenceGenerator(
    name = "PATIENT_GENERATOR",
    sequenceName = "PATIENT_SEQ",
    initialValue = 1, allocationSize = 1)
public class Patient {

  @Id
  @Column(name = "PATIENT_ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_GENERATOR")
  private Long patientId;

  @Column(name = "PATIENT_FIRST_NAME")
  private String patientFirstName;

  @Column(name = "PATIENT_LAST_NAME")
  private String patientLastName;

  @Column(name = "CONTACT_NUMBER")
  private Long contactNumber;

  @OneToMany(cascade = CascadeType.ALL, mappedBy= "patient", targetEntity = Address.class)
  private List<Address> address = new LinkedList<>();

  @Column(name = "ACTIVE_FLAG")
  private String activeFlag;

  @Column(name = "MODIFIED_TS")
  private Timestamp modifiedTs;

  @Column(name = "CREATED_TS")
  private Timestamp createdTs;

  public String getActiveFlag() {
    return activeFlag;
  }

  public List<Address> getAddress() {
    return address;
  }

  public Long getContactNumber() {
    return contactNumber;
  }

  public Timestamp getCreatedTs() {
    return createdTs;
  }

  public Timestamp getModifiedTs() {
    return modifiedTs;
  }

  public String getPatientFirstName() {
    return patientFirstName;
  }

  public Long getPatientId() {
    return patientId;
  }

  public String getPatientLastName() {
    return patientLastName;
  }

  public void setActiveFlag(String activeFlag) {
    this.activeFlag = activeFlag;
  }

  public void setAddress(List<Address> address) {
    this.address = address;
  }

  public void setContactNumber(Long contactNumber) {
    this.contactNumber = contactNumber;
  }

  public void setCreatedTs(Timestamp createdTs) {
    this.createdTs = createdTs;
  }

  public void setModifiedTs(Timestamp modifiedTs) {
    this.modifiedTs = modifiedTs;
  }

  public void setPatientFirstName(String patientFirstName) {
    this.patientFirstName = patientFirstName;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public void setPatientLastName(String patientLastName) {
    this.patientLastName = patientLastName;
  }

}
