package service;

import dao.SensorRepo;
import domain.Measurement;
import domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {
    private SensorRepo sensorRepo;

    @Autowired
    public SensorService(SensorRepo sensorRepo){
        this.sensorRepo=sensorRepo;
    }

    public Optional<Sensor> getOne(Long id){
        return sensorRepo.findById(id);
    }

    public Iterable<Sensor> findAll(){
        return sensorRepo.findAll();
    }

    public Sensor create(Sensor sensor1){
        return sensorRepo.save(sensor1);
    }

    public void delete(Long id){
        sensorRepo.deleteById(id);
    }

}
