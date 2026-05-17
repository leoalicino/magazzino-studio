package it.leoalicino.studio_magazzino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.leoalicino.studio_magazzino.domain.Item;
import it.leoalicino.studio_magazzino.domain.Movement;
import it.leoalicino.studio_magazzino.repository.ItemRepository;
import it.leoalicino.studio_magazzino.repository.MovementRepository;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Movement saveMovement(Movement movement, Long itemId) {
        Item item = itemRepository.findById(itemId).get();
        movement.setItem(item);
        return movementRepository.save(movement);
    }

    public void deleteMovement(Long id) {
        Movement movement = movementRepository.findById(id).get();
        movementRepository.delete(movement);
    }

    public Movement modifyMovement(Long id, Movement movement, Long itemId) {
        Movement savedMovement = movementRepository.findById(id).get();
        Item item = itemRepository.findById(itemId).get();

        savedMovement.setDescription(movement.getDescription());
        savedMovement.setStatus(movement.getStatus());
        savedMovement.setItem(item);

        movementRepository.save(savedMovement);
        return savedMovement;
    }

    public List<Movement> findAllMovements() {
        return movementRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Movement findById(Long id) {
        return movementRepository.findById(id).get();
    }
}
