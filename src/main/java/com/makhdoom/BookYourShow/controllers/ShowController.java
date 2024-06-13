package com.makhdoom.BookYourShow.controllers;

import com.makhdoom.BookYourShow.dtos.CreateShowRequestDTO;
import com.makhdoom.BookYourShow.models.Show;
import com.makhdoom.BookYourShow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    @GetMapping("/{id}")
    public Show getShow(Long id) {
        return showService.getShow(id);
    }

    @PostMapping("")
    public Show craeteShow(CreateShowRequestDTO request) {
        return showService.createShow(request);
    }
}
