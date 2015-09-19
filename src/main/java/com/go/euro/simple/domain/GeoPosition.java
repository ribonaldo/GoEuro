/**
 * 
 */
package com.go.euro.simple.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Ricardo Bonaldo
 *
 */
@JsonIgnoreProperties
public class GeoPosition implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -925401076174931110L;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;

	/**
	 * @return the latitude
	 */
	public final BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public final void setLatitude(final BigDecimal latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public final BigDecimal getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public final void setLongitude(final BigDecimal longitude) {
		this.longitude = longitude;
	}

}
