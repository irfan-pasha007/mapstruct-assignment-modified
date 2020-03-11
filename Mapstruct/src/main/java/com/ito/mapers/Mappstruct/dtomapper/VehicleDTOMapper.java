package com.ito.mapers.Mappstruct.dtomapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.ito.mapers.Mappstruct.Vehicle;
import com.ito.mapers.Mappstruct.dtos.VehicleDTO;

@Mapper(componentModel = "spring")
public interface VehicleDTOMapper {
	VehicleDTOMapper mapper = Mappers.getMapper(VehicleDTOMapper.class);

	@Mapping(source = "vehicle.vehicleId", target = "vehicleId")
	@Mapping(source = "vehicle.vehicleModel", target = "vehicleModel")
	@Mapping(source = "vehicle.location.locationId", target = "locationId")
	@Mapping(source = "vehicle.location.locationName", target = "locationName")
	VehicleDTO VehicleToVehicleDTO(Vehicle vehicle);

	@Mapping(source = "vehicleId", target = "vehicleId")
	@Mapping(source = "vehicleModel", target = "vehicleModel")
	@Mapping(source = "locationId", target = "location.locationId")
	@Mapping(source = "locationName", target = "location.locationName")
	Vehicle VehicleDTOToVehicle(VehicleDTO vehicledto);

}
