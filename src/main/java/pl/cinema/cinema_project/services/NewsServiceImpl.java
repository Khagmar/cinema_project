package pl.cinema.cinema_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cinema.cinema_project.models.News;
import pl.cinema.cinema_project.repositories.NewsRepository;


@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Page<News> getALLNews(Pageable pageable) {

        return newsRepository.findAll(pageable);
    }
}
