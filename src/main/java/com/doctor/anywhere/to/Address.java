package com.doctor.anywhere.to;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "ADDRESS")
@SequenceGenerator(
    name = "ADDRESS_GENERATOR",
    sequenceName = "ADDRESS_SEQ",
    initialValue = 1, allocationSize = 1)
public class Address {

  @Id
  @Column(name = "ADDRESS_ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_GENERATOR")
  private Long addressId;

  @ManyToOne
  @JoinColumn(name ="PATIENT_ID")
  private Patient patient;

  @Column(name = "ADDRESS_LINE_1")
  private String addressLine1;

  @Column(name = "ADDRESS_LINE_2")
  private String addressLine2;

  @Column(name = "CITY")
  private String city;

  @Column(name = "COUNTRY")
  private String country;

  @Column(name = "POSTAL_CODE")
  private String postalCode;

  @Column(name = "ACTIVE_FLAG")
  private String activeFlag;

  @Column(name = "MODIFIED_TS")
  private Timestamp modifiedTs;

  @Column(name = "CREATED_TS")
  private Timestamp createdTs;

  public String getActiveFlag() {
    return activeFlag;
  }

  public Long getAddressId() {
    return addressId;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public Timestamp getCreatedTs() {
    return createdTs;
  }

  public Timestamp getModifiedTs() {
    return modifiedTs;
  }

  public Patient getPatient() {
    return patient;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setActiveFlag(String activeFlag) {
    this.activeFlag = activeFlag;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setCreatedTs(Timestamp createdTs) {
    this.createdTs = createdTs;
  }

  public void setModifiedTs(Timestamp modifiedTs) {
    this.modifiedTs = modifiedTs;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
        + ", city=" + city + ", country=" + country + ", postalCode=" + postalCode + ", activeFlag="
        + activeFlag + ", modifiedTs=" + modifiedTs + ", createdTs=" + createdTs + "]";
  }


}

