package com.ito.mapers.Mappstruct.mappService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ito.mapers.Mappstruct.Vehicle;
import com.ito.mapers.Mappstruct.dtomapper.VehicleDTOMapper;
import com.ito.mapers.Mappstruct.dtos.VehicleDTO;
import com.ito.mapers.Mappstruct.mappRepository.vehicleRepository;

@Service
public class VehicleService {

	@Autowired
	vehicleRepository repo;
	@Autowired
	VehicleDTOMapper lvm;

	Logger logger = Logger.getLogger(VehicleService.class);

	public Vehicle savevehicle(VehicleDTO vehicledto) {
		Vehicle vehicle = lvm.VehicleDTOToVehicle(vehicledto);
		logger.info("saved successfully");
		return repo.save(vehicle);
	}

	public VehicleDTO retrievevehicleby(int vehicleId) {
		Optional<Vehicle> vehicle = repo.findById(vehicleId);
		Vehicle veh = vehicle.get();
		logger.info("vehicle dto retrieved");
		return lvm.VehicleToVehicleDTO(veh);
	}

	public List<VehicleDTO> retrieveallvehicleby() {
		Iterable<Vehicle> veh = repo.findAll();
		Iterator<Vehicle> itr = veh.iterator();
		List<VehicleDTO> l = new ArrayList<VehicleDTO>();
		while (itr.hasNext()) {

			Vehicle vehicle = itr.next();
			l.add(lvm.VehicleToVehicleDTO(vehicle));
		}
		logger.info("retrieved all vehicles");
		return l;
	}

	public Vehicle updatevehicle(VehicleDTO vehicledto) 
	{	
		Vehicle vehicle = lvm.VehicleDTOToVehicle(vehicledto);
		logger.info("updated successfully");
		return repo.save(vehicle);
	}

}
