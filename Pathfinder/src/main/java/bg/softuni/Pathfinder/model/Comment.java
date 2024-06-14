package bg.softuni.Pathfinder.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private boolean approved;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false, name = "text_content", columnDefinition = "LONGTEXT")
    private String textContent;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    private Route route;

    public Comment() {
    }

    public Comment(long id, boolean approved, LocalDateTime created, String textContent, User author, Route route) {
        this.id = id;
        this.approved = approved;
        this.created = created;
        this.textContent = textContent;
        this.author = author;
        this.route = route;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
