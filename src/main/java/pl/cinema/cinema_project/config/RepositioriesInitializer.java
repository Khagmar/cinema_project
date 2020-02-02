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

    @Autowired
    private NewsRepository newsRepository;

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

                    String pom1 = "Po 25 latach odsiadki Franz Maurer wychodzi z więzienia i wkracza w nową Polskę, w której nic nie jest takie, jak zapamiętał. Kto i co czeka na człowieka, który przez ostatnie ćwierć wieku… nie robił nic? Jak odnajdzie się w świecie, w którym dawne zasady i lojalność przestały obowiązywać? Tego dowiemy się, gdy los ponownie połączy Franza i „Nowego”. Ich spotkanie zmieni wszystko.";
                    String pom2 = "A znacie to o policjantce, kanarku, wariatce i mafijnej księżniczce? \"Ptaki Nocy (i fantastyczna emancypacja pewnej Harley Quinn)\" to pokręcona historia, opowiadana przez samą Harley w stylu, w jakim tylko ona może ją opowiedzieć. Kiedy najbardziej narcystyczny z bandziorów Gotham, Roman Sionis, i jego oddana prawa ręka Zsasz biorą na cel niejaką Cass, w poszukiwania dziewczyny angażuje się całe miasto. Nieprawdopodobny zbieg okoliczności krzyżuje drogi Harley, Łowczyni, Czarnego Kanarka i Renee Montoyi. Cztery diametralnie różniące się kobiety nie mają wyjścia. Muszą współpracować, żeby pokonać Romana.";
                    String pom3 = "„Zenek” - film oparty na życiorysie Zenona Martyniuka – opowiada historię chłopaka z podlaskiej wsi, który realizuje swoje wielkie marzenie, by śpiewać i bawić tłumy. Ukazuje drogę Zenka do ogromnego sukcesu, który osiągnął dzięki uporowi i ciężkiej pracy, przypłaconej często niemałymi wyrzeczeniami, zyskując miano króla polskiego disco polo.";
                    String pom4 = "Czołowy specjalista od kina sensacyjnego Patryk Vega odkrywa najgłośniejsze patologie w polskich klubach piłkarskich. Powiązania z mafią i gangsterami, ustawianie meczów, groźby, zastraszania i agresja na stadionach – wszystko to w pełnym gwiazd filmie, w którym pierwszoplanowe role grają: Antoni Królikowski, Maciej Stuhr, Andrzej Grabowski, Piotr Stramowski, Małgorzata Kożuchowska, Katarzyna Zawadzka i Zbigniew Zamachowski, wspierani m.in. przez kadrowiczów piłkarskiej reprezentacji Polski – Kamila Grosickiego i Sławomira Peszko. „Bad Boy” to nie tylko inspirowana prawdziwymi wydarzeniami produkcja, która ujawnia najmroczniejszą stronę środowiska piłki nożnej. To również pełna akcji i wyrazistych postaci historia o miłości, zdradzie, pożądaniu i kobietach, które wolą niegrzecznych chłopców.";
                    News news1 = new News("PSY3: W imię zasad",pom1);
                    News news2 = new News("Ptaki Nocy (i fantastyczna emancypacja pewnej Harley Quinn)",pom2);
                    News news3 = new News("Zenek",pom3);
                    News news4 = new News("Bad Boy",pom4);

                    if (newsRepository.findAll().isEmpty() == true) {
                        newsRepository.save(news1);
                        newsRepository.save(news2);
                        newsRepository.save(news3);
                        newsRepository.save(news4);
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
                    String psy = "Po 25 latach odsiadki Franz Maurer wychodzi z więzienia i wkracza w nową Polskę, w której nic nie jest takie, jak zapamiętał. Kto i co czeka na człowieka, który przez ostatnie ćwierć wieku… nie robił nic? Jak odnajdzie się w świecie, w którym dawne zasady i lojalność przestały obowiązywać? Tego dowiemy się, gdy los ponownie połączy Franza i „Nowego”. Ich spotkanie zmieni wszystko.";
                    Movies movies = new Movies("Doctor Dolittle", "familijny/fantasy/komedia",pom,2020,1,29);
                    Movies movies1 = new Movies("PSY 3: W imię zasad", "sensacyjny",psy,2020,1,1);
                    if(moviesRepository.findAll().isEmpty() == true)
                    {

                        moviesRepository.save(movies);
                        moviesRepository.save(movies1);

                    }
                    Room room = new Room(20, 15);
                    Room room1 = new Room(10, 10);
                    if(roomRepository.findAll().isEmpty() == true)
                    {

                        roomRepository.save(room);
                        roomRepository.save(room1);

                    }
                    MovieToRoom movieToRoom = new MovieToRoom(room,movies,30,1,2020,20,30);
                    MovieToRoom movieToRoom1 = new MovieToRoom(room,movies1,30,1,2020,21,30);
                    if(movieToRoomRepository.findAll().isEmpty() == true)
                    {

                        movieToRoomRepository.save(movieToRoom);
                        movieToRoomRepository.save(movieToRoom1);

                    }

                    Reservation reservation = new Reservation(movieToRoom,reduced,1,1,"uzytkownik191819@gmail.com");
                    if(reservationRepository.findAll().isEmpty() == true)
                    {

                        reservationRepository.save(reservation);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }




        };
    }
}
