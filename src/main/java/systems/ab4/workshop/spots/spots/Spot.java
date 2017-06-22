package systems.ab4.workshop.spots.spots;

import systems.ab4.workshop.spots.locations.Location;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by Vlad on 22/06/2017.
 */
@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Location location;

    @NotNull
    private Date startSeason;

    @NotNull
    private Date endSeason;

    @NotNull
    private double cost;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<Activity> activities;

    public Spot() {

    }

    public Spot(String name, Location location, Date startSeason, Date endSeason, double cost, Set<Activity> activities) {
        this.name = name;
        this.location = location;
        this.activities = activities;
        this.startSeason = startSeason;
        this.endSeason = endSeason;
        this.cost = cost;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getStartSeason() {
        return startSeason;
    }

    public void setStartSeason(Date startSeason) {
        this.startSeason = startSeason;
    }

    public Date getEndSeason() {
        return endSeason;
    }

    public void setEndSeason(Date endSeason) {
        this.endSeason = endSeason;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", startSeason=" + startSeason +
                ", endSeason=" + endSeason +
                ", cost=" + cost +
                ", activities=" + activities +
                '}';
    }
}
