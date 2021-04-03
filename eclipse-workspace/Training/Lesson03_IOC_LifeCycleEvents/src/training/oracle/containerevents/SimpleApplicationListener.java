package training.oracle.containerevents;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class SimpleApplicationListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		 System.out.printf("Event type : %s%n", event.getClass().getSimpleName());		
	}
	

}
