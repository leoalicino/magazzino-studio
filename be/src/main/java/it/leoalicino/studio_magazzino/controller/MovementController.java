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
import it.leoalicino.studio_magazzino.domain.Movement;
import it.leoalicino.studio_magazzino.dto.movement.request.CreateMovementRequest;
import it.leoalicino.studio_magazzino.dto.movement.request.UpdateMovementRequest;
import it.leoalicino.studio_magazzino.dto.movement.response.MovementResponse;
import it.leoalicino.studio_magazzino.mapper.MovementMapper;
import it.leoalicino.studio_magazzino.service.MovementService;

@RestController
@RequestMapping("/movements")
@Tag(name = "Movements", description = "Gestione Movimenti")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @Autowired
    private MovementMapper movementMapper;

    @GetMapping("/{id}")
    public MovementResponse getById(@PathVariable Long id) {
        return movementMapper.toMovementResponse(movementService.findById(id));
    }

    @PostMapping
    public MovementResponse createMovement(@RequestBody CreateMovementRequest request) {
        Movement movement = movementMapper.toMovement(request);
        Movement savedMovement = movementService.saveMovement(movement, request.getItemId());

        return movementMapper.toMovementResponse(savedMovement);
    }

    @PutMapping("/{id}")
    public MovementResponse updateMovement(@PathVariable Long id, @RequestBody UpdateMovementRequest request) {
        Movement movement = new Movement();
        movementMapper.updateMovementFromRequest(request, movement);
        Movement updatedMovement = movementService.modifyMovement(id, movement, request.getItemId());

        return movementMapper.toMovementResponse(updatedMovement);
    }

    @DeleteMapping("/{id}")
    public void deleteMovement(@PathVariable Long id) {
        movementService.deleteMovement(id);
    }

    @GetMapping("/all")
    public List<MovementResponse> getAllMovements() {
        List<MovementResponse> movements = new ArrayList<>();

        for (Movement movement : movementService.findAllMovements()) {
            movements.add(movementMapper.toMovementResponse(movement));
        }

        return movements;
    }
}
