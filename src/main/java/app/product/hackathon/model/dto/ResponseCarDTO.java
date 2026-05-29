package app.product.hackathon.model.dto;

import app.product.hackathon.model.entity.Car;
import app.product.hackathon.model.entity.CarStatus;
import lombok.Data;

@Data
public class ResponseCarDTO extends Car {
	private String model;
	private String brand;
	private Double price;
	private CarStatus status;
	private Boolean isDeleted;
}
