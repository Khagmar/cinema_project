package pl.cinema.cinema_project.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.cinema.cinema_project.controllers.commands.NewsFilter;
import pl.cinema.cinema_project.models.News;

import java.util.List;


public interface NewsService {

    Page<News> getALLNews(NewsFilter filter,Pageable pageable);

    News getNews(int id);
}