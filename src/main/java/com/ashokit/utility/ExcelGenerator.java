package com.ashokit.utility;

import java.io.File; 
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashokit.entity.InsurancePolicy;
import com.ashokit.repository.InsuranceRepository;

@Component
public class ExcelGenerator {

	@Autowired
	private InsuranceRepository repo;	
	
	public void generateExcel(HttpServletResponse response,List<InsurancePolicy> policy, File f) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Insurance Policy Details");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Customer Id");
		row.createCell(1).setCellValue("Customer Name");
		row.createCell(2).setCellValue("Gender");
		row.createCell(3).setCellValue("Plan Name");
		row.createCell(4).setCellValue("Plan Status");
		row.createCell(5).setCellValue("Plan Start Date");
		row.createCell(6).setCellValue("Plan End Date");
		row.createCell(7).setCellValue("Benefit Amount");
		row.createCell(8).setCellValue("Denial Reason");
		row.createCell(9).setCellValue("Terminated Date");
		row.createCell(10).setCellValue("Terminated Reason");
		
		policy = repo.findAll();
		int dataRowIndex = 1;
		
		for (InsurancePolicy p : policy) {
			
			Row dataRow = sheet.createRow(dataRowIndex);
			
			dataRow.createCell(0).setCellValue(p.getCoustmerId());
			dataRow.createCell(1).setCellValue(p.getCoustmerName());
			dataRow.createCell(2).setCellValue(p.getGender());
			dataRow.createCell(3).setCellValue(p.getPlanName());
			dataRow.createCell(4).setCellValue(p.getPlanStatus());
			
			if(null != p.getPlanStartDate()) {
				dataRow.createCell(5).setCellValue(p.getPlanStartDate()+"");
			}else {
				dataRow.createCell(5).setCellValue("-");
			}
			
			if( null != p.getPlanEndDate()) {
				dataRow.createCell(6).setCellValue(p.getPlanEndDate()+"");
			}else {
				dataRow.createCell(6).setCellValue("-");
			}
			
			if(null != p.getBenefitAmount()) {
				dataRow.createCell(7).setCellValue(p.getBenefitAmount());
			}else {
				dataRow.createCell(7).setCellValue("N/A");
			}
			
			if( null != p.getDenialReason()) {
				dataRow.createCell(8).setCellValue(p.getDenialReason());
			}else {
				dataRow.createCell(8).setCellValue("-");
			}
			
			if( null != p.getTerminatedDate()) {
				dataRow.createCell(9).setCellValue(p.getTerminatedDate()+"");
			}else {
				dataRow.createCell(9).setCellValue("-");
			}
			
			if( null != p.getTerminatedReason()) {
				dataRow.createCell(10).setCellValue(p.getTerminatedReason());
			}else {
				dataRow.createCell(10).setCellValue("-");
			}
			
			dataRowIndex++;
		}
		
		FileOutputStream fos= new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

	}

}
