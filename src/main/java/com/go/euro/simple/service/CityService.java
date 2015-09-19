/**
 * 
 */
package com.go.euro.simple.service;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.go.euro.simple.domain.CityReader;
import com.go.euro.simple.domain.CityWriter;

/**
 * @author Ricardo Bonaldo
 *
 */
@Service
public class CityService {
	
	private static final Logger LOG = Logger.getLogger(CityService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${go.euro.uri}")
	private String url;
	
	/**
	 * Returns an array of cities based on the search
	 * @param cityName search parameter
	 * @return {@link CityReader[]}
	 */
	public CityReader[] getCities(final String cityName) {
		return restTemplate.getForObject(url, CityReader[].class, cityName);
	}
	
	/**
	 * Write a CSV File on the target project path.
	 * The generated file name has the following format: File_city_yyyyMMddHHmmss.CSV as the sample below
	 * <br>
	 * City searched is Rome at 2015-07-15 23:31:41. Generated file name will be: File_Rome_20150713233141.CSV
	 * @param cities {@link CityReader[]}
	 * @param city the search parameter
	 */
	public void writeCsvFile(final CityReader[] cities, final String city) {
		CsvMapper mapper = new CsvMapper();
		
		mapper.configure(DeserializationFeature.EAGER_DESERIALIZER_FETCH, true);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String filePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
		
		filePath = StringUtils.substring(filePath, StringUtils.indexOf(filePath, "/") + 1, filePath.length() - 1);
		
		filePath = StringUtils.substring(filePath, 0, StringUtils.lastIndexOf(filePath, "/"));
		
		filePath += "/File_" + city + "_" + sdf.format(new Date()) + ".CSV";
		
		CsvSchema schema = mapper.schemaFor(CityWriter.class);
		
		filePath = StringUtils.replace(filePath, "/", "\\");
		
		File file = new File(filePath);
		
		ObjectWriter writer = mapper.writer(schema);
		try {
			PrintWriter pw = new PrintWriter(file, "ISO-8859-1");
			writer.writeValue(pw, this.getData(cities));
		} catch (Exception e) {
			LOG.error("Error saving file ", e);
		}
	}
	
	/**
	 * Transforms the {@link CityReader} {@link Array} into a {@link CityWriter} {@link List}
	 * @param cities {@link CityReader[]}
	 * @return {@link List<#CityWriter>}
	 */
	private List<CityWriter> getData(final CityReader[] cities) {
		List<CityWriter> citiesWriter = new ArrayList<CityWriter>();
		for (CityReader cityReader : cities) {
			CityWriter city = new CityWriter();
			city.parse(cityReader);
			citiesWriter.add(city);
		}
		return citiesWriter;
	}
}
