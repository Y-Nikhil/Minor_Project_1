 package com.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.Service.ReportService;
import com.ashokit.entity.InsurancePolicy;
import com.ashokit.searchRequest.SearchRequest;

@Controller
public class PolicyController {

	@Autowired
	public ReportService service;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=policy.pdf");
		
		service.exportPdf(response);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=policy.xls");
		
		service.exportExcel(response);
	}
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model) {
		List<InsurancePolicy> plans = service.search(request);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("search", new InsurancePolicy());
		init(model);
		
		return "index";
	}
	
	private void init(Model model) {
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}
}
