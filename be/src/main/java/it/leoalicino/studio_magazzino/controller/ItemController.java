package it.leoalicino.studio_magazzino.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.leoalicino.studio_magazzino.domain.Item;
import it.leoalicino.studio_magazzino.dto.item.request.CreateItemRequest;
import it.leoalicino.studio_magazzino.dto.item.response.ItemResponse;
import it.leoalicino.studio_magazzino.mapper.ItemMapper;
import it.leoalicino.studio_magazzino.service.ItemService;

@RestController
@RequestMapping("/items")
@Tag(name = "Items", description = "Gestione Prodotti")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    @GetMapping("/{id}")
    public ItemResponse getById(@PathVariable Long id) {
        return itemMapper.toItemResponse(itemService.findById(id));
    }

    @PostMapping
    public ItemResponse createItem(@RequestBody CreateItemRequest request) {
        Item item = itemMapper.toItem(request);
        Item savedItem = itemService.saveItem(item);

        return itemMapper.toItemResponse(savedItem);
    }

    @PutMapping("/{id}")
    public ItemResponse updateItem(@PathVariable Long id, @RequestBody CreateItemRequest request) {
        Item item = itemMapper.toItem(request);
        Item updatedItem = itemService.modifyItem(id, item);

        return itemMapper.toItemResponse(updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/all")
    public List<ItemResponse> getAllItems() {
        List<ItemResponse> items = new ArrayList<>();

        for (Item item : itemService.findAllItems()) {
            items.add(itemMapper.toItemResponse(item));
        }

        return items;
    }
}