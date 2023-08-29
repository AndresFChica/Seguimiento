package com.example.Criminales.Repositories;

import com.example.Criminales.Models.CriminalModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CriminalRepository extends CrudRepository<CriminalModel, Long> {
    public abstract ArrayList<CriminalModel> findByCapturado(boolean capturado);
}
