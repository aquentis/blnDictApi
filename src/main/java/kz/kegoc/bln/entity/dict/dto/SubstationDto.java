package kz.kegoc.bln.entity.dict.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubstationDto {
	private Long id;
	private String code;
	private String name;
	private String shortName;
	private Long substationTypeId;
	private String substationTypeName;	
	private Double voltageClass;
	private String address;
}
