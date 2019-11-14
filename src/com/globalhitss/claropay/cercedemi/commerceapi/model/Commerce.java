package com.globalhitss.claropay.cercedemi.commerceapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="commerce_list")
public class Commerce {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty(access=Access.READ_ONLY)
  private int    id;
  
  @Column(name="species")
  private String species;
  
  @Column(name="class_name")
  private String className;
  
  @Column(name="address")
  private String address;
  
  @Column(name="lat")
  private double lat;
  
  @Column(name="lng")
  private double lng;
  
  @Column(name="past_id")
  private String pastId;
  
  public Commerce() {}
  
  public Commerce(
    int id,
    String species, 
    String className,
    String address, 
    double lat, 
    double lng,
    String pastId
  ) {
      this.id        = id;
      this.species   = species;
      this.className = className;
      this.address   = address;
      this.lat       = lat;
      this.lng       = lng;
      this.pastId    = pastId;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getSpecies() {
    return species;
  }
  
  public void setSpecies(String species) {
    this.species = species;
  }
  
  public String getClassName() {
    return className;
  }
  
  public void setClassName(String className) {
    this.className = className;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public double getLat() {
    return lat;
  }
  
  public void setLat(double lat) {
    this.lat = lat;
  }
  
  public double getLng() {
    return lng;
  }
  
  public void setLng(double lng) {
    this.lng = lng;
  }
  
  public String getPastId() {
    return pastId;
  }
  
  public void setPastId(String pastId) {
    this.pastId = pastId;
  }

}
