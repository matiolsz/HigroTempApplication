package pl.olszanka.HigroTempApplication.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.olszanka.HigroTempApplication.dao.RoomRepo;
import pl.olszanka.HigroTempApplication.domain.Room;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoomService {

    private RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo){
        this.roomRepo=roomRepo;
    }

    private boolean existsById(Long id){
        return roomRepo.existsById(id);
    }

    public Room create(Room room){
        return roomRepo.save(room);
    }

    public List<Room> getAll() {
        return Lists.newArrayList(roomRepo.findAll());
    }

    public Room get(Long id) {
        if(roomRepo.existsById(id)) {
            return roomRepo.findById(id).get();
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public void delete(Long id){
        if(roomRepo.existsById(id)) {
            roomRepo.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    public Room put(Room room) {
        return roomRepo.save(room);
    }
}
