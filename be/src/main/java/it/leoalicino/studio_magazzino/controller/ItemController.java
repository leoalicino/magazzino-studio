package it.leoalicino.studio_magazzino.controller;

import org.springframework.web.bind.annotation.RestController;
import it.leoalicino.studio_magazzino.mapper.ItemMapper;
import it.leoalicino.studio_magazzino.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import it.leoalicino.studio_magazzino.domain.Item;
import it.leoalicino.studio_magazzino.dto.response.ItemResponse;
import it.leoalicino.studio_magazzino.dto.request.CreateItemRequest;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/items")     
@Tag(name = "Items", description = "Gestione Prodotti")          
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemMapper itemMapper;


    @GetMapping("/{id}")
    public ItemResponse getById(Long id){
        return itemMapper.toItemResponse(itemService.findById(id));
    }


    @PostMapping("/")
    public ItemResponse createItem(CreateItemRequest request){
        return itemMapper.toItemResponse(itemService.saveItem(itemMapper.toItem(request)));
    }

    @PutMapping("/{id}")
    public ItemResponse updateItem(Long id, CreateItemRequest request){   
        if(itemService.findById(id) == null){
            throw new RuntimeException("Item not found");
        }

        Item item = itemMapper.toItem(request);
        itemService.modifyItem(id, item);
        return itemMapper.toItemResponse(itemService.findById(id));   
    }

    @DeleteMapping("/{id}")
    public void deleteItem(Long id){
        if(itemService.findById(id) == null){
            throw new RuntimeException("Item not found");
        }
        itemService.deleteItem(id);
    }
}
