package kz.kegoc.bln.entity.dict.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentTransTypeDto {
	private Long id;
	private String code;
	private String name;
	private String manufacturer;
	private Double ratedCurrent1;
	private Double ratedCurrent2;
	private Double accuracyClass;
	private Double minCurrent;
	private Double maxCurrent;
}
