package com.iamscratches.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class); 
		Coach hockeyCoach = context.getBean("hockeyCoach", Coach.class);
		Coach basketballCoach = context.getBean("basketballCoach", Coach.class);
		
		//call a method from the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(hockeyCoach.getDailyWorkout());
		System.out.println(basketballCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		System.out.println(hockeyCoach.getDailyFortune());
		System.out.println(basketballCoach.getDailyFortune());
		
		//call email and team
		TennisCoach tennisCoach = context.getBean("thatSillyCoach", TennisCoach.class);
		System.out.println(tennisCoach.email + "\t" + tennisCoach.team);
		
		BasketballCoach bCoach = (BasketballCoach)basketballCoach;
		System.out.println(bCoach.email + "\t" + bCoach.team);
		
		//check for object reference
		if(bCoach == basketballCoach)
			System.out.println("basketBall coach has same memory reference of " + bCoach);
		if(tennisCoach!=theCoach)// if u check the output u will find that tennisCoach class is instantiated two times and both the times
								//  Parameterized constructor of the class gets called
			System.out.println("tennisCoach coach has different memory references at " + theCoach + " and " + tennisCoach);
		
		//close the context
		context.close();
	}


	/*Java annotations are special labels/markers added to java classes. It provides meta-data about the class and is processes at 
	 * compile time or run-time for special processing
	 * Development process:
	 * Enable component scanning in Spring config file
	 * Add the @Component Annotation to your java classes
	 * Retrieve bean from spring container
	 */
	/*Auto-wiring injections are of three types namely: 
	 * constructor injection, setter/method injection and field injection
	 */
	/*Development process: constructor injection
	 * define dependency interface and class
	 * create a constructor in your class for injections
	 * configure the dependency injection with @Autowired annotation
	 */
	/*Development process: Setter injection
	 * create setter methods in our class for injection
	 * configure the dependency injection with @Autowired annotation
	 */
	/*Development process: field injection
	 * configure the dependency injection with @Autowired annotation
	 * 		Applied directly to the field
	 * 		No need for setter methods
	 */
	/* Can apply @Qualifier annotation to resolve multiple dependency of bean definition to constructor, setter and field injections
	 */
	/*Development process: Bean lifecycle method annotations
	 * Define ur methods for init and destroy
	 * add annotations: @PostConstruct and @PreDestruct
	 */
}
