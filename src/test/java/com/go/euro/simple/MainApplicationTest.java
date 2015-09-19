package com.go.euro.simple;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

/**
 * Tests for {@link MainApplication}.
 * 
 * @author Ricardo Bonaldo
 */
public class MainApplicationTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() throws Exception {
		MainApplication.main(new String[] {"Berlin"});
		String output = this.outputCapture.toString();
		String value = MainApplication.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		value = StringUtils.substring(value, 1, value.length() - 1);
		value = StringUtils.replace(value, "/", "\\");
		assertTrue("Wrong output: " + output, output.contains(value));
	}
}
