package com.sample.login.rest.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestContextRoot extends Application {
	//TODO: It is here where we can add object to json mapping, exception mapping and rest resources etc..
	//If above is not needed or @provider annotation is used, class can be left empty
	/*
	 * @Override 
	 * public Set<Class<?>> getClasses() { Set<Class<?>> classes = new HashSet<Class<?>>();
	 *     classes.add(GenericHTTPExceptionMapper.class);
	 *     classes.add(SampleRestApi.class);
	 *     return classes;
	 * }
	 */
}
