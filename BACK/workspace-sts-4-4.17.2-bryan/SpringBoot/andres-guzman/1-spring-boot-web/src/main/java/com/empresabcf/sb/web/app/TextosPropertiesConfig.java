package com.empresabcf.sb.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties") //-> spring-boot-web/src/main/resources/textos.properties
	//,@PropertySource("classpath:otroArchivo.properties")
})
public class TextosPropertiesConfig {

}
