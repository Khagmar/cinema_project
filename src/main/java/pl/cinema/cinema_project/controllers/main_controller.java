package pl.cinema.cinema_project.controllers;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cinema.cinema_project.controllers.commands.NewsFilter;
import pl.cinema.cinema_project.models.News;
import pl.cinema.cinema_project.models.Reservation;
import pl.cinema.cinema_project.services.NewsService;
import pl.cinema.cinema_project.services.Price_listService;
import pl.cinema.cinema_project.services.ReservationService;

import javax.validation.Valid;

@Controller
public class main_controller {
    private final NewsService newsService;
    private final Price_listService price_listService;
    private final ReservationService reservationService;

    public main_controller(NewsService newsService, Price_listService price_listService, ReservationService reservationService) {
        this.newsService = newsService;
        this.price_listService = price_listService;
        this.reservationService = reservationService;
    }

//    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
//    public String showIndex(Model model, Pageable pageable) {
//        model.addAttribute("newsListPage", newsService.getALLNews(pageable));
//        return "index";
//    }


    @GetMapping(value = "/index.html",params = {"all"})
    public String showIndex(@ModelAttribute("searchCommand") NewsFilter search) {
        search.clear();
        return "redirect:index.html";
    }

    @RequestMapping(value = "/index.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String showIndex(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") NewsFilter search, BindingResult result) {
        model.addAttribute("newsListPage", newsService.getALLNews(search, pageable));
        return "index";
    }

    @RequestMapping(value = "/repertuar", method = {RequestMethod.GET, RequestMethod.POST})
    public String showMovies(Model model, Pageable pageable) {

        model.addAttribute("reservations", reservationService.getALLReservation(pageable));
        return "repertoire";
    }


    @RequestMapping(value = "news.html", params = "id", method = RequestMethod.GET)
    public String showNewsDetails(Model model, int id) {

        News n = newsService.getNews(id);
        //obłużyć not found exception
        model.addAttribute("news", n);
        return "newsDetails";
    }


    @GetMapping(value = "/kontakt")
    public String showContact(Model model) {
        model.addAttribute("contact", "coś tam");
        return "contact";
    }


    @RequestMapping(value = "/cennik", method = {RequestMethod.GET, RequestMethod.POST})
    public String showOffers(Model model, Pageable pageable) {
        model.addAttribute("price_list", price_listService.getALLPrice_list(pageable));
        return "offers";
    }



    @GetMapping(value = "panel_administratora")
    public String logInAdminPane(Model model) {
        return "login";
    }

    @PostMapping(name = "login")
    public void loginData(Model model) {


    }


    @ModelAttribute("searchCommand")
    public NewsFilter getSimpleSearch() {
        return new NewsFilter();
    }
}