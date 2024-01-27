package com.example.gestiongroupescolaire.service;

import com.example.gestiongroupescolaire.model.Etudiant;
import com.example.gestiongroupescolaire.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant addEtudiant(Etudiant etudiant){
        try {
           return etudiantRepository.save(etudiant);
        }catch (Exception e){
            throw e;
        }
    }

    public List<Etudiant> getAllEtudiants(){
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long id){
        return etudiantRepository.findById(id).get();
    }

    public Etudiant getEtudiantByNom(Long id){
        return etudiantRepository.findById(id).orElse(null);
    }

    public void deleted(Long id){
        Etudiant file = etudiantRepository.findById(id).get();
        etudiantRepository.delete(file);
    }
}
