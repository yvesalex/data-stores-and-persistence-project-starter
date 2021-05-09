package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.pet.PetDAO;
import com.udacity.jdnd.course3.critter.pet.PetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetDAO petDAO;

    public void save(PetData pet){
        petDAO.savePet(pet);
    }

    public List<PetData> getAll(){
        return petDAO.getAll();
    }

    public PetData findById(long id){
        return petDAO.findById(id);
    }
}
