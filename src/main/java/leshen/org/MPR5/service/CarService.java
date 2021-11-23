package leshen.org.MPR5.service;

import leshen.org.MPR5.car.Car;
import leshen.org.MPR5.exception.CarAlreadyExistException;
import leshen.org.MPR5.exception.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Car getSeviceCar(long id) throws CarNotFoundException {
        if (!carRepository.existsCarById(id)){
            throw new CarNotFoundException();
        }
        return carRepository.findById(id);
    }
    public void makeCarById(long id, Car car) throws CarAlreadyExistException{
        if (carRepository.existsCarById(id)){
            throw new CarAlreadyExistException();
        }
        car.setId(id);
        carRepository.save(car);
    }
    public void deleteCarById(long id){
      carRepository.deleteById(id);
    }
    public void updateCarById(long id, Car car){
        carRepository.save(car);
    }

}
