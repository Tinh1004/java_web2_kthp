package springdemo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Users;
import springdemo.service.ProductsService;
import springdemo.service.UsersService;

@Controller
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UsersService usersService;

	
	@GetMapping("/login")
	public String loginPage(Model theModel, @CookieValue(name = "user_id", defaultValue = "") String id,HttpServletRequest request) {
		if(request.getSession().getAttribute("auth") != null) {
			return "redirect:/home";
		}
		Users theUser = new Users();
		theModel.addAttribute("user",theUser);
		return "login-form";
		
	}
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") Users theUser, Model theModel, HttpServletResponse response, HttpServletRequest request) {
		Users userLogin = usersService.login(theUser);
		if(userLogin != null) {
			int id = userLogin.getId();
			
			Cookie userCookie = new Cookie("user_id", String.valueOf(id)); // create cookie
			
			userCookie.setMaxAge(3600); // set time 1h
			response.addCookie(userCookie); // add cookie
			
			request.getSession().setAttribute("auth", userLogin);
			return "redirect:/home";
		}
		theModel.addAttribute("message","Login Failed!!!");
		
		return "redirect:/auth/login";
	}
	
	@GetMapping("/register")
	public String registerPage(@RequestParam Map<String, String> reqParam, Model theModel, HttpServletRequest request) {
		if(request.getSession().getAttribute("auth") != null) {
			return "redirect:/home";
		}
		String mes = "";
		if(reqParam.get("message") != null) {
			
			String message = reqParam.get("message");
			mes = message;
		}
		
		Users theUser = new Users();
		theModel.addAttribute("user",theUser);
		theModel.addAttribute("message",mes);
		return "register-form";
		
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") Users theUser, Model theModel, HttpServletResponse response, HttpServletRequest request) {
		//Save the customer using our service
		if(theUser.getUsername().isEmpty() || theUser.getPassword().isEmpty() || theUser.getFullname().isEmpty()) {
			return "redirect:/auth/register";
		}
		try {
			usersService.registerUsers(theUser);
			Users userLogin = usersService.login(theUser);
			if(userLogin != null) {
				
				int id = userLogin.getId();
				
				Cookie userCookie = new Cookie("user_id", String.valueOf(id)); // create cookie
				
				userCookie.setMaxAge(3600); // set time 1h
				response.addCookie(userCookie); // add cookie
				
				request.getSession().setAttribute("auth", userLogin);

				return "redirect:/home";
			}else {
				theModel.addAttribute("message","Login Failed!!!");
				return "redirect:/auth/register";
			}
			
			
		} catch (Exception e) {
			theModel.addAttribute("message","Login Failed!!!");
			return "redirect:/auth/register";
		}
	}
	
	@GetMapping("/logout")
	public String logout(Model theModel, HttpServletResponse response, HttpServletRequest request) {
		response.addCookie(new Cookie("user_id",""));
		request.getSession().removeAttribute("auth");
		return "redirect:/home";
	}
	
}
