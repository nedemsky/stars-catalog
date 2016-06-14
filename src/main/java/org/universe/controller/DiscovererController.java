package org.universe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.universe.model.Discoverer;
import org.universe.service.DiscovererService;

@Controller
public class DiscovererController {
	
	@Autowired 
	public DiscovererService discovererService;
	

	
	@RequestMapping(value = "/discoverers", method = RequestMethod.GET)
	public String listDiscoverers(Model model) {
		model.addAttribute("discoverer", new Discoverer());
		model.addAttribute("listDiscoverers", discovererService.listDiscoverers());
		return "discoverer";
	}
	
	//For add and update discoverer both
	@RequestMapping(value= "/discoverer/add", method = RequestMethod.POST)
	public String addDiscoverer(@ModelAttribute("discoverer") Discoverer p){
		System.out.println("-------------addDiscoverer "+p.getName());
		if(p == null || p.getName() == null || p.getName().equals("")){
			System.out.println("------------- "+p.getName());
			//new discoverer, add it
			discovererService.addDiscoverer(p);
		}else{
			//existing discoverer, call update
			discovererService.addDiscoverer(p);
			//discovererService.updateDiscoverer(p);
		}
		return "redirect:/discoverers";
		
	}
	
	@RequestMapping("/remove/{name}")
    public String removeDiscoverer(@PathVariable("name") String name){
		System.out.println("-------------removeDiscoverer   "+name);
        this.discovererService.deleteDiscoverer(name);
        return "redirect:/discoverers";
    }
 
    @RequestMapping("/edit/{name}")
    public String editDiscoverer(@PathVariable("name") String name, Model model){
    	System.out.println("-------------editDiscoverer");
        model.addAttribute("discoverer", discovererService.getDiscovererByName(name));
        model.addAttribute("listDiscoverers", discovererService.listDiscoverers());
        return "discoverer";
    }
	
}