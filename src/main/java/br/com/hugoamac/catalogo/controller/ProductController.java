package br.com.hugoamac.catalogo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.hugoamac.catalogo.entity.Product;
import br.com.hugoamac.catalogo.service.LogService;
import br.com.hugoamac.catalogo.service.ProductService;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

	private ProductService service;
	private LogService log;

	public ProductController(ProductService service, LogService log) {
		this.service = service;
		this.log = log;
	}

	@GetMapping("")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) String current,
			@RequestParam(name = "keyname", required = false) String keyname) {

		if (keyname != null && !keyname.equals("")) {

			int currentPage = Integer.parseInt(current);

			Page<Product> page = service.findByNameContaining(keyname, currentPage);

			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages();

			List<Product> products = page.getContent();

			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalItems", totalItems);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("products", products);
			model.addAttribute("keyname", keyname);

		}

		return "product/index";
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam(value = "file") MultipartFile file) {

		boolean result = this.service.saveDataFromFile(file);

		Map<String, Object> data = new HashMap<String, Object>();

		if (result == true) {
			data.put("success", true);
		} else {
			data.put("success", false);
		}

		return ResponseEntity.ok(data);
	}
}
