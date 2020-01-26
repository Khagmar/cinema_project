package pl.cinema.cinema_project.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.cinema.cinema_project.models.News;
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    News findById(int id);


    @Query("Select n from News n where (:phrase is null OR :phrase = '' OR upper(v.title) LIKE upper(:phrase) OR upper(v.article) LIKE upper(:phrase) )")
    Page<News> findAll(@Param("phrase")String p);
}
