package com.doctor.anywhere.vo;

import java.util.List;

public class PatientVo {

  private String patientFirstName;
  private String patientLastName;
  private Long contactNumber;

  private List<String> addressLine1;
  private List<String> addressLine2;
  private List<String> city;
  private List<String> country;
  private List<String> postalCode;

  public List<String> getAddressLine1() {
    return addressLine1;
  }

  public List<String> getAddressLine2() {
    return addressLine2;
  }

  public List<String> getCity() {
    return city;
  }

  public Long getContactNumber() {
    return contactNumber;
  }

  public List<String> getCountry() {
    return country;
  }

  public String getPatientFirstName() {
    return patientFirstName;
  }

  public String getPatientLastName() {
    return patientLastName;
  }

  public List<String> getPostalCode() {
    return postalCode;
  }

  public void setAddressLine1(List<String> addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public void setAddressLine2(List<String> addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public void setCity(List<String> city) {
    this.city = city;
  }

  public void setContactNumber(Long contactNumber) {
    this.contactNumber = contactNumber;
  }

  public void setCountry(List<String> country) {
    this.country = country;
  }

  public void setPatientFirstName(String patientFirstName) {
    this.patientFirstName = patientFirstName;
  }

  public void setPatientLastName(String patientLastName) {
    this.patientLastName = patientLastName;
  }

  public void setPostalCode(List<String> postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "PatientVo [patientFirstName=" + patientFirstName + ", patientLastName="
        + patientLastName + ", contactNumber=" + contactNumber + ", addressLine1=" + addressLine1
        + ", addressLine2=" + addressLine2 + ", city=" + city + ", country=" + country
        + ", postalCode=" + postalCode + "]";
  }
}

