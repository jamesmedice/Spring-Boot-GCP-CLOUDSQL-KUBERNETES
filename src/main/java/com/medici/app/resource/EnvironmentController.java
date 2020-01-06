package com.medici.app.resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author a73s
 *
 */
@RestController
public class EnvironmentController {

	protected Logger logger = Logger.getLogger(EnvironmentController.class.getName());

	@Autowired
	Environment environment;

	@RequestMapping(value = "/systemProperties", method = RequestMethod.GET)
	public Map<String, Object> systemProperties() {
		return ((AbstractEnvironment) environment).getSystemProperties();
	}

	@RequestMapping(value = "/systemEnvironment", method = RequestMethod.GET)
	public Map<String, Object> systemEnvironment() {
		return ((AbstractEnvironment) environment).getSystemEnvironment();
	}

	@RequestMapping(value = "/propertySources", method = RequestMethod.GET)
	public Map<String, Object> propertySources() {
		Map<String, Object> map = new HashMap();
		for (Iterator it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext();) {
			PropertySource propertySource = (PropertySource) it.next();
			if (propertySource instanceof MapPropertySource) {
				map.putAll(((MapPropertySource) propertySource).getSource());
			}
		}

		return map;
	}

	@RequestMapping(value = "/env", method = RequestMethod.GET)
	public Map<String, String> env() {
		logger.info("microservice envVars() invoked");
		return System.getenv();
	}

	@RequestMapping(value = "/activeProfiles", method = RequestMethod.GET)
	public String[] activeProfiles() {
		logger.info("microservice activeProfiles() invoked");
		return environment.getActiveProfiles();
	}

}
