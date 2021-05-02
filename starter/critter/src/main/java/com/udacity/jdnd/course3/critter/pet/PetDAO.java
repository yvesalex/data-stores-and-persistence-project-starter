package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

public interface PetDAO {
    List<PetData> getAll();
    PetData findById(long id);
    long savePet(PetData petData);
}
