package org.universe.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.universe.model.Discoverer;
import org.universe.model.Star;
import org.universe.service.DiscovererService;
import org.universe.service.StarService;



@Controller
public class StarController {
	
	protected static Logger LOG = Logger.getLogger(StarController.class);
	
	@Autowired
	public StarService starService;
	
	//Handler method for listing all stars
	@RequestMapping(value={ "/stars"})
	public ModelAndView listStar(ModelAndView mv) throws IOException{
	    List<Star> listStar = starService.getStars();
	    mv.addObject("stars", listStar);
	    mv.setViewName("stars");
	    return mv;
	}
	
	
	//Handler method for displaying new star form:
	@RequestMapping(value = "/newstar", method = RequestMethod.GET)
	public ModelAndView newStar(ModelAndView model) {
	    Star newStar = new Star();
	    model.addObject("star", newStar);
	    model.setViewName("starform");
	    return model;
	}
	
	//Handler method for inserting/updating a star:
	@RequestMapping(value = "/savestar", method = RequestMethod.POST)
	public ModelAndView saveStar(@ModelAttribute Star star) {
		if (star != null && star.getId() != null)
			starService.updateStar(star);
		else {
			if (star.getName().length() < 3) {
				ModelAndView mv = new ModelAndView("starform");
				mv.addObject("message", "Star name should not be empty");
			    mv.addObject("star", star);
				return mv;
			}
			if (star.getDiscoverer().equals("NONE")) {
				ModelAndView mv = new ModelAndView("starform");
				mv.addObject("message", "Enter Discoverer name");
			    mv.addObject("star", star);
				return mv;
			}
			if(starService.getStarByName(star.getName())) {
				ModelAndView mv = new ModelAndView("starform");
				mv.addObject("message", "Star name already exists");
			    mv.addObject("star", star);
				return mv;
			}

			starService.insertStar(star);
		}
	    return new ModelAndView("redirect:/stars");
	}
	
	//Handler method for deleting a star:
	@RequestMapping(value = "/deletestar", method = RequestMethod.GET)
	public ModelAndView deleteStar(HttpServletRequest request) {
	    int id = Integer.parseInt(request.getParameter("id"));
		Star star = starService.getStarById(id);
		ModelAndView mv = new ModelAndView();
		if (star.getClazz().equals("G")) {
			mv.addObject("message", "Yellow star can not be deleted");
			System.out.println("Yellow star can not be deleted");
			request.setAttribute("message", request.getParameter("message"));
			List<Star> listStar = starService.getStars();
			mv.addObject("stars", listStar);
			mv.setViewName("stars");
			return mv;
		}

        starService.deleteStar(id);
        mv.addObject("message", "Star "+star.getName()+" was deleted");
		List<Star> listStar = starService.getStars();
		mv.addObject("stars", listStar);
		mv.setViewName("stars");
		return mv;
        //return new ModelAndView("stars");
	}
	
	//Handler method for retrieving details of a particular star for editing:
	@RequestMapping(value = "/editstar", method = RequestMethod.GET)
	public ModelAndView editStar(HttpServletRequest request) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    Star star = starService.getStarById(id);
	    ModelAndView model = new ModelAndView("starform");
	    model.addObject("star", star);
	    return model;
	}
	
	
	

	
	@Autowired
	public DiscovererService discovererService;
	
	@ModelAttribute("discoverers")
	public List<String> discovererList() {
		List<String> selectItems = new ArrayList<String>();
		List<Discoverer> discovererList = discovererService.listDiscoverers();
		for (Discoverer d : discovererList) {
			selectItems.add(d.getName());
		}
		return selectItems;
	}
	
	
}
