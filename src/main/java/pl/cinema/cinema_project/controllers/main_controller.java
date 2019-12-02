package pl.cinema.cinema_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main_controller {

    @GetMapping(value = "/")
    public String showIndex(Model model) {
        model.addAttribute("name", "Work");
        return "index";
    }
}
