package com.ito.mapers.Mappstruct.mappService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ito.mapers.Mappstruct.Location;
import com.ito.mapers.Mappstruct.dtomapper.LocationDTOMapper;
import com.ito.mapers.Mappstruct.dtos.LocationDTO;

import com.ito.mapers.Mappstruct.mappRepository.LocationRepository;

@Service
public class LocationService {
	Logger logger = Logger.getLogger(LocationService.class);
	@Autowired
	LocationRepository repos;

	@Autowired
	LocationDTOMapper lvdm;

	public Location saveLocation(LocationDTO locationdto) {
		logger.info("location saved successfully");
		return repos.save(lvdm.LocationDTOToLocation(locationdto));
	}

	public LocationDTO retrieveLocation(int locationId) {
		Optional<Location> location = repos.findById(locationId);
		Location loc = location.get();
		logger.info("location retrieved successfully");
		return lvdm.locationToLocationDTO(loc);

	}

	public List<LocationDTO> retrievealllocationdto() {
		Iterable<Location> loc = repos.findAll();
		Iterator<Location> itr = loc.iterator();
		List<LocationDTO> l = new ArrayList<LocationDTO>();
		while (itr.hasNext()) {

			Location location = itr.next();
			l.add(lvdm.locationToLocationDTO(location));
		}
		logger.info("list of locationdto retrieved successfully");
		return l;
	}

	public Location updatelocation(LocationDTO locationdto) {
		Location location = lvdm.LocationDTOToLocation(locationdto);
		logger.info("location updated successfully");
		return repos.save(location);
	}

}
