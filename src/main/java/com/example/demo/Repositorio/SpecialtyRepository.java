/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.SpecialtyInterface;
import com.example.demo.Modelo.Specialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Idiaz
 */
@Repository


public class SpecialtyRepository {
   @Autowired
   private SpecialtyInterface extencionesCrud;
   
   public List<Specialty> getAll (){
       return (List<Specialty>) extencionesCrud.findAll();
   }
   
   public Optional<Specialty> getSpecialty(int id){
       return extencionesCrud.findById(id);   
   }
   
   public Specialty save (Specialty specialty) {
       return extencionesCrud.save(specialty);
   }
   
   public void delete(Specialty specialty){
       extencionesCrud.delete(specialty);
   }
   
}
