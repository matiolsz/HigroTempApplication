package pl.olszanka.HigroTempApplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(SensorController.class);


    @Autowired
    private SensorController(SensorService sensorService){
        this.sensorService=sensorService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Sensor create(@RequestBody Sensor sensor){
        logger.info("Dodano nowy czujnik");
        return sensorService.create(sensor);
    }

    @GetMapping
    public List<Sensor> getAll(){
        logger.info("Wyświetlam wszystkie sensory");
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
        return "Nie ma takiego rekordu";
    }

}
