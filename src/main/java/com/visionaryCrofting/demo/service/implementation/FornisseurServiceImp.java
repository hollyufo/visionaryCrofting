package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.Fournisseur;
import com.visionaryCrofting.demo.repositories.FournisseurRepository;
import com.visionaryCrofting.demo.service.FornisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornisseurServiceImp implements FornisseurService {
    @Autowired
    FournisseurRepository fournisseurRepository;

    // get all fournisseur
    public List<Fournisseur> getAllFournisseur(){
        return fournisseurRepository.findAll();
    }
    // get fournisseur by id
    public Fournisseur getFournisseurById(Long id){
        return fournisseurRepository.findById(id).orElse(null);
    }
    // get fournisseur by Email
    public Fournisseur getFournisseurByEmail(String email){
        return fournisseurRepository.findByEmail(email);
    }
    // add fournisseur
    public Fournisseur addFournisseur(Fournisseur fournisseur){
        // checkin if fournisseur exist
        if (fournisseurRepository.findByEmail(fournisseur.getEmail()) != null){
            throw new IllegalStateException("Fournisseur existe déja");
            // checking if fournisseur values are empty
        }else if (fournisseur.getEmail() == null || fournisseur.getEmail().isEmpty() || fournisseur.getEmail().isBlank()){
            throw new IllegalStateException("please fill all the inputs");
        }else{
            return fournisseurRepository.save(fournisseur);
        }
    }
    // delete fournisseur
    public String deleteFournisseur(Long id){
        fournisseurRepository.deleteById(id);
        return "Fournisseur deleted";
    }
    // update fournisseur
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur){
        fournisseur.setId(id);
        Fournisseur existingFournisseur = fournisseurRepository.findById(fournisseur.getId()).orElse(null);
        existingFournisseur.setName(fournisseur.getName());
        existingFournisseur.setEmail(fournisseur.getEmail());
        existingFournisseur.setTel(fournisseur.getTel());
        existingFournisseur.setPassword(fournisseur.getPassword());
        return fournisseurRepository.save(existingFournisseur);
    }
}
