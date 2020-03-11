package com.ito.mapers.Mappstruct.dtomapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ito.mapers.Mappstruct.Location;

import com.ito.mapers.Mappstruct.dtos.LocationDTO;
import com.ito.mapers.Mappstruct.dtos.VehicleDTO;

@Mapper(componentModel = "spring", uses = VehicleDTO.class)
public interface LocationDTOMapper {
	@Mapping(source = "locationdto.locationId", target = "locationId")
	@Mapping(source = "locationdto.locationName", target = "locationName")
	@Mapping(source = "locationdto.address", target = "address")
	Location LocationDTOToLocation(LocationDTO locationdto);

	LocationDTO locationToLocationDTO(Location location);

}
