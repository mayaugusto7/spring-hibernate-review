package br.com.mayaugusto.springboot.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String sayWorld(Model theModel) {
		
		theModel.addAttribute("theDate", new Date());
		
		return "helloworld";
	}
}
