package srinarayan.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import srinarayan.springmvc.model.User;
import srinarayan.springmvc.service.UserService;

@Controller
public class RegistrationController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	@Transactional
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		int status = userService.isValidPassword(user); // Check Valid password pattern
		if (status == 0) {
			model.addAttribute("errorPass", "Invalid Password pattern"); // Show message if invalid password enter
			return new ModelAndView("register");
		}
		userService.register(user); //Inserting new user 
		return new ModelAndView("welcome", "firstname", user.getUsername());
	}
}
