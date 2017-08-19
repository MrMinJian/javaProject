package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloWorld {
	
	@RequestMapping("test/{id}/{age}")
	public String test(@PathVariable("id") Integer id,@PathVariable("age") Integer age){
		System.out.println(id);
		System.out.println(age);
		return "redirect:/world.jsp";
	}
	
}
