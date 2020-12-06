package pl.olszanka.HigroTempApplication.dao;

import pl.olszanka.HigroTempApplication.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository<Room,Long> {
}
