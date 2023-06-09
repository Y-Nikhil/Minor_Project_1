package com.ashokit.entity;
  

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data 
@Entity
@Table(name="Insurance_Policy")
public class InsurancePolicy {
	
	@Id
	@GeneratedValue
	private Integer coustmerId;
	private String coustmerName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmount;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminatedReason;
	
}
