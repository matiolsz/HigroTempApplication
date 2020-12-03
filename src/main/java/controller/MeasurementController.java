package controller;


import domain.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.MeasurementService;
import service.SensorService;

import java.util.Optional;

@Controller
@RequestMapping("/measurement/")

public class MeasurementController {

    private MeasurementService measurementService;

    @Autowired
    private MeasurementController(MeasurementService measurementService){
        this.measurementService=measurementService;
    }

    @GetMapping
    public Iterable<Measurement> getAll(){
         return measurementService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Measurement> getOne(@RequestParam Long id){
        return measurementService.getOne(id);
    }

    @DeleteMapping
    void deleteAll(){
        measurementService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        measurementService.delete(id);
    }

}
