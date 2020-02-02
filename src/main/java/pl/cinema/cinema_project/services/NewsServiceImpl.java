package pl.cinema.cinema_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cinema.cinema_project.controllers.commands.NewsFilter;
import pl.cinema.cinema_project.models.News;
import pl.cinema.cinema_project.repositories.NewsRepository;

import java.util.Optional;


@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Page<News> getALLNews(NewsFilter filter, Pageable pageable) {
        Page page;

        if (filter.isEmpty()) {
            page = newsRepository.findAll(pageable);
        } else {
            page = newsRepository.findALLNewsUsingFilter(filter.getPhraseLIKE(), pageable );
        }

        return page;
    }

    @Override
    public News getNews(int id) {
        News n = newsRepository.findById(id);

        return n;
    }

    @Override
    public void saveNews(News news) {
        newsRepository.save(news);
    }
}