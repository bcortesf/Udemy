package com.company.jpa.entitys;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

/*Auditoria o Trazabilidad para clases Entitys */

//Enbeber-Integrar
@Embeddable
public class Audit {
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    /*EVENTOS: CICLO DE VIDA OBJETO ENTITY */
    @PrePersist
    public void prePersist() {
        System.out.println("\n*Evento del CICLO-DE-VIDA del entity: pre-persist\n");
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        System.out.println("\n*Evento del CICLO-DE-VIDA del entity: pre-update\n");
        this.updatedAt =  LocalDateTime.now();
    }
    @PreRemove
    public void preRemove() {
        System.out.println("\n*Evento del CICLO-DE-VIDA del entity: pre-remove\n");
        this.deletedAt = LocalDateTime.now();
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
    @Override
    public String toString() {
        return "Audit [createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
    }

}
