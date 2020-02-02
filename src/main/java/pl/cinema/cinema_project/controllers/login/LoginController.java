package pl.cinema.cinema_project.controllers.login;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cinema.cinema_project.models.*;
import pl.cinema.cinema_project.repositories.ReservationRepository;
import pl.cinema.cinema_project.repositories.UserRepository;
import pl.cinema.cinema_project.services.MovieToRoomService;
import pl.cinema.cinema_project.services.NewsService;
import pl.cinema.cinema_project.services.Price_listService;
import pl.cinema.cinema_project.services.ReservationService;

@Controller
public class LoginController {
    private final NewsService newsService;
    private final Price_listService price_listService;
    private final ReservationService reservationService;
    private final MovieToRoomService movieToRoomService;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public LoginController(NewsService newsService, Price_listService price_listService, ReservationService reservationService, MovieToRoomService movieToRoomService, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.newsService = newsService;
        this.price_listService = price_listService;
        this.reservationService = reservationService;
        this.movieToRoomService = movieToRoomService;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    //    @RequestMapping(value = "/admin_panel", method = RequestMethod.GET)
//    public String getAdminPanel() {
//        return "redirect:login";
//    }

//
@RequestMapping(value = "/login", method = RequestMethod.GET)
public String getLoginForm() {
    //Reservation r = reservationService.getALLReservation(pageable);

    return "login";
}


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model, Pageable pageable) {

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        User user = userRepository.findByUsername(username);
        News news = new News();

        model.addAttribute("reservations", reservationRepository.findAll(pageable));
        model.addAttribute("news", news);
        model.addAttribute("user", user);

        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return "admin_panel";
        }

        return "login";
    }
}
