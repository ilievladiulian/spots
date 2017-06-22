package systems.ab4.workshop.spots.locations;

import systems.ab4.workshop.spots.spots.Spot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Vlad on 22/06/2017.
 */
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private Location parent;

    @Enumerated(EnumType.STRING)
    private LocationType type;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER) //incarca tot; LAZY - nu incarca
    private List<Location> children;

    @OneToMany(mappedBy = "location")
    private List<Spot> spots;

    public Location() {

    }

    public Location(String name, Location parent, LocationType type) {
        this.name = name;
        this.parent = parent;
        this.type = type;
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

    public Location getParent() {
        return parent;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public List<Location> getChildren() {
        return children;
    }

    public void setChildren(List<Location> children) {
        this.children = children;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    @Override
    public String toString() {
        return String.format("Location[id=%d, name='%s', parent='%s', type='%s', childrenSize='%s'", id, name, parent, type, (children != null ? children.size() : 0));
    }
}
