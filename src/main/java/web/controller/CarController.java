package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String index(@RequestParam(name = "count", required = false) String count, Model model) {
        if (count != null && Integer.parseInt(count) < carService.listCars().size()) {
            model.addAttribute("cars", carService.listCars(Integer.parseInt(count)));
        } else {
            model.addAttribute("cars", carService.listCars());
        }

        return "cars";
    }
}
