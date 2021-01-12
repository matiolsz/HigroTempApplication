package pl.olszanka.HigroTempApplication.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.olszanka.HigroTempApplication.domain.Sensor;

@Repository
public interface SensorRepo extends PagingAndSortingRepository<Sensor,Long> {


}
