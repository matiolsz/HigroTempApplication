package pl.olszanka.HigroTempApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.olszanka.HigroTempApplication.domain.Sensor;
import pl.olszanka.HigroTempApplication.service.SensorService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private SensorService sensorService;

    @Autowired
    private SensorController(SensorService sensorService){
        this.sensorService=sensorService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Sensor create(@RequestBody Sensor sensor){
        System.out.println("dodano nowy czujnik");
        return sensorService.create(sensor);
    }

    @GetMapping
    public List<Sensor> getAll(){
        System.out.println("hurra");
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public Sensor getOne(Long id){
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

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String sensorNotFound() {
        return "mamakikiriki";
    }

}
