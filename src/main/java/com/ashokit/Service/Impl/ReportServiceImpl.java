package com.ashokit.Service.Impl;


import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.Service.ReportService;
import com.ashokit.entity.InsurancePolicy;
import com.ashokit.repository.InsuranceRepository;
import com.ashokit.searchRequest.SearchRequest;
import com.ashokit.utility.ExcelGenerator;
import com.ashokit.utility.PdfGenerator;
import com.ashokit.utility.SendEmail;


@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private InsuranceRepository repo;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private SendEmail sendEmail;
	
	@Override
	public List<String> getPlanName() {
		
		List<String> planName = repo.getPlanName();
			
		return planName;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getPlanStatus();
		
		return planStatus;
	}

	@Override
	public List<InsurancePolicy> search(SearchRequest request) {
		
		InsurancePolicy policy = new InsurancePolicy();
		

		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			policy.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			policy.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			policy.setGender(request.getGender());
		}
		if(null!=request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
			
			String startDate = request.getPlanStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			policy.setPlanStartDate(localDate);
		}
		if(null!=request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
			
			String endDate = request.getPlanEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			policy.setPlanEndDate(localDate);
		}
		List<InsurancePolicy> findAll = repo.findAll(Example.of(policy));
		return findAll;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception{		
		File f = new File("policy.pdf");
		
		List<InsurancePolicy> policy = repo.findAll();
		pdfGenerator.generatePdf(response,policy,f);
		
		String subject= "Mail Subject";
		String body="<h1> Mail Body </h1>";
		String to="yarranikhil1@gmail.com";
		
		sendEmail.sendEmail(subject, body, to, f);
		
		f.delete();
		
		return true;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception  {
		File f = new File("policy.xls");
		
		List<InsurancePolicy> policy = repo.findAll();
		excelGenerator.generateExcel(response,policy,f);
		
		String subject= "Mail Subject";
		String body="<h1> Mail Body </h1>";
		String to="yarranikhil1@gmail.com";
		
		sendEmail.sendEmail(subject, body, to, f);

		f.delete();
		
		return true;
	}
	
}
