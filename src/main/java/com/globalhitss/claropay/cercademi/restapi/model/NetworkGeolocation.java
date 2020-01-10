package com.globalhitss.claropay.cercademi.restapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="CAT_NETWORK_GEOLOCATION")
@ApiModel(
  value="NetworkGeolocation",
  description=""
    + "It's the model to represent location data associated with an subnet."
    + " The IP address geolocation query finds the subnets to which the IP "
    + "address belogs."
)
public class NetworkGeolocation implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IP_FROM")
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private long ipFrom;
	
	@Id
	@Column(name="IP_TO")
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private long ipTo;

	@Column(name="NO_NODES")
	@ApiModelProperty(
	  notes="Number of nodes that belongs to this subnet.",
	  example="256"
	)
	private int noNodes;
	
	@Column(name="LATITUDE")
	@ApiModelProperty(
	  notes="Latitude associated with this subnet.",
	  example="19.4407"
	)
	private double latitude;
	
	@Column(name="LONGITUDE")
	@ApiModelProperty(
	  notes="Latitude associated with this subnet.",
	  example="-99.1964"
	)
	private double longitude;
	
	@Column(name="ZIP_CODE")
	@ApiModelProperty(
	  notes="Zip code associated with this subnet.",
	  example="11529"
	)
	private String zipCode;
	
	@Id
	@Column(name="DATASOURCE")
	@ApiModelProperty(
	  notes="Source of location reference.",
	  allowableValues="ip2location, geolite",
	  example="geolite"
	)
  private String datasource;

  public NetworkGeolocation() {}
	
	public NetworkGeolocation(long ipFrom, long ipTo, int noNodes, double latitude, double longitude, String zipCode, String datasource) {
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