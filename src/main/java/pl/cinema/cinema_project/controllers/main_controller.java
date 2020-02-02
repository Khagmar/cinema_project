package pl.cinema.cinema_project.controllers;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cinema.cinema_project.controllers.commands.NewsFilter;
import pl.cinema.cinema_project.controllers.login.LoginForm;
import pl.cinema.cinema_project.models.*;
import pl.cinema.cinema_project.repositories.ReservationRepository;
import pl.cinema.cinema_project.repositories.UserRepository;
import pl.cinema.cinema_project.services.MovieToRoomService;
import pl.cinema.cinema_project.services.NewsService;
import pl.cinema.cinema_project.services.Price_listService;
import pl.cinema.cinema_project.services.ReservationService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class main_controller {
    private final NewsService newsService;
    private final Price_listService price_listService;
    private final ReservationService reservationService;
    private final MovieToRoomService movieToRoomService;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public main_controller(NewsService newsService, Price_listService price_listService, ReservationService reservationService, MovieToRoomService movieToRoomService, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.newsService = newsService;
        this.price_listService = price_listService;
        this.reservationService = reservationService;
        this.movieToRoomService = movieToRoomService;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
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

        model.addAttribute("reservations", movieToRoomService.getALLMovieToRoom(pageable));
        return "repertoire";
    }

    @RequestMapping(value = "/repertuar", params = "id", method = RequestMethod.GET)
    public String showRepertoireDetails(Model model, int id) {

        MovieToRoom m = movieToRoomService.getMovieToRoom(id);
        //obłużyć not found exception
        model.addAttribute("reservation", m);
        return "repertoireDetails";
    }

    @RequestMapping(value = "/repertuarForm", params = "id",method = RequestMethod.GET)
    public String showReservationForm(Model model, Optional<Integer> ids, int id) {

        MovieToRoom m = movieToRoomService.getMovieToRoom(id);
        Price_list normal = price_listService.getPrice_list(1);
        Price_list reduced = price_listService.getPrice_list(2);

        model.addAttribute("normal", normal);
        model.addAttribute("reduced", reduced);

        //obłużyć not found exception
        model.addAttribute("reservation", m);

        model.addAttribute("res", ids.isPresent()?
                reservationService.getReservation(ids.get()):
                new Reservation());
        return "reservationForm";
    }

    @RequestMapping(value = "/admin_panel", method = RequestMethod.GET)
    public String showaNewsForm(Model model) {



        return "redirect:login";
    }

    @RequestMapping(value = "/newsForm", method = RequestMethod.POST)
    public String showaNewsProcess(@Valid @ModelAttribute("news") News news,Model model, BindingResult errors) {

        if(errors.hasErrors()){
            return "admin_panel";
        }

        newsService.saveNews(news);

        return "redirect:admin_panel";
    }


    @RequestMapping(value="/repertuarForm", method= RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    public String processForm(@Valid @ModelAttribute("res") Reservation reservation, BindingResult errors){

        if(errors.hasErrors()){
            return "repertuar";
        }

        reservationService.saveReservation(reservation);



        return "redirect:repertuar";//po udanym dodaniu/edycji przekierowujemy na listę
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






    @ModelAttribute("searchCommand")
    public NewsFilter getSimpleSearch() {
        return new NewsFilter();
    }
}