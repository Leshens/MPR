package leshen.org.MPR5.controler;

import leshen.org.MPR5.car.Car;
import leshen.org.MPR5.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarsController {

    CarService carService;

    @Autowired
    public CarsController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String displayCars(Model model){
        model.addAttribute("cars",carService.getCarsFromRepo());
        return "index";
    }
    @GetMapping("/cars/add")
    public String showAddCarsFrom(Model model){
        model.addAttribute("car",new Car());
        return "addForm";
    }
    @PostMapping("/cars/add")
    public String submitAddCarFrom(@ModelAttribute Car car, Model model){
        carService.insertCar(car);
        model.addAttribute("car",new Car());
        return "addForm";
    }
    @GetMapping("/cars/del")
    public String showDelCarsFrom(Model model){
        model.addAttribute("car",new Car());
        return "delForm";
    }
    @PostMapping("/cars/del")
    public String submitDelCarFrom(@ModelAttribute Car car, Model model){
        carService.deleteCarById(car.getId());
        model.addAttribute("car",new Car());
        return "delForm";
    }
    @GetMapping("/cars/upd")
    public String showUpdCarsFrom(Model model){
        model.addAttribute("car",new Car());
        return "updForm";
    }
    @PostMapping("/cars/upd")
    public String submitUpdCarFrom(@ModelAttribute Car car, Model model){
        carService.updateCarById(car.getId(), car);
        model.addAttribute("car",new Car());
        return "updForm";
    }
}
