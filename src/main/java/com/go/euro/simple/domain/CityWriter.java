/**
 * 
 */
package com.go.euro.simple.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Ricardo Bonaldo
 * Class created to support CSV Writer once Json don't support Object (GeoLocation) for write
 */
@JsonPropertyOrder({ "id", "name", "type", "latitude", "longitude" })
public class CityWriter extends City {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 7465238170608930654L;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}
	
	public final void parse(final CityReader reader) {
		this.latitude = reader.getGeoPosition().getLatitude();
		this.longitude = reader.getGeoPosition().getLongitude();
		this.setId(reader.getId());
		this.setKey(reader.getKey());
		this.setName(reader.getName());
		this.setType(reader.getType());
	}
}
