package service;

import dao.MeasurementRepo;
import domain.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurementService {
    private MeasurementRepo measurementRepo;

    @Autowired
    public MeasurementService(MeasurementRepo measurementRepo){
        this.measurementRepo=measurementRepo;
    }

    public Measurement create(Measurement measurement){
        return measurementRepo.save(measurement);
    }

    public Optional<Measurement> getOne(Long id){
        return measurementRepo.findById(id);
    }

    public Iterable<Measurement> getAll(){
        return measurementRepo.findAll();
    }

    public void  delete(Long id){
        measurementRepo.deleteById(id);
    }

    public void deleteAll(){
        measurementRepo.deleteAll();
    }
}
