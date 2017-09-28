package kz.kegoc.bln.entity.dict.dto;

import java.util.Date;

import lombok.*;

@Data
public class SubstationMeteringPointDto {
	private Long id;
	private Long substationId;
	private Long meteringPointId;
	private String meteringPointName;
	private Date startDate;
	private Date endDate;
}