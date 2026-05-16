package it.leoalicino.studio_magazzino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.leoalicino.studio_magazzino.repository.ItemRepository;
import it.leoalicino.studio_magazzino.domain.Item;
import java.util.List;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;  


    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public void deleteItem(Long id){
        Item i = itemRepository.findById(id).get();
        itemRepository.delete(i);
        
    }

    public Item modifyItem(Long id, Item item){
        Item i = itemRepository.findById(id).get();
        i.setName(item.getName());
        i.setDescription(item.getDescription());
        i.setPrice(item.getPrice());
        itemRepository.save(i);   
        return i; 
    }

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }


    public Item findById(Long id){
        return itemRepository.findById(id).get();
    }



}
