package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sensor {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    @ManyToOne
    private Room theRoom;

    @OneToMany(mappedBy = "theSensor")
    private List<Measurement> measurements;

    private String IP;

    public Sensor() {
    }

    public Sensor(Long id, String type, Room theRoom, List<Measurement> measurements, String IP) {
        this.id = id;
        this.type = type;
        this.theRoom = theRoom;
        this.measurements = measurements;
        this.IP = IP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Room getTheRoom() {
        return theRoom;
    }

    public void setTheRoom(Room theRoom) {
        this.theRoom = theRoom;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
