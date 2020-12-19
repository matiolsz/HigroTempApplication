package pl.olszanka.HigroTempApplication.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olszanka.HigroTempApplication.dao.MeasurementRepo;
import pl.olszanka.HigroTempApplication.domain.Measurement;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MeasurementService {
    private MeasurementRepo measurementRepo;

    @Autowired
    public MeasurementService(MeasurementRepo measurementRepo){
        this.measurementRepo=measurementRepo;
    }

    public boolean existsById(Long id){
        return measurementRepo.existsById(id);
    }

    public Measurement create(Measurement measurement){
        return measurementRepo.save(measurement);
    }

    public Measurement getOne(Long id){
        if(measurementRepo.existsById(id)) {
            return measurementRepo.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public List<Measurement> getAll(){
        return Lists.newArrayList(measurementRepo.findAll());
    }

    public void  delete(Long id){
        if(measurementRepo.existsById(id)) {
            measurementRepo.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void deleteAll(){
        measurementRepo.deleteAll();
    }
}
