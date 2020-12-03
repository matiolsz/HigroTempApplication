package service;

import dao.RoomRepo;
import domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    private RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo){
        this.roomRepo=roomRepo;
    }

    public Room create(Room room){
        return roomRepo.save(room);
    }

    public Iterable<Room> getAll() {
        return roomRepo.findAll();
    }

    public Optional<Room> get(Long id) {
        return roomRepo.findById(id);
    }

    public void delete(Long id){
         roomRepo.deleteById(id);
    }


    public Room put(Room room) {
        return roomRepo.save(room);
    }
}
