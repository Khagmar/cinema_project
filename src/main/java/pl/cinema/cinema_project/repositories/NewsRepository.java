package pl.cinema.cinema_project.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.cinema.cinema_project.models.News;
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    News findById(int id);

    Page<News> findAll( Pageable pageable);

    @Query("SELECT n FROM News n WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR " +
            "upper(n.title) LIKE upper(:phrase) OR " +
            "upper(n.article) LIKE upper(:phrase) " +
            ")")
    Page<News> findALLNewsUsingFilter(@Param("phrase") String p, Pageable pageable);
}