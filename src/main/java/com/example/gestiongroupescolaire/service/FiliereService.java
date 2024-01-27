package com.example.gestiongroupescolaire.service;

import com.example.gestiongroupescolaire.model.Filiere;
import com.example.gestiongroupescolaire.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere addFiliere(Filiere filiere ){
        try {
            return filiereRepository.save(filiere);
        }catch(Exception e){
            throw e;
        }
    }

    public List<Filiere> getAllFilieres(){
        return filiereRepository.findAll();
    }


    public Filiere getFiliereById(Long id){
        return filiereRepository.findById(id).get();
    }

    public Filiere getFiliereByNom(Long id){
        return filiereRepository.findById(id).orElse(null);
    }

    public void deleted(Long id){
        Filiere file = filiereRepository.findById(id).get();
        filiereRepository.delete(file);
    }

}
