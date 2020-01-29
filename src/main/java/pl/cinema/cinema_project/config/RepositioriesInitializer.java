package pl.cinema.cinema_project.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.cinema.cinema_project.models.*;
import pl.cinema.cinema_project.repositories.*;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class RepositioriesInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Price_listRepository price_listRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MovieToRoomRepository movieToRoomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;


    @Bean
    InitializingBean init(){
        return () ->{
            if(roleRepository.findAll().isEmpty() == true)
            {
                try {

                    Role roleAdmin = roleRepository.save(new Role(Role.Types.ROLE_ADMIN));
                    Role roleMod = roleRepository.save(new Role(Role.Types.ROLE_MOD));

                    User admin = new User("admin", true);
                    //admin.setRoles(new HashSet<>(Arrays.asList(roleAdmin)));
                    admin.setPassword("admin");

                    User mod = new User("mod", true);
                    //admin.setRoles(new HashSet<>(Arrays.asList(roleMod)));
                    mod.setPassword("mod");

                    userRepository.save(admin);
                    userRepository.save(mod);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Price_list normal = new Price_list("normalny",20);
            Price_list reduced = new Price_list("ulgowy",16);
            if(price_listRepository.findAll().isEmpty() == true){
                price_listRepository.save(normal);
                price_listRepository.save(reduced);
            }

            String pom = "Robert Downey Jr. wciela się w jedną z najsłynniejszych postaci światowej literatury w pełnej przygód nowej filmowej wersji opowieści o człowieku, który potrafi rozmawiać ze zwierzętami. Oto doktor Dolittle.\n" +
                    "\n" +
                    "Po stracie żony, siedem lat wcześniej, ekscentryczny doktor John Dolittle (Downey Jr.), słynny naukowiec i lekarz weterynarii w wiktoriańskiej Anglii, wiedzie pustelniczy tryb życia, w otoczeniu menażerii swych egzotycznych zwierząt.\n" +
                    "\n" +
                    "Kiedy jednak młoda królowa zapada na śmiertelną chorobę, nieustraszony doktor wyrusza w pełną przygód podróż na mityczną wyspę, gdzie spodziewa się znaleźć lekarstwo dla królowej. Wykorzysta w tym swą odwagę i niepodrabialne poczucie humoru, odkryje wiele niezwykłych stworzeń i spotka się ponownie ze starymi wrogami.\n" +
                    "\n" +
                    "W wyprawie towarzyszyć mu będzie młody, pewny siebie uczeń (Harry Collett) oraz wesoła ferajna przyjaciół-zwierząt, w tym lękliwy goryl, entuzjastycznie nastawiona do świata kaczka (o, cóż, ptasim móżdżku), niezwykły duet składający się z cynicznego strusia i optymistycznego niedźwiedzia polarnego oraz prawdziwa twardzielka – papuga, najbardziej zaufana przyjaciółka Dolittle’a.\n" +
                    "\n" +
                    "Za reżyserię odpowiada nagrodzony Oscarem® Stephen Gaghan („Syriana”, „Traffic”).";
            Movies movies = new Movies("Doctor Dolittle", "familijny/fantasy/komedia",pom,2020,1,29);
            if(moviesRepository.findAll().isEmpty() == true)
            {

                 moviesRepository.save(movies);

            }
            Room room = new Room(20, 15);
            if(roomRepository.findAll().isEmpty() == true)
            {

                roomRepository.save(room);

            }
            MovieToRoom movieToRoom = new MovieToRoom(room,movies,30,1,2020,20,0);
            if(movieToRoomRepository.findAll().isEmpty() == true)
            {

                movieToRoomRepository.save(movieToRoom);

            }

            Reservation reservation = new Reservation(movieToRoom,normal,1,1);
            if(movieToRoomRepository.findAll().isEmpty() == true)
            {

                reservationRepository.save(reservation);

            }


        };
    }
}
