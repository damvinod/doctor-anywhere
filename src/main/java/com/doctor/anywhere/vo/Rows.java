package com.doctor.anywhere.vo;

public class Rows {

  private Long patientId;
  private String patientFirstName;
  private String patientLastName;
  private String contactNumber;
  private String patientStatus;

  public String getContactNumber() {
    return contactNumber;
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
  public String getPatientStatus() {
    return patientStatus;
  }
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
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
  public void setPatientStatus(String patientStatus) {
    this.patientStatus = patientStatus;
  }

}
