package pl.olszanka.HigroTempApplication.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.olszanka.HigroTempApplication.dao.RoomRepo;
import pl.olszanka.HigroTempApplication.dao.SensorRepo;
import pl.olszanka.HigroTempApplication.domain.Sensor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SensorService {

    private SensorRepo sensorRepo;
    private RoomRepo roomRepo;

    @Autowired
    public SensorService(SensorRepo sensorRepo, RoomRepo roomRepo){
        this.sensorRepo=sensorRepo;
        this.roomRepo=roomRepo;
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
        return Lists.newArrayList(sensorRepo.findAll(Sort.by("id")));
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

    public void addRoomToSensor(Long idSensor,Long idRoom ){
        Sensor sensor = getOne(idSensor);
        sensor.setRoom((roomRepo.findById(idRoom).get()));
        sensorRepo.save(sensor);
    }

}
