package com.ito.mapers.Mappstruct.mappController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ito.mapers.Mappstruct.Vehicle;
import com.ito.mapers.Mappstruct.dtos.VehicleDTO;
import com.ito.mapers.Mappstruct.mappService.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService vehicleservice;

	// save the object by passing DTO
	@PostMapping(path = "/savevehicle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vehicle saveVehicle(@RequestBody VehicleDTO vehicledto) {
		return vehicleservice.savevehicle(vehicledto);
	}

	// Retrieve DTO by passing Id.
	@RequestMapping(value = "/retrievevehicledto/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public VehicleDTO retrieveVehicle(@PathVariable int vehicleId) {
		return vehicleservice.retrievevehicleby(vehicleId);
	}

	// Retrieve all objects as DTO.
	@RequestMapping(value = "/retrieveallvehicledto", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehicleDTO> retrieveAllVehicledto() {
		return vehicleservice.retrieveallvehicleby();
	}

	// Update object by passing DTO.
	@PutMapping(path = "/updatevehicle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Vehicle updateVehicle(@RequestBody VehicleDTO vehicledto) {
		return vehicleservice.updatevehicle(vehicledto);
	}

}
