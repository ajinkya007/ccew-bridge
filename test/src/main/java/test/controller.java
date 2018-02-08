package test;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/store")
public class controller {
	@RequestMapping(method=RequestMethod.POST)
	public String saved(ServletRequest request)
	{
		System.out.println("The page has opened successfully");
		return "NewFile";
	}
	
	
}
