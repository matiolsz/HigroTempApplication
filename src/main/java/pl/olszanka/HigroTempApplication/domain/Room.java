package pl.olszanka.HigroTempApplication.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "theRoom")
    private List<Sensor> sensors;

    public Room() {
    }

    public Room(Long id, String name, List<Sensor> sensors) {
        this.id = id;
        this.name = name;
        this.sensors = sensors;
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

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

}

