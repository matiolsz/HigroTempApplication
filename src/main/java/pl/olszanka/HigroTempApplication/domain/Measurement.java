package pl.olszanka.HigroTempApplication.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Measurement implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Double measurement;

    @ManyToOne
    private Sensor theSensor;

    private Long timestamp;

    public Measurement() {
    }

    public Measurement(Double measurement) {
        this.measurement = measurement;
    }

    public Measurement(Long id, Double measurement, Sensor theSensor, Long timestamp) {
        this.id = id;
        this.measurement = measurement;
        this.theSensor = theSensor;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Double measurement) {
        this.measurement = measurement;
    }

    public Sensor getTheSensor() {
        return theSensor;
    }

    public void setTheSensor(Sensor theSensor) {
        this.theSensor = theSensor;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", measurement=" + measurement +
                ", theSensor=" + theSensor +
                ", timestamp=" + timestamp +
                '}';
    }
}
