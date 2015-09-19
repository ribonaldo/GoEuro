/**
 * 
 */
package com.go.euro.simple.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ricardo Bonaldo
 */
public class CityReader extends City {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 6536777526215925942L;

	@JsonProperty("geo_position")
	private GeoPosition geoPosition;

	private String fullName;

	@JsonProperty("iata_airport_code")
	private String iataAirportCode;

	private String country;

	@JsonProperty("location_id")
	private Long locationId;

	private Boolean inEurope;

	private String countryCode;

	private Boolean coreCountry;

	private Long distance;

	/**
	 * @return the fullName
	 */
	public final String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public final void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the iataAirportCode
	 */
	public final String getIataAirportCode() {
		return iataAirportCode;
	}

	/**
	 * @param iataAirportCode the iataAirportCode to set
	 */
	public final void setIataAirportCode(final String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	/**
	 * @return the country
	 */
	public final String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public final void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * @return the locationId
	 */
	public final Long getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public final void setLocationId(final Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the inEurope
	 */
	public final Boolean getInEurope() {
		return inEurope;
	}

	/**
	 * @param inEurope the inEurope to set
	 */
	public final void setInEurope(final Boolean inEurope) {
		this.inEurope = inEurope;
	}

	/**
	 * @return the countryCode
	 */
	public final String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public final void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the coreCountry
	 */
	public final Boolean getCoreCountry() {
		return coreCountry;
	}

	/**
	 * @param coreCountry the coreCountry to set
	 */
	public final void setCoreCountry(final Boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	/**
	 * @return the distance
	 */
	public final Long getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public final void setDistance(final Long distance) {
		this.distance = distance;
	}

	/**
	 * @return the geoPosition
	 */
	public final GeoPosition getGeoPosition() {
		return geoPosition;
	}

	/**
	 * @param geoPosition the geoPosition to set
	 */
	public final void setGeoPosition(final GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

}
