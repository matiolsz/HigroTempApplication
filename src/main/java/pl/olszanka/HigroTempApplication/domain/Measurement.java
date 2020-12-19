package pl.olszanka.HigroTempApplication.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Measurement implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Double measurement;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Sensor sensor;

    private Long timestamp;

    public Measurement( Double measurement, Long timestamp, Sensor sensor) {
        this.measurement = measurement;
        this.timestamp = timestamp;
        this.sensor = sensor;
    }
}
