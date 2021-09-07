package com.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class VehicleController {

	private final VehicleRepository repository;

	VehicleController(VehicleRepository repository) {
		this.repository = repository;
	}

	/**
	 * 1.find vehicles by make ,sorted by year DESC + pagination
	 * 
	 * @param make
	 * @param model
	 * @param page
	 * @param size
	 * @return Page<Vehicle>
	 */
	@GetMapping("/v1/vehicles")
	Page<Vehicle> findByMakeSorted(@RequestParam(value = "make", required = false) String make,
			@RequestParam(value = "model", required = false) String model,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		Page<Vehicle> vehicles = null;

		Pageable requestedPage = PageRequest.of(page, size, Sort.by(IConstants.FIELD_YEAR).descending());
		if (make != null && model != null) {
			vehicles = repository.findAllByMakeAndModel(make, model, requestedPage);
		} else if (make != null || model != null) {
			vehicles = repository.findAllByMakeOrModel(make, model, requestedPage);
		} else {
			vehicles = repository.findAll(requestedPage);
		}

		return vehicles;

	}

	/**
	 * 2.get vehicle by vin
	 * 
	 * @param vin
	 * @return
	 */
	@GetMapping("/v1/vehicles/{vin}")
	Vehicle getVehicle(@PathVariable String vin) {

		return repository.findByVIN(vin);
	}

	/**
	 * 3.create new vehicle
	 * 
	 * @param newVehicle
	 * @return create Vehicle object
	 */
	@PostMapping("/v1/vehicles")
	Vehicle newVehicle(@RequestBody Vehicle newVehicle) {

		
		return repository.save(newVehicle);
	}

	/**
	 * 4.delete vehicle by vin
	 * 
	 * @param vin
	 */
	@DeleteMapping("/vehicles/{vin}")
	void deleteVehicle(@PathVariable String vin) {
		repository.deleteByVIN(vin);
	}


	/**
	 * 6.update vehicle
	 * 
	 * @param newVehicle
	 * @param vin
	 * @return replaced vehicle
	 */
	@PutMapping("/v1/vehicles/{vin}")
	Vehicle updateVehicle(@RequestBody Vehicle newVehicle, @PathVariable String vin) {

		Vehicle vehicle = repository.findByVIN(vin);
		if (vehicle != null) {
			vehicle.setMake(newVehicle.getMake());
			vehicle.setModel(newVehicle.getModel());
			vehicle.setYear(newVehicle.getYear());
			vehicle.setSeatCapacity(newVehicle.getSeatCapacity());
			vehicle.setType(newVehicle.getType());
			vehicle.setRoofRackAvailable(newVehicle.getRoofRackAvailable());
			vehicle.setHaulCapacity(newVehicle.getHaulCapacity());
			vehicle.setSideCarAvailable(newVehicle.getSideCarAvailable());
		}
		return repository.save(newVehicle);
	}

	/**
	 * 6.replace by vin
	 * 
	 * @param vinToReplaceBy
	 * @param vinToReplace
	 * @return
	 */
	@PutMapping("/v1/vehicles")
	Vehicle replaceVehicle(@RequestParam String vinToReplaceBy, @RequestParam String vinToReplace) {

		Vehicle vehicle = repository.findByVIN(vinToReplaceBy);
		Vehicle oldvehicle = repository.findByVIN(vinToReplace);

		oldvehicle.setMake(vehicle.getMake());
		oldvehicle.setModel(vehicle.getModel());
		oldvehicle.setYear(vehicle.getYear());
		oldvehicle.setSeatCapacity(vehicle.getSeatCapacity());
		oldvehicle.setType(vehicle.getType());
		oldvehicle.setRoofRackAvailable(vehicle.getRoofRackAvailable());
		oldvehicle.setHaulCapacity(vehicle.getHaulCapacity());
		oldvehicle.setSideCarAvailable(vehicle.getSideCarAvailable());

		return repository.save(oldvehicle);
	}

}