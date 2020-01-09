package com.globalhitss.claropay.cercademi.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="CAT_STORE_OPERATION")
public class StoreOperation {

  @Id
  @Column(name="ID")
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty(access=Access.READ_ONLY)
  private int    id;
  
  @Column(name="OPERATION_KEY")
  private String operationKey;

  
  public StoreOperation() {}
  
  
  public StoreOperation(int id, String operationKey) {
    super();
    this.id = id;
    this.operationKey = operationKey;
  }
  
  
  public int getId() {
    return id;
  }

  
  public void setId(int id) {
    this.id = id;
  }

  
  public String getOperationKey() {
    return operationKey;
  }

  
  public void setOperationKey(String operationKey) {
    this.operationKey = operationKey;
  }
  
  
}
