package pl.cinema.cinema_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cinema.cinema_project.models.Price_list;
import pl.cinema.cinema_project.repositories.Price_listRepository;

@Service
public class Price_listServiceImpl implements Price_listService {

    @Autowired
    private Price_listRepository price_listRepository;

    @Override
    public Page<Price_list> getALLPrice_list(Pageable pageable) {
        return price_listRepository.findAll(pageable);
    }

    @Override
    public Price_list getPrice_list(int id) {
        Price_list p = price_listRepository.findById(id);
        return p;
    }

}
