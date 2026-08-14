package com.pet_adoption_center.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {




    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false, length = 100)
    private String createdBy;

    /** Username or user ID of the principal who last modified this record. */
    @LastModifiedBy
    @Column(name = "updated_by", nullable = false, length = 100)
    private String updatedBy;

    // ─── Audit: WHEN ─────────────────────────────────────────────────────────

    /** Timestamp when the record was first persisted. Never updated afterward. */
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Timestamp of the most recent update. */
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ─── Soft-delete (optional — remove if not needed) ───────────────────────

    /** When non-null, the record is considered logically deleted. */
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    /** Convenience method: true when this record has been soft-deleted. */
    @Transient
    public boolean isDeleted() {
        return deletedAt != null;
    }
}