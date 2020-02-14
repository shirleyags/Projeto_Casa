package com.shirley.gft2.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shirley.gft2.model.CasaShow;
import com.shirley.gft2.repository.CasaCadastros;
import com.shirley.gft2.repository.filter.CasaFiltro;



@Controller
public class ControllerCadastroCasaShow {
	
	@Autowired
	private CasaCadastros cadastroscasa;
	
	@RequestMapping("/casa/casacadastro")
	public ModelAndView CasaCadastrar() {
		ModelAndView mv = new ModelAndView("/Casa/CasaShow");
		mv.addObject(new CasaShow());
		return mv;
	}

	@RequestMapping(value="/casa/casacadastro", method=RequestMethod.POST)
	public String salvar(@Validated CasaShow casa, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return "/Casa/CasaShow";
		}
		cadastroscasa.save(casa);	
		attributes.addFlashAttribute("mensagem", "Casa salva com sucesso!");
		return "redirect:/casa/casacadastro";
	}
		

	@RequestMapping ("/casa/listacasas")
	public ModelAndView pesquisar(@ModelAttribute("filtro") CasaFiltro filtro) { // Para criar a lista de casas de show.
		// (@RequestParam(defaultValue = "%")String casa) - Para que sem um elemento na pesquisa a página não quebre ao apertar busca.
		String casa =  filtro.getCasa() == null ? "%" : filtro.getCasa();
		List<CasaShow> todasCasas = cadastroscasa.findByCasaContaining (casa);
		ModelAndView mv = new ModelAndView("/Casa/ListaCasas");
		mv.addObject("casas", todasCasas); // A lista de objetos "todasCasas" estará disponível na view com o nome "casas".
		return mv;}


	
	@RequestMapping ("/casa/{code}")
	public ModelAndView editar(@PathVariable Long code) {
		ModelAndView mv = new ModelAndView("/Casa/CasaShow");
		CasaShow casaRetorna = cadastroscasa.findById(code).get();
		mv.addObject(casaRetorna);
		return mv;	}

	@RequestMapping(value="/casa/{code}", method = RequestMethod.POST)
	public String excluir(@PathVariable Long code){
		cadastroscasa.deleteById(code);
		return "redirect:/casa/listacasas";
	}
	
	

}
