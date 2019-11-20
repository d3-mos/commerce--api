package com.globalhitss.claropay.cercedemi.commerceapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="VIEW_STORES_LOCATION_BRAND")
public class StoreLocation {

  @Id
  @Column(name="ID")
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty(access=Access.READ_ONLY)
  private int    id;
  
  @Column(name="BRAND")
  @JsonIgnore
  private int idBrand;


  @Column(name="STORE")
  private String brand;
  
  @Column(name="ADDRESS")
  private String address;
  
  @Column(name="LATITUDE")
  private double lat;
  
  @Column(name="LONGITUDE")
  private double lng;
  
  @Column(name="PAST_ID")
  private String pastId;
  
  public StoreLocation() {}
  
  public StoreLocation(
    int id,
    String brand, 
    String address, 
    double lat, 
    double lng,
    String pastId
  ) {
    this.id      = id;
    this.brand   = brand;
    this.address = address;
    this.lat     = lat;
    this.lng     = lng;
    this.pastId  = pastId;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getBrand() {
    return brand;
  }
  
  public void setBrand(String brand) {
    this.brand = brand;
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
  
  public int getIdBrand() {
    return idBrand;
  }

  public void setIdBrand(int idBrand) {
    this.idBrand = idBrand;
  }
}
