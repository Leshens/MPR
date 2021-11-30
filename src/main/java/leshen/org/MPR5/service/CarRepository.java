package leshen.org.MPR5.service;

import leshen.org.MPR5.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    public Car findById(long id);
    public Long deleteById(long id);
    public boolean existsCarById(long id);
    List<Car> findAll();
}
