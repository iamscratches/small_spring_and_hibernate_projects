package com.iamscratches.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "helloworld-form";
	}
	/* since process form version two and three are not defined in this mapping,
	 * I u follow up through this link and click on submit button of second or third button
	 * it will show an error
	 */

}
