package com.chimera.news.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chimera.news.dto.NewsPaperDTO;
import com.chimera.news.entity.NewsPaperEntity;
import com.chimera.news.service.NewsPaperService;
import com.chimera.news.service.NewsPaperServiceImpl;

@Controller
@RequestMapping("/")

public class NewsPaperController {

	@Autowired
	private NewsPaperService newsPaperService;

	public NewsPaperController() {
		System.out.println("created" + this.getClass().getSimpleName());
	}

	@RequestMapping("/newspaper.do")
	public String onClick(@ModelAttribute NewsPaperDTO newsPaperDTO, Model model) {
		System.out.println(newsPaperDTO);
		
	   boolean valid=this.newsPaperService.validateNewsPaperInfo(newsPaperDTO);
	   System.out.println(valid);
	   if(valid) {
	  
	    	model.addAttribute("message", "Thank you for registering");
	    	return "RegisterSuccess";
	   }
	    model.addAttribute("msg", "Enter valid details");
		Map<String, String> map = NewsPaperServiceImpl.map;
		model.addAttribute("NameError", map.get("Name"));
		model.addAttribute("CostError", map.get("Cost"));
		model.addAttribute("PagesError",map.get("Pages"));
		model.addAttribute("LanguageError", map.get("Language"));
		model.addAttribute("MagazineError", map.get("Magazine"));
		return "index";
	    }
	
	

	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public ModelAndView fecthNewsPaper(@RequestParam("name") String name, ModelMap model ,ModelAndView modelv) {
		try {
			 NewsPaperEntity dto = newsPaperService.validateAndSearchByName(name);
			 model.addAttribute("newspaper", dto);
			
			  modelv.addObject("NewsPaperDTO", dto);
			  modelv.setViewName("search");
			 
		} catch (Exception e) {
		e.printStackTrace();
		}

		return modelv;

	}
}

