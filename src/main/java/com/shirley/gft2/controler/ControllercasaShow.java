package com.shirley.gft2.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllercasaShow {
	

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	


}
