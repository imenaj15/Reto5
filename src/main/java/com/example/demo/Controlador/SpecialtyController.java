/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Specialty;
import com.example.demo.Servicio.SpecialtyService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Idiaz
 */
@RestController
@RequestMapping("/api/Specialty")

public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    
    @GetMapping("/all")
    public List<Specialty> getAll (){
        return specialtyService.getAll();    
    }
    
    @GetMapping ("/{id}")
        public Optional<Specialty> getSpecialty(@PathVariable("id") int id) {
        return specialtyService.getSpecialty(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save (@RequestBody Specialty specialty){
        return specialtyService.save(specialty);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gamaId){
        return specialtyService.deleteSpecialty(gamaId);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty) {
        return specialtyService.update(specialty);
    }
}
