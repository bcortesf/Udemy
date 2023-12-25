package com.company.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/*
 * CLASSPATH: indicamos               <nombre>/<ubicacion>
 * classpath = raiz-proyecto           "1-springboot-web"
 * classpath = recursos-proyecto   "/1-springboot-web/src/main/resources" 
 */

@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties") //-> 1-springboot-web/src/main/resources/textos.properties
	//,@PropertySource("classpath:otroArchivo.properties")
})
public class TextosPropertiesConfig {

}
