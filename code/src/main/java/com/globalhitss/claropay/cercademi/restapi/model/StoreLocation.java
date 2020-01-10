package com.globalhitss.claropay.cercademi.restapi.model;

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
  
  @Column(name="BRAND_ID")
  @JsonIgnore
  private int idBrand;

  @Column(name="BRAND_TOKEN")
  private String brandToken;
  
  @Column(name="ADDRESS")
  private String address;
  
  @Column(name="LATITUDE")
  private double lat;
  
  @Column(name="LONGITUDE")
  private double lng;
  
  @Column(name="PAST_ID")
  @JsonIgnore
  private String pastId;
  
  @Column(name="LAT_KM_CUAD")
  @JsonIgnore
  private double latKm;
  
  @Column(name="LNG_KM_CUAD")//vRadius
  @JsonIgnore
  private double lngKm;
  
  public StoreLocation() {}
  
  public StoreLocation(
    int id,
    String brandToken, 
    String address, 
    double lat, 
    double lng,
    String pastId,
    double latKm,
    double lngKm
  ) {
    this.id         = id;
    this.brandToken = brandToken;
    this.address    = address;
    this.lat        = lat;
    this.lng        = lng;
    this.pastId     = pastId;
    this.latKm      = latKm;
    this.lngKm      = lngKm;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getBrandToken() {
    return brandToken;
  }
  
  public void setBrandToken(String brandToken) {
    this.brandToken = brandToken;
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
  
  public double getLatKm() {
    return latKm;
  }
  
  public void setLatKm(double latKm) {
    this.latKm = latKm;
  }
  
  public double getLngKm() {
    return lngKm;
  }
  
  public void setLngKm(double lngKm) {
    this.lngKm = lngKm;
  }
}
