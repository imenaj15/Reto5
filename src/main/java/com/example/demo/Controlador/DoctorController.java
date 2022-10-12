/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Doctor;
import com.example.demo.Servicio.DoctorService;
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
@RequestMapping("/api/Doctor")

public class DoctorController {
            @Autowired
    private DoctorService doctorService;
    
    @GetMapping("/all")
    public List<Doctor> getAll(){
        return doctorService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int id){
        return doctorService.getDoctor(id);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save (@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int doctorId){
        return doctorService.deleteDoctor(doctorId);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }
}
