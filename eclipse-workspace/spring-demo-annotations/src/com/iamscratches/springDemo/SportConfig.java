package com.iamscratches.springDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.iamscratches.springDemo")
/* Whole component scan of the entire package is prevented so that spring will only create beans for those components which we 
 * actually will need
 */
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {// sadFortuneService will be the bean id in this case
		return new SadFortuneService();
	}
	
	//define a bean for our swim coach and inject dependencies
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	

}
/*Development process: Spring config with java code(no XML)
 * Create a java class and annote as @Configuration
 * Add component scanning support: @ComponentScan(Optional)
 * Read spring java configuration file
 * Retrieve bean from the spring container
 */
/* Development process: Defining spring beans with java code(no XML)
 * Define method to expose beans
 * Inject bean dependencies
 * Read spring java configuration class
 * Retrieve bean from the spring container
 */
/* Development process: Injecting values from properties file
 * Create properties file
 * Load properties file in spring config
 * Reference the values from properties file
 */
