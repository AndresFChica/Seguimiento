package com.example.Criminales.Services;

import com.example.Criminales.Models.CriminalModel;
import com.example.Criminales.Repositories.CriminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CriminalService {
    @Autowired
    CriminalRepository criminalRepository;

    public ArrayList<CriminalModel> getCriminales(){
        return (ArrayList<CriminalModel>) criminalRepository.findAll();
    }
    public CriminalModel guardarCriminal(CriminalModel criminal){
        return criminalRepository.save(criminal);
    }

    public Optional<CriminalModel> getFromId(Long id){
        return criminalRepository.findById(id);
    }

    public ArrayList<CriminalModel> getFromCapturado(boolean capturado){
        return criminalRepository.findByCapturado(capturado);
    }

    public boolean eliminarCriminal(Long id){
        try{
            criminalRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
