package dao;


import domain.Measurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends CrudRepository<Measurement , Long > {
}
