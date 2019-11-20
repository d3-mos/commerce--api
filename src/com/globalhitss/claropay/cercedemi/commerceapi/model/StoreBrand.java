package com.globalhitss.claropay.cercedemi.commerceapi.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="CAT_STORE")
public class StoreBrand 
{

  @Id
  @Column(name="STORE_ID")
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty(access=Access.READ_ONLY)
  private int    id;
  
  @Column(name="STORE")
  private String brand;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "CAT_STORE_OPERATION_BY_BRAND", 
    joinColumns = { @JoinColumn(name = "BRAND_ID") }, 
    inverseJoinColumns = { @JoinColumn(name = "OPERATION_ID") }
  )
  @JsonIgnore
  Set<StoreOperation> operations = new HashSet<StoreOperation>();
  
  @OneToMany(mappedBy="storeBrand")
  Set<StorePromotion> promotions = new HashSet<StorePromotion>();
  
  @Transient
  @JsonProperty(access=Access.READ_ONLY)
  private List<String> tokenOperations; 

  public int getId() {
    return id;
  }

  public StoreBrand() {}
  
  public StoreBrand(int id, String brand) {
    this.id = id;
    this.brand = brand;
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

  public Set<StoreOperation> getOperations() {
    tokenOperations = operations
      .stream()
      .map( operation -> operation.getOperationKey() )
      .collect(Collectors.toList());
    
    return operations;
  }

  public void setOperations(Set<StoreOperation> operations) {
    this.operations = operations;
  }

  public List<String> getTokenOperations() {
    return tokenOperations;
  }

  public void setTokenOperations(List<String> tokenOperations) {
    this.tokenOperations = tokenOperations;
  }
  
  public Set<StorePromotion> getPromotions() {
    return promotions;
  }

  public void setPromotions(Set<StorePromotion> promotions) {
    this.promotions = promotions;
  }
}
