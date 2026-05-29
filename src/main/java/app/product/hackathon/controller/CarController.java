package app.product.hackathon.controller;

import app.product.hackathon.model.dto.RequestCarDTO;
import app.product.hackathon.model.dto.ResponseCarDTO;
import app.product.hackathon.model.entity.Car;
import app.product.hackathon.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
	@Autowired
	private CarService carService;
	@GetMapping
	public List<Car> findAll() {
		return carService.getAll();
	}
	@GetMapping("{id}")
	public ResponseEntity<ResponseCarDTO> findById(@PathVariable Long id) {
		ResponseCarDTO responseCarDTO = new ResponseCarDTO();
		Car existCar = carService.getCarById(id);
		responseCarDTO.setId(existCar.getId());
		responseCarDTO.setModel(existCar.getModel());
		responseCarDTO.setBrand(existCar.getBrand());
		responseCarDTO.setPrice(existCar.getPrice());
		responseCarDTO.setStatus(existCar.getStatus());

		return ResponseEntity.ok(responseCarDTO);
	}
	@PostMapping
	public ResponseEntity<ResponseCarDTO> create(@RequestBody @Valid RequestCarDTO car) {
		ResponseCarDTO responseCarDTO = new ResponseCarDTO();
		responseCarDTO.setModel(car.getModel());
		responseCarDTO.setBrand(car.getBrand());
		responseCarDTO.setPrice(car.getPrice());
		responseCarDTO.setStatus(car.getStatus());
		responseCarDTO.setIsDeleted(false);
		carService.addCar(responseCarDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseCarDTO);
	}
	@PutMapping("{id}")
	public ResponseEntity<ResponseCarDTO>  updatePut(@PathVariable Long id, @RequestBody @Valid RequestCarDTO car) {
		Car existCar = carService.getCarById(id);
		ResponseCarDTO responseCarDTO = new ResponseCarDTO();
		responseCarDTO.setId(existCar.getId());
		responseCarDTO.setModel(car.getModel() != null ? car.getModel() : existCar.getModel());
		responseCarDTO.setBrand(car.getBrand() != null ? car.getBrand() : existCar.getBrand());
		responseCarDTO.setPrice(car.getPrice() != null ? car.getPrice() : existCar.getPrice());
		responseCarDTO.setStatus(car.getStatus() != null ? car.getStatus() : existCar.getStatus());
		responseCarDTO.setIsDeleted(car.getIsDeleted() != null ? car.getIsDeleted() : existCar.getIsDeleted());
		carService.updateCar(id, responseCarDTO);
		return ResponseEntity.ok(responseCarDTO);
	}
	@PatchMapping("{id}")
	public ResponseEntity<ResponseCarDTO>  updatePatch(@PathVariable Long id, @RequestBody RequestCarDTO car) {
		Car existCar = carService.getCarById(id);
		ResponseCarDTO responseCarDTO = new ResponseCarDTO();
		responseCarDTO.setId(id);
		if (car.getModel() != null) {
			responseCarDTO.setModel(car.getModel());
		}
		if (car.getBrand() != null) {
			responseCarDTO.setBrand(car.getBrand());
		}
		if (car.getPrice() != null) {
			responseCarDTO.setPrice(car.getPrice());
		}
		if (car.getStatus() != null) {
			responseCarDTO.setStatus(car.getStatus());
		}
		if (car.getIsDeleted() != null) {
			responseCarDTO.setIsDeleted(car.getIsDeleted());
		}
		carService.updateCar(id, responseCarDTO);
		return ResponseEntity.ok(responseCarDTO);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseCarDTO> deleteById(@PathVariable Long id) {
		Car existCar = carService.getCarById(id);
		carService.deleteCar(id);
		return ResponseEntity.noContent().build();
	}
}
