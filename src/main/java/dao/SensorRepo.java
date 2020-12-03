package dao;


import domain.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepo extends CrudRepository<Sensor,Long> {

}
