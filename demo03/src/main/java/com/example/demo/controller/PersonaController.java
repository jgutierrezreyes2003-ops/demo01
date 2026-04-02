package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfaces.IPersonaService;

@Controller
@RequestMapping("crud/persona")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping("/")
    public String persona(Model model) {
        List<PersonaEntity> personas = service.findAll();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/formulario")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("persona", new PersonaEntity());
        return "formulario";
    }

    @GetMapping("/formulario/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        PersonaEntity persona = service.findById(id);
        model.addAttribute("persona", persona);
        return "formulario";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute("persona") PersonaEntity persona) {
        
        System.out.println("Frontend recibe desde HTML: ID=" + persona.getId() + ", Nombre=" + persona.getNombre());
        
        service.save(persona);
        return "redirect:/crud/persona/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/crud/persona/";
    }
}