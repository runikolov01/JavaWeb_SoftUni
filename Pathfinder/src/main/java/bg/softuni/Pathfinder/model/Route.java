package bg.softuni.Pathfinder.model;

import bg.softuni.Pathfinder.model.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    private String values;

    @ManyToOne(optional = false)
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    public Route() {
    }

    public Route(long id, String name, String description, String gpxCoordinates, Level level, String values, User author, String videoUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.gpxCoordinates = gpxCoordinates;
        this.level = level;
        this.values = values;
        this.author = author;
        this.videoUrl = videoUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
