package pl.olszanka.HigroTempApplication.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olszanka.HigroTempApplication.dao.SensorRepo;
import pl.olszanka.HigroTempApplication.domain.Sensor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SensorService {

    private SensorRepo sensorRepo;

    @Autowired
    public SensorService(SensorRepo sensorRepo){
        this.sensorRepo=sensorRepo;
    }

    public boolean existsById(Long id){
        return sensorRepo.existsById(id);
    }

    public Sensor getOne(Long id){
        if(sensorRepo.existsById(id)) {
            return sensorRepo.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public List<Sensor> findAll(){
        return Lists.newArrayList(sensorRepo.findAll());
    }

    public Sensor create(Sensor sensor1){
        return sensorRepo.save(sensor1);
    }

    public void delete(Long id){
        if(sensorRepo.existsById(id)) {
            sensorRepo.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

}
