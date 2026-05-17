package it.leoalicino.studio_magazzino.dto.movement.response;

import it.leoalicino.studio_magazzino.domain.MovementStatus;

public class MovementResponse {

    private Long id;
    private String description;
    private MovementStatus status;
    private Long itemId;

    public MovementResponse() {

    }

    public MovementResponse(Long id, String description, MovementStatus status, Long itemId) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.itemId = itemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
