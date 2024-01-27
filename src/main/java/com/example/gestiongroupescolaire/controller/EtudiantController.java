package com.example.gestiongroupescolaire.controller;

import com.example.gestiongroupescolaire.model.Etudiant;
import com.example.gestiongroupescolaire.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/etudiants")
    public Etudiant createEtudiant(Etudiant etudiant){
        try {
            return etudiantService.addEtudiant(etudiant);
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants(){
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id){
        return etudiantService.getEtudiantById(id);
    }

    @GetMapping("/etudiants/{id}")
    public void deleteEtudiant(@PathVariable long id){
        etudiantService.deleted(id);
    }

    @PutMapping("/etudiants/{id}")
    public Etudiant updateEtudiant (@PathVariable Long id, @RequestBody Etudiant etudiant){
        Etudiant existingEtudiant = etudiantService.getEtudiantById(id);
        existingEtudiant.setNom(etudiant.getNom());
        existingEtudiant.setPrenom(etudiant.getPrenom());
        existingEtudiant.setLogin(etudiant.getLogin());
        existingEtudiant.setTelephone(etudiant.getTelephone());
        existingEtudiant.setPassword(etudiant.getPassword());
        return etudiantService.addEtudiant(existingEtudiant);
    }
}
