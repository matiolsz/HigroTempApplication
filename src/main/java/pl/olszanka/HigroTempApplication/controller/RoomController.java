package pl.olszanka.HigroTempApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import pl.olszanka.HigroTempApplication.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.olszanka.HigroTempApplication.service.RoomService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    @Autowired
    private RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @PostMapping
    public Room create(@RequestBody Room room){
       return roomService.create(room);
    }

    @GetMapping
    public List<Room> getAll(){
       return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Room get(@RequestParam Long id){
       return roomService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id){
        roomService.delete(id);
    }

    @PutMapping
    public Room put(@RequestBody Room room){
        return roomService.put(room);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String roomNotFound() {
        return "mamakikiriki";
    }

}
