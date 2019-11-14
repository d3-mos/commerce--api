package com.globalhitss.claropay.cercedemi.commerceapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ip_cities")
public class IPCities implements Serializable
{
	@Id
	@Column(name="ip_from")
	@JsonIgnore
	private long ipFrom;
	
	@Id
	@Column(name="ip_to")
	@JsonIgnore
	private long ipTo;

	@Column(name="no_nodes")
	private int noNodes;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@Id
	@Column(name="datasource")
  private String datasource;

  public IPCities() {}
	
	public IPCities(long ipFrom, long ipTo, int noNodes, double latitude, double longitude, String zipCode, String datasource) {
		super();
		this.ipFrom = ipFrom;
		this.ipTo = ipTo;
		this.noNodes = noNodes;
		this.latitude = latitude;
		this.longitude = longitude;
		this.zipCode = zipCode;
		this.datasource = datasource;
	}

	public long getIpFrom() {
		return ipFrom;
	}

	public void setIpFrom(long ipFrom) {
		this.ipFrom = ipFrom;
	}

	public long getIpTo() {
		return ipTo;
	}

	public void setIpTo(long ipTo) {
		this.ipTo = ipTo;
	}

	public int getNoNodes() {
		return noNodes;
	}

	public void setNoNodes(int noNodes) {
		this.noNodes = noNodes;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
  public String getDatasource() {
    return datasource;
  }

  public void setDatasource(String datasource) {
    this.datasource = datasource;
  }
}
