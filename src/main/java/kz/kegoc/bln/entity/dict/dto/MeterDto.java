package kz.kegoc.bln.entity.dict.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeterDto {
	private Long id;
	private String code;
	private String name;
	private String manufacturer;
	private String serialNumber;
	private Double ratedCurrent;
	private Double ratedVoltage;
	private Double accuracyClass;
	private Double minimumLoad;
	private Double maximumLoad;
	private Long companyId;
	private String companyName;
	private LocalDate lastVerificationDate;
	private LocalDate nextVerificationDate;
}
