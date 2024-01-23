package com.company.springboot3web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//---------------------------------------------------------------
/** APUNTA A LOS DOS PATH
 * classpath = src/main/java
 * classpath = src/main/resources
 */

/*FORMA-1: individual */
// @PropertySource(value = "classpath:values-custom.properties")

/*FORMA-2: multiples */
@PropertySources(value = {
	@PropertySource(value = "classpath:values-custom.properties", encoding = "UTF-8")
	,@PropertySource(value = "classpath:/propertyValue/values-custom2.properties", encoding = "UTF-8")
})
//---------------------------------------------------------------
@Configuration
public class ValuesConfig {

}
