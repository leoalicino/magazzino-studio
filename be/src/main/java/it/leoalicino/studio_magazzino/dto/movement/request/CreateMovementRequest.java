package it.leoalicino.studio_magazzino.dto.movement.request;

import it.leoalicino.studio_magazzino.domain.MovementStatus;

public class CreateMovementRequest {

    private String description;
    private MovementStatus status;
    private Long itemId;

    public CreateMovementRequest() {
    }

    public CreateMovementRequest(String description, MovementStatus status, Long itemId) {
        this.description = description;
        this.status = status;
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovementStatus getStatus() {
        return status;
    }

    public void setStatus(MovementStatus status) {
        this.status = status;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
