package fr.aoufi.springwebmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.aoufi.springwebmvc.service.PersonneService;
import fr.aoufi.springwebmvc.validator.PersonneValidator;
import fr.aoufi.springwebsample.model.Personne;

@Controller
@RequestMapping("/personnes")
public class PersonneController {
	
	private PersonneService personneService;
	
	private PersonneValidator personneValidator;
	
	private Logger logger = LoggerFactory.getLogger(PersonneController.class);
	
	@Autowired
	public void setPersonneService(PersonneService personneService) {
		this.personneService = personneService;
	}

	@Autowired
	public void setPersonneValidator(PersonneValidator personneValidator) {
		this.personneValidator = personneValidator;
	}
	
	@InitBinder
	public void init(WebDataBinder binder){		
		binder.setValidator(personneValidator);		
	}
	
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView index(){		
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView initListPersonne(){
		ModelAndView modelAndView = new ModelAndView("list-personnes");
		List<Personne> personnes = personneService.findAllOrderByName();
		modelAndView.addObject("personnes",personnes);	
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit.html", method = RequestMethod.GET)
	public ModelAndView initFromPersonne(@RequestParam(value = "id", required = false) Integer id){
		ModelAndView modelAndView = new ModelAndView("personne");	
		if(id != null){
			modelAndView.addObject("personne", personneService.findById(id));
		} else {
			modelAndView.addObject("personne", new Personne());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public ModelAndView deletePersonne(@RequestParam(value = "id") Integer id){
		ModelAndView modelAndView = new ModelAndView("redirect:list.html");		
		personneService.delete(id);
		return modelAndView;
	}
	
	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public ModelAndView savePersonne(@ModelAttribute("personne") 
										@Validated Personne personne, 
										BindingResult result){	
		if(result.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("personne");
			modelAndView.addObject("personne",personne);
			return modelAndView;
		}	
		ModelAndView modelAndView = new ModelAndView("redirect:list.html");
		logger.debug(""+personne.getNom()+personne.getPrenom()+personne.getId());
		personneService.save(personne);
		return modelAndView;
	}

}
