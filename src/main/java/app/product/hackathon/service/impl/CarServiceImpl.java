package app.product.hackathon.service.impl;

import app.product.hackathon.exception.CarNotFoundException;

import app.product.hackathon.model.dto.ResponseCarDTO;
import app.product.hackathon.model.entity.Car;
import app.product.hackathon.repository.CarRepository;
import app.product.hackathon.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepository;
	@Override
	public List<Car> getAll() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.findById(id).orElseThrow(()-> new CarNotFoundException("Không tìm thấy xe theo Id"));
	}

	@Override
	public Car addCar(ResponseCarDTO car) {
		Car newCar = new Car();
		newCar.setModel(car.getModel());
		newCar.setBrand(car.getBrand());
		newCar.setPrice(car.getPrice());
		newCar.setStatus(car.getStatus());
		newCar.setIsDeleted(car.getIsDeleted());
		return carRepository.save(newCar);
	}

	@Override
	public Car updateCar(Long id, ResponseCarDTO car) {
		Car carToUpdate = carRepository.findById(id).get();
		if (carToUpdate.getModel() != null) {
			carToUpdate.setModel(car.getModel());
		}
		if (carToUpdate.getBrand() != null) {
			carToUpdate.setBrand(car.getBrand());
		}
		if (carToUpdate.getPrice() != null) {
			carToUpdate.setPrice(car.getPrice());
		}
		if (carToUpdate.getStatus() != null) {
			carToUpdate.setStatus(car.getStatus());
		}
		if (carToUpdate.getIsDeleted() != null) {
			carToUpdate.setIsDeleted(carToUpdate.getIsDeleted());
		}
		return carRepository.save(carToUpdate) ;
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);

	}

	@Override
	public Pageable getCarByModelOrByBrand(Pageable pageable) {
		return null;
	}
}
