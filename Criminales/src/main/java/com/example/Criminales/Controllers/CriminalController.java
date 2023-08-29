package com.example.Criminales.Controllers;

import com.example.Criminales.Models.CriminalModel;
import com.example.Criminales.Services.CriminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/criminal")
public class CriminalController {
    @Autowired
    CriminalService criminalService;

    @GetMapping()
    public ArrayList<CriminalModel> getCriminales(){
        return criminalService.getCriminales();
    }
    @PostMapping()
    public CriminalModel guardarCriminal(@RequestBody CriminalModel criminal){
        return this.criminalService.guardarCriminal(criminal);
    }
    @GetMapping( path = "/{id}")
    public Optional<CriminalModel> getCriminalFromId(@PathVariable("id") Long id){
        return this.criminalService.getFromId(id);
    }
    @GetMapping("/query")
    public ArrayList<CriminalModel> getCriminalByCapturado(@RequestParam("capturado") boolean capturado){
        return this.criminalService.getFromCapturado(capturado);
    }
    @DeleteMapping(path = "/{id}")
    public String DeleteById(@PathVariable("id") Long id){
        boolean ok = this.criminalService.eliminarCriminal(id);
        if (ok){
            return "Se elimino el criminal con id: " + id;
        }else {
            return "No se pudo eliminar el usuario con id: " + id;
        }
    }
}
