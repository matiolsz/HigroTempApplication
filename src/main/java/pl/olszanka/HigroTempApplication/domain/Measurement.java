package pl.olszanka.HigroTempApplication.domain;

import javax.persistence.*;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Double measurement;

    @ManyToOne
    private Sensor theSensor;

    private Long timestamp;

    public Measurement() {
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
}
