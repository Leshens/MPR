package leshen.org.MPR5.Service;

import leshen.org.MPR5.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    public Car findById(long id);
    public long deleteById(long id);
}
