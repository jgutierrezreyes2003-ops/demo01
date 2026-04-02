package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfaces.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

    private final String BASE_URL = "http://localhost:8080/api/v1/entities/persona/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<PersonaEntity> findAll() {
        try {
            PersonaEntity[] personasArray = restTemplate.getForObject(BASE_URL, PersonaEntity[].class);
            if (personasArray != null) {
                return Arrays.asList(personasArray);
            }
            return Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public PersonaEntity findById(Long id) {
        try {
            return restTemplate.getForObject(BASE_URL + id, PersonaEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PersonaEntity save(PersonaEntity persona) {
        try {
            if (persona.getId() != null) {

                restTemplate.put(BASE_URL + persona.getId(), persona);
                return persona;
            } else {

                return restTemplate.postForObject(BASE_URL, persona, PersonaEntity.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            restTemplate.delete(BASE_URL + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}