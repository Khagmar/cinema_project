package pl.cinema.cinema_project.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name ="news")
@NamedQuery(name = "News.findALLVehiclesUsingNamedQuery",
        query = ("Select n from News n where (:phrase is null OR :phrase = '' OR upper(n.title) LIKE upper(:phrase) OR upper(n.article) LIKE upper(:phrase) )"))
public class News implements Serializable {


    @Min(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;


    private String article;

    public News(String title, String name) {
        this.title = title;
        this.article = name;

    }


}
