package controller;

import domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.SensorService;

import java.util.Optional;

@Controller
@RequestMapping("/sensors/")
public class SensorController {
    private SensorService sensorService;

    @Autowired
    private SensorController(SensorService sensorService){
        this.sensorService=sensorService;
    }

    @PostMapping
    public Sensor create(@RequestParam Sensor sensor){
        return sensorService.create(sensor);
    }

    @GetMapping
    public Iterable<Sensor> getAll(){
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Sensor> getOne(Long id){
        return sensorService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        sensorService.delete(id);
    }

    @PutMapping("/{id}")
    public Sensor put(@RequestBody Sensor sensor){
        return sensorService.create(sensor);
    }



}
