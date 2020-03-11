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

import com.ito.mapers.Mappstruct.Location;
import com.ito.mapers.Mappstruct.Vehicle;
import com.ito.mapers.Mappstruct.dtos.LocationDTO;
import com.ito.mapers.Mappstruct.dtos.VehicleDTO;
import com.ito.mapers.Mappstruct.mappService.LocationService;

@RestController
public class LocationController {
	@Autowired
	LocationService locationservice;

	// save the object by passing DTO
	@PostMapping(path = "/savelocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Location savelocation(@RequestBody LocationDTO locationdto) {
		return locationservice.saveLocation(locationdto);
	}

	// Retrieve DTO by passing Id.
	@RequestMapping(value = "/retrievelocationdto/{LocationId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LocationDTO retrievelocation(@PathVariable int LocationId) {
		return locationservice.retrieveLocation(LocationId);
	}

	// Retrieve all objects as DTO.
	@RequestMapping(value = "/retrievealllocationdto", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LocationDTO> retrieveAllLocationdto() {
		return locationservice.retrievealllocationdto();
	}

	// Update object by passing DTO.
	@PutMapping(path = "/updatelocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Location updateLocation(@RequestBody LocationDTO locationdto) {
		return locationservice.updatelocation(locationdto);
	}
}
