package com.cataas.cataas.service;

import com.cataas.cataas.dto.CataasDto;
import com.cataas.cataas.model.Cat;
import com.cataas.cataas.repository.cataasRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class cataasService {

    private final cataasRepository cataasrepository;

    public cataasService(cataasRepository cataasrepository) {
        this.cataasrepository = cataasrepository;
    }

    private final WebClient client = WebClient.create("https://cataas.com");

    public void getCatsFromApi() {
        if (cataasrepository.count() == 0)
             saveToDB(client.get()
                .uri("/api/cats?skip=0&limit=5000")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Cat>>() {})
                .block());

    }

    public void saveToDB(List<Cat> cats) {
        cataasrepository.saveAll(cats);
    }

    public List<Cat> getCats() {
        return cataasrepository.findAll();
    }

    public List<CataasDto> getAsDto() {
        return cataasrepository.findAll().stream().map(cat ->
                new CataasDto(cat.getId(), cat.getCreatedAt(),cat.getTags())
                ).toList();
    }
}
