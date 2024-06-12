package bg.softuni.mobilele.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Brand {
    private Long id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Brand(Long id, String name, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
