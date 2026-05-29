package app.product.hackathon.service;

import app.product.hackathon.model.dto.RequestCarDTO;
import app.product.hackathon.model.dto.ResponseCarDTO;
import app.product.hackathon.model.entity.Car;

import java.awt.print.Pageable;
import java.util.List;

public interface CarService {
	List<Car> getAll();
	Car getCarById(Long id);
	Car addCar(ResponseCarDTO car);
	Car updateCar(Long id, ResponseCarDTO car);
	void  deleteCar(Long id);
	Pageable getCarByModelOrByBrand(Pageable pageable);
}
