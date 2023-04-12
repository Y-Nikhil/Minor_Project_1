package com.ashokit.utility;

import java.awt.Color; 
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashokit.entity.InsurancePolicy;
import com.ashokit.repository.InsuranceRepository;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator{
	
	@Autowired
	private InsuranceRepository repo;
	
	public void generatePdf(HttpServletResponse response,List<InsurancePolicy> policy, File f) throws Exception{
		
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		PdfWriter.getInstance(doc, new FileOutputStream(f));
		
		doc.open();
		
		Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
		Paragraph para = new Paragraph("Insurance Policy Details", fontHeader);
		para.setAlignment(Element.ALIGN_CENTER);
		doc.add(para);
		doc.add(Chunk.NEWLINE);
		
		PdfPTable table = new PdfPTable(11);
		Stream.of("coustmer_Id", "coustmer_Name", "gender", "plan_Name", "plan_Status", "plan_start_date", "plan_end_date", "benefit_amount", "Denial_Reason", "terminated_date", "terminated_Reason").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
			header.setBackgroundColor(Color.ORANGE);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(2);
			table.setWidthPercentage(100f);
			
			header.setPhrase(new Phrase(headerTitle, headFont));
			table.addCell(header);

		});
		
		policy = repo.findAll();
		
		for(InsurancePolicy p : policy) {
			PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(p.getCoustmerId())));
			idCell.setPadding(1);
			idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(idCell);
			
			PdfPCell customerName = new PdfPCell(new Phrase(p.getCoustmerName()));
			customerName.setPadding(1);
			customerName.setVerticalAlignment(Element.ALIGN_MIDDLE);
			customerName.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(customerName);
			
			PdfPCell gender = new PdfPCell(new Phrase(p.getGender()));
			gender.setPadding(1);
			gender.setVerticalAlignment(Element.ALIGN_MIDDLE);
			gender.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(gender);
			
			PdfPCell planName = new PdfPCell(new Phrase(p.getPlanName()));
			planName.setPadding(1);
			planName.setVerticalAlignment(Element.ALIGN_MIDDLE);
			planName.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(planName);
			
			PdfPCell planStatus = new PdfPCell(new Phrase(p.getPlanStatus()));
			planName.setPadding(1);
			planName.setVerticalAlignment(Element.ALIGN_MIDDLE);
			planName.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(planStatus);
			
			if(null != p.getPlanStartDate()) {
				PdfPCell startDate = new PdfPCell(new Phrase(String.valueOf(p.getPlanStartDate())));
				startDate.setPadding(1);
				startDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
				startDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(startDate);
			}else {
				PdfPCell startDate = new PdfPCell(new Phrase("-"));
				startDate.setPadding(1);
				startDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
				startDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(startDate);
			}
			
			if(null != p.getPlanEndDate()) {
				PdfPCell endDate = new PdfPCell(new Phrase(String.valueOf(p.getPlanEndDate())));
				endDate.setPadding(1);
				endDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
				endDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(endDate);
			}else {
				PdfPCell endDate = new PdfPCell(new Phrase("-"));
				endDate.setPadding(1);
				endDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
				endDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(endDate);
			}
			
			if(null != p.getBenefitAmount()) {
				PdfPCell amount = new PdfPCell(new Phrase(String.valueOf(p.getBenefitAmount())));
				amount.setPadding(1);
				amount.setVerticalAlignment(Element.ALIGN_MIDDLE);
				amount.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(amount);
			}else {
				PdfPCell amount = new PdfPCell(new Phrase("N/A"));
				amount.setPadding(1);
				amount.setVerticalAlignment(Element.ALIGN_MIDDLE);
				amount.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(amount);
			}
			
			if( null != p.getDenialReason()) {
				PdfPCell DenialReason = new PdfPCell(new Phrase(p.getDenialReason()));
				DenialReason.setPadding(1);
				DenialReason.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DenialReason.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(DenialReason);
			}else {
				PdfPCell DenialReason = new PdfPCell(new Phrase("-"));
				DenialReason.setPadding(1);
				DenialReason.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DenialReason.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(DenialReason);
			}
			
			if( null != p.getTerminatedDate()) {
				PdfPCell terminatedDate = new PdfPCell(new Phrase(String.valueOf(p.getTerminatedDate())));
				terminatedDate.setPadding(1);
				terminatedDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
				terminatedDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(terminatedDate);
			}else {
				PdfPCell terminatedDate = new PdfPCell(new Phrase("-"));
				terminatedDate.setPadding(1);
				terminatedDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
				terminatedDate.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(terminatedDate);
			}
			
			if( null != p.getTerminatedReason()) {
				PdfPCell terminatedReason = new PdfPCell(new Phrase(p.getTerminatedReason()));
				terminatedReason.setPadding(1);
				terminatedReason.setVerticalAlignment(Element.ALIGN_MIDDLE);
				terminatedReason.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(terminatedReason);
			}else {
				PdfPCell terminatedReason = new PdfPCell(new Phrase("-"));
				terminatedReason.setPadding(1);
				terminatedReason.setVerticalAlignment(Element.ALIGN_MIDDLE);
				terminatedReason.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(terminatedReason);
			}
		}
		doc.add(table);
		doc.close();
		
	}

}
