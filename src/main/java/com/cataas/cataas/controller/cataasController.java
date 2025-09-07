package com.cataas.cataas.controller;

import com.cataas.cataas.dto.CataasDto;
import com.cataas.cataas.model.Cat;
import com.cataas.cataas.service.cataasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cats")
public class cataasController {
    private final cataasService cataasservice;

    public cataasController(cataasService cataasservice) {
        this.cataasservice = cataasservice;
    }

    @GetMapping("fetch-cats")
    public void getCatsFromApi() {
        cataasservice.getCatsFromApi();
    }

    @GetMapping("get-cats")
    public List<Cat> getCats() {
        return cataasservice.getCats();
    }
}
