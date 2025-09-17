package com.cataas.cataas.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @Column(length = 40, nullable = false, updatable = false)
    private String id;

    @ElementCollection
    @CollectionTable(name = "cat_tags", joinColumns = @JoinColumn(name = "cat_id"))
    @Column(name = "tag")
    private List<String> tags;

    @Column(name = "mimetype")
    private String mimetype;

    @Column(name = "created_at", nullable = true)
    private Instant createdAt;

    public Cat() {}

    public Cat(String id, List<String> tags, String mimetype, Instant createdAt) {
        this.id = id;
        this.tags = tags;
        this.mimetype = mimetype;
        this.createdAt = createdAt;
    }

    public String getId() { return id; }
    public List<String> getTags() { return tags; }
    public String getMimetype() { return mimetype; }
    public Instant getCreatedAt() { return createdAt; }

    public void setTags(List<String> tags) { this.tags = tags; }
    public void setMimetype(String mimetype) { this.mimetype = mimetype; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
