package leshen.org.MPR5.Controler;

import leshen.org.MPR5.Service.CarService;
import leshen.org.MPR5.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarContoler {

    @Autowired
    private CarService carService;

    @Autowired
    public CarContoler(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable long id){
      return carService.getSeviceCar(id);
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

}
