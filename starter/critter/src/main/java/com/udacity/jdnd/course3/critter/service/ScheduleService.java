package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.schedule.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule){
        System.out.println(schedule.getId());
        System.out.println(schedule.getDate());
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAll(){
        return scheduleRepository.findAll();
    }

    public Schedule findById(long id){
        return scheduleRepository.findById(id).get();
    }

    public List<Schedule> findByPetId(long petId) {
        List<Schedule> liste = new ArrayList<Schedule>();
        for (Schedule schedule :
                scheduleRepository.findAll()) {
            if (schedule.getPetIds().contains(petId)) {
                liste.add(schedule);
            }
        }
        return liste;
    }
}
