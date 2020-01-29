package pl.cinema.cinema_project.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name ="price_list")
public class Price_list {


    @Min(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    @OneToMany(mappedBy = "price_list", cascade = CascadeType.ALL)
    private Set<Reservation> price_lists;

    public Price_list(String name, int price, Reservation... price_list) {
        this.name = name;
        this.price = price;
        this.price_lists = Stream.of(price_list).collect(Collectors.toSet());
        this.price_lists.forEach(x -> x.setPrice_list(this));

    }
}
