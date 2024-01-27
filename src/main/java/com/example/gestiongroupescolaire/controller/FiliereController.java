package com.example.gestiongroupescolaire.controller;


import com.example.gestiongroupescolaire.model.Filiere;
import com.example.gestiongroupescolaire.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @PostMapping("/filieres")
    public Filiere createFiliere( Filiere filiere) {
        try {
            return filiereService.addFiliere(filiere);
        }catch (Exception e ){
            throw e;
        }
    }

    @GetMapping("/filieres")
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @GetMapping("/filieres/{id}")
    public Filiere getFiliereById(@PathVariable Long id) {
        return filiereService.getFiliereById(id);
    }

    @DeleteMapping("/filieres/{id}")
    public void deleteFiliere(@PathVariable Long id) {
        filiereService.deleted(id);
    }

    @PutMapping("/filieres/{id}")
    public Filiere updateFiliere(@PathVariable Long id, @RequestBody Filiere filiere) {
        Filiere  existingFiliere = filiereService.getFiliereById(id);
        existingFiliere.setLibelle(filiere.getLibelle());
        return filiereService.addFiliere(existingFiliere);
    }
}
