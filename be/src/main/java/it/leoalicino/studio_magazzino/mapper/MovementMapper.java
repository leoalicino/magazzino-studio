package it.leoalicino.studio_magazzino.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import it.leoalicino.studio_magazzino.domain.Movement;
import it.leoalicino.studio_magazzino.dto.movement.request.CreateMovementRequest;
import it.leoalicino.studio_magazzino.dto.movement.request.UpdateMovementRequest;
import it.leoalicino.studio_magazzino.dto.movement.response.MovementResponse;

@Mapper(componentModel = "spring")
public interface MovementMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "item", ignore = true)
    Movement toMovement(CreateMovementRequest request);

    @Mapping(target = "itemId", source = "item.id")
    MovementResponse toMovementResponse(Movement movement);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "item", ignore = true)
    void updateMovementFromRequest(UpdateMovementRequest request, @MappingTarget Movement movement);
}
