package pl.cinema.cinema_project.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.cinema.cinema_project.models.Price_list;

public interface Price_listService {

    Page<Price_list> getALLPrice_list(Pageable pageable);

    Price_list getPrice_list(int id);

}
