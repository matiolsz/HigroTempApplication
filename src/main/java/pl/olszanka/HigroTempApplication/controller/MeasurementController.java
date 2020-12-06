package pl.olszanka.HigroTempApplication.controller;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.olszanka.HigroTempApplication.domain.Measurement;
import pl.olszanka.HigroTempApplication.service.MeasurementService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/measurement/")

public class MeasurementController {

    private MeasurementService measurementService;

    @Autowired
    private MeasurementController(MeasurementService measurementService){
        this.measurementService=measurementService;
    }


    @GetMapping
    public List<Measurement> getAll(){
         return Lists.newArrayList(measurementService.getAll());
    }

    @GetMapping("/{id}")
    public Measurement getOne(@PathVariable Long id){
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

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String measurementNotFound() {
        return "mamakikiriki";
    }



}
