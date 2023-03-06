package com.example.demo;

import java.util.List;

import jakarta.jws.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private CarService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Car> listCar = service.listAll(keyword);
        model.addAttribute("listCar", listCar);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewCarForm(Model model){
        Car car = new Car();
        model.addAttribute("Car", car);
        return "new_car";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("Car") Car car){
        service.save(car);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCarFrom(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = service.get(id);
        mav.addObject("Car", car);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";

    }


}