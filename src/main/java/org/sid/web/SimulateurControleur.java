package org.sid.web;


import org.sid.entities.Control;
import org.sid.entities.Simulateur;
import org.sid.entities.User;
import org.sid.service.ServiceBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimulateurControleur {
	@Autowired
	ServiceBanque service;
	
	@RequestMapping(value="/auth", method = RequestMethod.GET) 
	public String home(Model modelA) {
		modelA.addAttribute("user", new Control());
		return  "login"; 
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	private String index(Model modelB, Control control) {//
		boolean mess = service.connexion(control.getEmail(), control.getPassword());
		if (mess==false) {
			modelB.addAttribute("mess", mess);
			return "login";
		}else {
			modelB.addAttribute("simulateur", new Simulateur());
			return "index";
		}
	
	}
	
	@RequestMapping(value="/simulate",method = RequestMethod.POST)
	private String simul(Model modelC, Simulateur simulateur) {//
		 double res = service.calcul(simulateur.getMontant(), simulateur.getDuree(), simulateur.getTaux());
		 simulateur.setMensualite(res);
		 modelC.addAttribute("simulateur", simulateur);
		 return "index";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET) 
	public String addU(Model modelD) {
		modelD.addAttribute("user", new User());
		return  "addUser"; 
	}
	
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	private String save(Model modelC, User user) {//
		 service.addUser(user);
		 modelC.addAttribute("user", user);
		 return "confirmUser";
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)// Si on ne met rien par defaut c est GET 
	public String delete(Model modelD, Long id, User user) {
		service.deleteUser(id);
		modelD.addAttribute("user", user);
		return "redirect:form";
	}

}
