/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.DoctorInterface;
import com.example.demo.Modelo.Doctor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Idiaz
 */
@Repository

public class DoctorRepository {
     @Autowired
   private DoctorInterface extencionesCrud;
   
   public List<Doctor> getAll (){
       return (List<Doctor>) extencionesCrud.findAll();
   }
   
   public Optional<Doctor> getDoctor(int id){
       return extencionesCrud.findById(id);   
   }
   
   public Doctor save (Doctor doctor) {
       return extencionesCrud.save(doctor);
   }
   
   public void delete(Doctor doctor){
       extencionesCrud.delete(doctor);
   }
    
}
