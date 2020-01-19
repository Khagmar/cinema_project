package pl.cinema.cinema_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class main_controller {

    @GetMapping(value = "/")
    public String showIndex(Model model) {
        model.addAttribute("name", "Work");
        return "index";
    }

    @GetMapping(value = "/kontakt")
    public String showContact(Model model) {
        model.addAttribute("contact", "coś tam");
        return "contact";
    }

    @GetMapping(value = "/cennik")
    public String showOffers(Model model) {
        model.addAttribute("offers", "Jakaś oferta");
        return "offers";
    }

    @GetMapping(value = "/repertuar")
    public String showNews(Model model) {
        model.addAttribute("news", "jakieś newsy");
        return "repertoire";
    }

    @GetMapping(value = "panel_administratora")
    public String logInAdminPane(Model model) {
        return "login";
    }

    @PostMapping(name = "login")
    public void loginData(Model model) {


    }
}
