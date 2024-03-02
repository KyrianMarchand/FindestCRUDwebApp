package findest.com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import findest.com.test.entity.Studies;
import findest.com.test.service.StudiesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PageController {

	@Autowired
	private StudiesService studiesService;

	@GetMapping("/")
	public String welcomePage(Model model) {
		model.addAttribute("Studieslist", studiesService.listOfStudies());
		return "index";
	}
}