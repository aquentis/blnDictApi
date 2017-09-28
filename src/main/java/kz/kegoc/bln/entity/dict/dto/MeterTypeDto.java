package kz.kegoc.bln.entity.dict.dto;

import lombok.Data;

@Data
public class MeterTypeDto {
	private Long id;
	private String code;
	private String name;
	private String manufacturer;
	private Double ratedCurrent;
	private Double ratedVoltage;
	private Double accuracyClass;
	private Double minimumLoad;
	private Double maximumLoad;
}