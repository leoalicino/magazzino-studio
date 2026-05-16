package it.leoalicino.studio_magazzino.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import it.leoalicino.studio_magazzino.domain.Item;
import it.leoalicino.studio_magazzino.dto.item.request.CreateItemRequest;
import it.leoalicino.studio_magazzino.dto.item.request.UpdateItemRequest;
import it.leoalicino.studio_magazzino.dto.item.response.ItemResponse;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "id", ignore = true)
    Item toItem(CreateItemRequest request);

    ItemResponse toItemResponse(Item item);


    @Mapping(target = "id", ignore = true)
    void updateItemFromRequest(UpdateItemRequest request, @MappingTarget Item item);
}