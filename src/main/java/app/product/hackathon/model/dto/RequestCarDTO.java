package app.product.hackathon.model.dto;

import app.product.hackathon.model.entity.CarStatus;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RequestCarDTO {
	@NotEmpty(message = "Không được để trống model")
	private String model;
	@NotEmpty(message = "Không được để trống brand")
	private String brand;
	@Min(1)
	private Double price;
	private CarStatus status;

	private Boolean isDeleted =  Boolean.FALSE;
}
