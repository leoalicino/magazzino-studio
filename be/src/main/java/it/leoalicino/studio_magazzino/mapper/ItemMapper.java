package it.leoalicino.studio_magazzino.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import it.leoalicino.studio_magazzino.domain.Item;
import it.leoalicino.studio_magazzino.dto.request.CreateItemRequest;
import it.leoalicino.studio_magazzino.dto.request.UpdateItemRequest;
import it.leoalicino.studio_magazzino.dto.response.ItemResponse;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toItem(CreateItemRequest request);
    ItemResponse toItemResponse(Item item);
    void updateItemFromRequest(UpdateItemRequest request, @MappingTarget Item item);


}
    