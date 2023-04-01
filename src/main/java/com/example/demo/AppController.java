package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private GruzService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Gruz> listGruz = service.listAll(keyword);
        model.addAttribute("listGruz", listGruz);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewSessionForm(Model model){
        Gruz gruz = new Gruz();
        model.addAttribute("Gruz", gruz);
        return "new_index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("Session") Gruz gruz){
        service.save(gruz);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditSessionFrom(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_index");
        Gruz gruz = service.get(id);
        mav.addObject("Gruz", gruz);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";

    }


}