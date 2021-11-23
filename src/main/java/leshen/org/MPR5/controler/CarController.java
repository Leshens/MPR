package leshen.org.MPR5.controler;

import leshen.org.MPR5.exception.CarAlreadyExistException;
import leshen.org.MPR5.exception.CarNotFoundException;
import leshen.org.MPR5.service.CarService;
import leshen.org.MPR5.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id){
      Car car =  carService.getSeviceCar(id);
      return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("car/add/{id}")
    public void createCar(@PathVariable long id, @RequestBody Car car){
       carService.makeCarById(id, car);
    }

    @PostMapping("car/del/{id}")
    public void deleteCar(@PathVariable long id){
       carService.deleteCarById(id);
    }

    @PostMapping("car/upd/{id}")
    public void updateCar(@PathVariable long id, @RequestBody Car car){
       carService.updateCarById(id, car);
    }

    @ExceptionHandler({CarNotFoundException.class})
    public ResponseEntity handleExemption404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({CarAlreadyExistException.class})
    public ResponseEntity handleExemption400() {
        return ResponseEntity.badRequest().build();
    }
}
