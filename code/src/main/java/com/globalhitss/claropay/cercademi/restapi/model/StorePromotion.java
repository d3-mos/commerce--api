package com.globalhitss.claropay.cercademi.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="CAT_PROMOTION")
public class StorePromotion 
{
  @Id
  @Column(name="PROMOTION_ID")
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty(access=Access.READ_ONLY)
  private int id;
  
  @Column(name="DESCRIPTION")
  private String description;
  
  @Column(name="LOGO_PATH")
  private String logoPath;
   
  @Column(name="VALIDITY")
  private String validity;
  
  @Column(name="STATUS")
  private String status;
  
  @Column(name="PRIORITY")
  @JsonIgnore
  private int priority;
  
  @ManyToOne
  @JoinColumn(name="STORE_ID", nullable=false)
  @JsonIgnore
  private StoreBrand storeBrand;

  public StorePromotion() {}
  
  public StorePromotion(
    int id, 
    String description, 
    String logoPath,
    String validity, 
    String status,
    int priority
  ) {
      this.id = id;
      this.description = description;
      this.logoPath = logoPath;
      this.validity = validity;
      this.status = status;
      this.priority = priority;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLogoPath() {
    return logoPath;
  }

  public void setLogoPath(String logoPath) {
    this.logoPath = logoPath;
  }

  public String getValidity() {
    return validity;
  }

  public void setValidity(String validity) {
    this.validity = validity;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }
}
