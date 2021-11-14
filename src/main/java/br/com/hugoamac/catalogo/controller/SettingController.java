package br.com.hugoamac.catalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/settings")
public class SettingController {

	@GetMapping("")
	public String index() {
		
		return "setting/index";
	}
}
