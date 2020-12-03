package controller;

import domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.RoomService;

import java.util.Optional;

@Controller
@RequestMapping("/room/")
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
    public Iterable<Room> getAll(){
       return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> get(@RequestParam Long id){
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

}
