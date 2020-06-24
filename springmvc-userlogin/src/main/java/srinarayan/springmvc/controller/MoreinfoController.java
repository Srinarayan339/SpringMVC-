package srinarayan.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import srinarayan.springmvc.model.Moreinformation;
import srinarayan.springmvc.service.UserService;

@Controller
public class MoreinfoController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/moreinformation", method = RequestMethod.GET)
	public ModelAndView showMoreinformation(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("moreinformation");
		mav.addObject("moreinformation", new Moreinformation());
		return mav;
	}

	@RequestMapping(value = "/moreinfoprocess", method = RequestMethod.POST)
	public ModelAndView addmoreinfo(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("moreinformation") Moreinformation moreinformation) {

		int status = userService.isValidNumber(moreinformation); // To Check user input valid number or not
		if (status == 0) {
			model.addAttribute("errorNum", "Invalid input"); // Message if user does not input valid number
			return new ModelAndView("moreinformation");
		}

		try {
			userService.moreinfo(moreinformation);   //Inserting moreinformation 

		} catch (Exception e) { // Catch if Exception occur
			e.printStackTrace();
		}
		return new ModelAndView("Welcome1", "firstname", moreinformation.getFirstname());
	}

}
