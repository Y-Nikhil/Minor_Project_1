package com.ashokit.Runner;

import java.time.LocalDate;    
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.InsurancePolicy;
import com.ashokit.repository.InsuranceRepository;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private InsuranceRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		System.out.println("Dlete all records...");
		InsurancePolicy i1 = new InsurancePolicy();
		i1.setCoustmerName("Nikhil");
		i1.setGender("Male");
		i1.setPlanName("Cash");
		i1.setPlanStatus("Approved");
		i1.setPlanStartDate(LocalDate.now());
		i1.setPlanEndDate(LocalDate.now().plusMonths(6));
		i1.setBenefitAmount(1000.00);
		
		InsurancePolicy i2 = new InsurancePolicy();
		i2.setCoustmerName("Neelima");
		i2.setGender("Fe-Male");
		i2.setPlanName("Cash");
		i2.setPlanStatus("Approved");
		i2.setPlanStartDate(LocalDate.now());
		i2.setPlanEndDate(LocalDate.now().plusMonths(6));
		i2.setBenefitAmount(1000.00);
		
		InsurancePolicy i3 = new InsurancePolicy();
		i3.setCoustmerName("Hari");
		i3.setGender("Male");
		i3.setPlanName("Cash");
		i3.setPlanStatus("Declined");
		i3.setDenialReason("Income");
		
		InsurancePolicy i4 = new InsurancePolicy();
		i4.setCoustmerName("Santhu");
		i4.setGender("Fe-Male");
		i4.setPlanName("Cash");
		i4.setPlanStatus("Declined");
		i4.setDenialReason("Income");
		
		InsurancePolicy i5 = new InsurancePolicy();
		i5.setCoustmerName("Venky");
		i5.setGender("Male");
		i5.setPlanName("Cash");
		i5.setPlanStatus("Terminated");
		i5.setPlanStartDate(LocalDate.now().minusMonths(2));
		i5.setPlanEndDate(LocalDate.now().plusMonths(4));
		i5.setTerminatedDate(LocalDate.now());
		i5.setTerminatedReason("Emoloyer");
		
		InsurancePolicy i6 = new InsurancePolicy();
		i6.setCoustmerName("Divya");
		i6.setGender("Fe-Male");
		i6.setPlanName("Cash");
		i6.setPlanStatus("Terminated");
		i6.setPlanStartDate(LocalDate.now().minusMonths(1));
		i6.setPlanEndDate(LocalDate.now().plusMonths(5));
		i6.setTerminatedDate(LocalDate.now());
		i6.setTerminatedReason("Employee");
		
		
		InsurancePolicy i7 = new InsurancePolicy();
		i7.setCoustmerName("Laxman");
		i7.setGender("Male");
		i7.setPlanName("Food");
		i7.setPlanStatus("Approved");
		i7.setPlanStartDate(LocalDate.now());
		i7.setPlanEndDate(LocalDate.now().plusMonths(6));
		i7.setBenefitAmount(1200.00);
		
		InsurancePolicy i8 = new InsurancePolicy();
		i8.setCoustmerName("Priya");
		i8.setGender("Fe-Male");
		i8.setPlanName("Food");
		i8.setPlanStatus("Approved");
		i8.setPlanStartDate(LocalDate.now());
		i8.setPlanEndDate(LocalDate.now().plusMonths(6));
		i8.setBenefitAmount(1200.00);
		
		InsurancePolicy i9 = new InsurancePolicy();
		i9.setCoustmerName("Sai");
		i9.setGender("Male");
		i9.setPlanName("Food");
		i9.setPlanStatus("Declined");
		i9.setDenialReason("Income");
		
		InsurancePolicy i10 = new InsurancePolicy();
		i10.setCoustmerName("Vennela");
		i10.setGender("Fe-Male");
		i10.setPlanName("Food");
		i10.setPlanStatus("Declined");
		i10.setDenialReason("Income");
		
		InsurancePolicy i11 = new InsurancePolicy();
		i11.setCoustmerName("Eshwar");
		i11.setGender("Male");
		i11.setPlanName("Food");
		i11.setPlanStatus("Terminated");
		i11.setPlanStartDate(LocalDate.now().minusMonths(3));
		i11.setPlanEndDate(LocalDate.now().plusMonths(3));
		i11.setTerminatedDate(LocalDate.now());
		i11.setTerminatedReason("Emoloyer");
		
		InsurancePolicy i12 = new InsurancePolicy();
		i12.setCoustmerName("Ramya");
		i12.setGender("Fe-Male");
		i12.setPlanName("Food");
		i12.setPlanStatus("Terminated");
		i12.setPlanStartDate(LocalDate.now().minusMonths(1));
		i12.setPlanEndDate(LocalDate.now().plusMonths(5));
		i12.setTerminatedDate(LocalDate.now());
		i12.setTerminatedReason("Employee");
		
		
		InsurancePolicy i13 = new InsurancePolicy();
		i13.setCoustmerName("Bharath");
		i13.setGender("Male");
		i13.setPlanName("Medical");
		i13.setPlanStatus("Approved");
		i13.setPlanStartDate(LocalDate.now());
		i13.setPlanEndDate(LocalDate.now().plusMonths(6));
		i13.setBenefitAmount(1500.00);
		
		InsurancePolicy i14 = new InsurancePolicy();
		i14.setCoustmerName("Pavani");
		i14.setGender("Fe-Male");
		i14.setPlanName("Medical");
		i14.setPlanStatus("Approved");
		i14.setPlanStartDate(LocalDate.now());
		i14.setPlanEndDate(LocalDate.now().plusMonths(6));
		i14.setBenefitAmount(1500.00);
		
		InsurancePolicy i15 = new InsurancePolicy();
		i15.setCoustmerName("Rakesh");
		i15.setGender("Male");
		i15.setPlanName("Medical");
		i15.setPlanStatus("Declined");
		i15.setDenialReason("Income");
		
		InsurancePolicy i16 = new InsurancePolicy();
		i16.setCoustmerName("Sravani");
		i16.setGender("Fe-Male");
		i16.setPlanName("Medical");
		i16.setPlanStatus("Declined");
		i16.setDenialReason("Income");
		
		InsurancePolicy i17 = new InsurancePolicy();
		i17.setCoustmerName("Ramana");
		i17.setGender("Male");
		i17.setPlanName("Medical");
		i17.setPlanStatus("Terminated");
		i17.setPlanStartDate(LocalDate.now().minusMonths(2));
		i17.setPlanEndDate(LocalDate.now().plusMonths(4));
		i17.setTerminatedDate(LocalDate.now());
		i17.setTerminatedReason("Emoloyer");
		
		InsurancePolicy i18 = new InsurancePolicy();
		i18.setCoustmerName("Barsha");
		i18.setGender("Fe-Male");
		i18.setPlanName("Medical");
		i18.setPlanStatus("Terminated");
		i18.setPlanStartDate(LocalDate.now().minusMonths(4));
		i18.setPlanEndDate(LocalDate.now().plusMonths(2));
		i18.setTerminatedDate(LocalDate.now());
		i18.setTerminatedReason("Emoloyer");
		
		
		InsurancePolicy i19 = new InsurancePolicy();
		i19.setCoustmerName("Rahul");
		i19.setGender("Male");
		i19.setPlanName("Employment");
		i19.setPlanStatus("Approved");
		i19.setPlanStartDate(LocalDate.now());
		i19.setPlanEndDate(LocalDate.now().plusMonths(6));
		i19.setBenefitAmount(1600.00);
		
		InsurancePolicy i20 = new InsurancePolicy();
		i20.setCoustmerName("Sindhu");
		i20.setGender("Fe-Male");
		i20.setPlanName("Employment");
		i20.setPlanStatus("Approved");
		i20.setPlanStartDate(LocalDate.now());
		i20.setPlanEndDate(LocalDate.now().plusMonths(6));
		i20.setBenefitAmount(1600.00);
		
		InsurancePolicy i21 = new InsurancePolicy();
		i21.setCoustmerName("Shiva");
		i21.setGender("Male");
		i21.setPlanName("Employment");
		i21.setPlanStatus("Declined");
		i21.setDenialReason("Income");
		
		InsurancePolicy i22 = new InsurancePolicy();
		i22.setCoustmerName("Kavitha");
		i22.setGender("Fe-Male");
		i22.setPlanName("Employment");
		i22.setPlanStatus("Declined");
		i22.setDenialReason("Income");
		
		InsurancePolicy i23 = new InsurancePolicy();
		i23.setCoustmerName("Devaraju");
		i23.setGender("Male");
		i23.setPlanName("Employment");
		i23.setPlanStatus("Terminated");
		i23.setPlanStartDate(LocalDate.now().minusMonths(1));
		i23.setPlanEndDate(LocalDate.now().plusMonths(5));
		i23.setTerminatedDate(LocalDate.now());
		i23.setTerminatedReason("Emoloyer");
		
		InsurancePolicy i24 = new InsurancePolicy();
		i24.setCoustmerName("Swapna");
		i24.setGender("Fe-Male");
		i24.setPlanName("Employment");
		i24.setPlanStatus("Terminated");
		i24.setPlanStartDate(LocalDate.now().minusMonths(3));
		i24.setPlanEndDate(LocalDate.now().plusMonths(3));
		i24.setTerminatedDate(LocalDate.now());
		i24.setTerminatedReason("Emoloyer");
		
		List<InsurancePolicy> lst = Arrays.asList(i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,i24);
		
		repo.saveAll(lst);
		System.out.println("Records Insertion Successfull....");
		
		
	}
	
}
