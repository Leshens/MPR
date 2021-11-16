package leshen.org.MPR5.Service;

import leshen.org.MPR5.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        carRepository.save(new Car("Diesel","Mercedes","White"));
        carRepository.save(new Car("Diesel","Fiat","Red"));
        carRepository.save(new Car("V8","Mercedes","Silver"));
        carRepository.save(new Car("LPG","Ferrari","Yellow"));
    }

    public Car getSeviceCar(long id){
        return carRepository.findById(id);
    }
    public void makeCarById(long id, Car car){
        car.setId(id);
        carRepository.save(car);
    }
    public void deleteCarById(long id){
      carRepository.deleteById(id);
    }
    public void updateCarById(long id, Car car){
    //    carHashMap.replace(id, car);
    }

}
