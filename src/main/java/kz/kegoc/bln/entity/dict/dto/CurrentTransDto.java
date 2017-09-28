package kz.kegoc.bln.entity.dict.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CurrentTransDto {
	private Long id;
	private String code;
	private String name;
	private String manufacturer;
	private Long companyId;
	private String companyName;
	private String serialNumber;
	private Double ratedCurrent1;
	private Double ratedCurrent2;
	private Double accuracyClass;
	private Double minCurrent;
	private Double maxCurrent;
	private Date lastVerificationDate;
	private Date nextVerificationDate;		
}