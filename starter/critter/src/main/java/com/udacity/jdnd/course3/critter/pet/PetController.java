package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        PetData petData = new PetData(petDTO.getId(), petDTO.getType(), petDTO.getName(),
                petDTO.getBirthDate(), petDTO.getNotes());
        petService.save(petData);
        return petDTO;
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        PetData petData = petService.findById(petId);
        PetDTO petDTO = new PetDTO();
        if(petData != null){
            petDTO.setBirthDate(petData.getBirthDate());
            petDTO.setId(petData.getId());
            petDTO.setName(petData.getName());
            petDTO.setNotes(petData.getNotes());
            petDTO.setType(PetType.valueOf(petData.getType()));
            petDTO.setOwnerId(petData.getOwnerId());
        }
        return petDTO;
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<PetDTO> liste = new ArrayList<PetDTO>();
        for (PetData petData :
                petService.getAll()) {
            PetDTO petDTO = new PetDTO();
            if(petData != null){
                petDTO.setBirthDate(petData.getBirthDate());
                petDTO.setId(petData.getId());
                petDTO.setName(petData.getName());
                petDTO.setNotes(petData.getNotes());
                petDTO.setType(PetType.valueOf(petData.getType()));
                petDTO.setOwnerId(petData.getOwnerId());
                liste.add(petDTO);
            }
        }
        return  liste;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<PetDTO> liste = new ArrayList<PetDTO>();
        for (PetData petData :
                petService.getAll()) {
            PetDTO petDTO = new PetDTO();
            if(petData.getOwnerId() == ownerId){
                petDTO.setBirthDate(petData.getBirthDate());
                petDTO.setId(petData.getId());
                petDTO.setName(petData.getName());
                petDTO.setNotes(petData.getNotes());
                petDTO.setType(PetType.valueOf(petData.getType()));
                petDTO.setOwnerId(petData.getOwnerId());
                liste.add(petDTO);
            }
        }
        return  liste;
    }
}
