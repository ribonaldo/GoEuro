/**
 * 
 */
package com.go.euro.simple;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.go.euro.simple.domain.CityReader;
import com.go.euro.simple.domain.GeoPosition;
import com.go.euro.simple.service.CityService;

/**
 * @author Ricardo Bonaldo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
public class CityServiceTest {
	
	/**
	 * {@link CityService}.
	 */
	@Autowired
	private CityService cityService;
	
	@Test
	public void getCityTest() {
		String[] cities = new String[] {"Rome", "Berlin"};
		CityReader cityReader = null;
		
		for (String citySearch : cities) {
			if (citySearch.equals("Rome")) {
				cityReader = getRomeLocation();
			} else if (citySearch.equals("Berlin")) {
				cityReader = getBerlinLocation();
			}
			CityReader cityReaderReturn = getLocal(citySearch);
			Assert.assertThat(cityReader.getGeoPosition(), SamePropertyValuesAs.samePropertyValuesAs(cityReaderReturn.getGeoPosition()));
			cityReader.setGeoPosition(null);
			cityReaderReturn.setGeoPosition(null);

			Assert.assertEquals(cityReader.getFullName(), cityReaderReturn.getFullName());
			Assert.assertThat(cityReader, SamePropertyValuesAs.samePropertyValuesAs(cityReaderReturn));
		}
	}
	
	private CityReader getLocal(String city) {
		return cityService.getCities(city)[0];
	}
	
	private CityReader getBerlinLocation() {
		CityReader city = new CityReader();
		city.setId(376217L);
		city.setKey(null);
		city.setName("Berlin");
		city.setFullName("Berlin, Germany");
		city.setIataAirportCode(null);
		city.setType("location");
		city.setCountry("Germany");
		city.setLocationId(null);
		city.setInEurope(true);
		city.setCountryCode("DE");
		city.setCoreCountry(true);
		city.setDistance(null);

		GeoPosition geoPosition = new GeoPosition();
		geoPosition.setLatitude(this.getValue(52.52437, 5));
		geoPosition.setLongitude(this.getValue(13.41053, 5));
		city.setGeoPosition(geoPosition);
		return city;
	}

	private CityReader getRomeLocation() {
		CityReader city = new CityReader();
		city.setId(388498L);
		city.setKey(null);
		city.setName("Rome");
		city.setFullName("Rome, Italy");
		city.setIataAirportCode(null);
		city.setType("location");
		city.setCountry("Italy");
		city.setLocationId(null);
		city.setInEurope(true);
		city.setCountryCode("IT");
		city.setCoreCountry(true);
		city.setDistance(null);
		
		GeoPosition geoPosition = new GeoPosition();
		geoPosition.setLatitude(this.getValue(41.89474, 5));
		geoPosition.setLongitude(this.getValue(12.4839, 4));
		city.setGeoPosition(geoPosition);
		return city;
	}
	
	private BigDecimal getValue(final Double value, final int scale) {
		BigDecimal bdValue = new BigDecimal(value).setScale(scale, RoundingMode.HALF_EVEN);
		return bdValue;
	}
}
