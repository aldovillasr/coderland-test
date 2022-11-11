package com.coderland.assessment.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coderland.assessment.models.Car;
import com.coderland.assessment.models.CarNotFoundException;
import com.coderland.assessment.models.CarRepository;

@RestController
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	@GetMapping("/cars/{id}")
	public Car getCar(@PathVariable long id) {
		Optional<Car> car = carRepository.findById(id);
		
		if(car.isEmpty()) {
			throw new CarNotFoundException("Car not found with ID: " + id);
		}
		
		return car.get();
	}
	
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable long id) {
		carRepository.deleteById(id);
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Object> createCar(@RequestBody Car car){
		Car savedCar = carRepository.save(car);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCar.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<Object> updateCar(@RequestBody Car car, @PathVariable long id){
		Optional<Car> carOptional = carRepository.findById(id);
		
		if(carOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		car.setId(id);
		carRepository.save(car);
		
		return ResponseEntity.noContent().build();
	}
}
