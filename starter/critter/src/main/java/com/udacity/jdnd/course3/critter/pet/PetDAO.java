package com.udacity.jdnd.course3.critter.pet;

import java.util.List;
import  com.udacity.jdnd.course3.critter.pet.PetData;

public interface PetDAO {
    List<PetData> getAll();
    PetData findById(long id);
    void savePet(PetData petData);
}
