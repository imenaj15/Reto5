/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Doctor;
import com.example.demo.Repositorio.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Idiaz
 */
@Service

public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> getAll(){
        return doctorRepository.getAll();       
    }
    
    public Optional<Doctor> getDoctor (int id){
        return doctorRepository.getDoctor(id);
    }
    public Doctor save (Doctor doctor){
        if (doctor.getId()== null){
            return doctorRepository.save(doctor);
            
        }else{
            Optional<Doctor> doctor1 = doctorRepository.getDoctor(doctor.getId());
            if(doctor1.isEmpty()){
                return doctorRepository.save(doctor);
            }else {
                return doctor;
            }
        }
    }
    
    public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> e= doctorRepository.getDoctor(doctor.getId());
            if(!e.isEmpty()){
                if(doctor.getName()!=null){
                    e.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    e.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getYear()!=null){
                    e.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    e.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty()!=null){
                    e.get().setSpecialty(doctor.getSpecialty());
                }
                doctorRepository.save(e.get());
                return e.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }

    
    public boolean deleteDoctor(int id){
        Boolean d = getDoctor(id).map(doctor -> {
            doctorRepository.delete(doctor);
            return true;
        }).orElse(false);
        return d;
    }
    
}
