package com.ashokit.Service;

import java.util.List; 

import javax.servlet.http.HttpServletResponse;

import com.ashokit.entity.InsurancePolicy;
import com.ashokit.searchRequest.SearchRequest;

public interface ReportService {

	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
	public List<InsurancePolicy> search(SearchRequest request);
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;


}
