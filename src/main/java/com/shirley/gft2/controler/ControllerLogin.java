package com.shirley.gft2.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLogin {
	
	@RequestMapping({"/login"})
	public String login() {
		return "login";
	}
	
	
	@RequestMapping({"/login-error"})
	public String loginError(ModelMap model) {
		model.addAttribute("alerta","erro");
		model.addAttribute("texto", "Login ou senha incorretos, tente novamente");	
		model.addAttribute("subtexto", "Confira os dados");		
		return "login";
	}
	
//	@RequestMapping({"/acesso-negado"})	
//	public String acessoNegado(ModelMap model, HttpServletResponse resposta) {
//		model.addAttribute("status",resposta.getStatus());
//		model.addAttribute("error", "Acesso Negado.");	
//		model.addAttribute("message", "Você não tem permissão para acesso a essa área!");		
//		return "error";
//	}
	
	

}
