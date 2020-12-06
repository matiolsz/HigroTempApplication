package pl.olszanka.HigroTempApplication.dao;


import pl.olszanka.HigroTempApplication.domain.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends CrudRepository<Measurement , Long > {
}
