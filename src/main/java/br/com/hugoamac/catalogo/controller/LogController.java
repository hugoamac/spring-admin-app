package br.com.hugoamac.catalogo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hugoamac.catalogo.entity.Log;
import br.com.hugoamac.catalogo.entity.Product;
import br.com.hugoamac.catalogo.service.LogService;

@Controller
@RequestMapping("/admin/logs")
public class LogController {
	
	private LogService service;
	
	public LogController(LogService service) {
		this.service = service;
	}

	@GetMapping("")
	public String index(Model model) {
		
		List<Log> logs = service.listAll();
		model.addAttribute("logs", logs);
		
		return "log/index";
	}
}
