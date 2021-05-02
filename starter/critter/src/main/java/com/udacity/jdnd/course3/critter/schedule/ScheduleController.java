package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setActivities(scheduleDTO.getActivities());
        schedule.setDate(scheduleDTO.getDate());
        schedule.setEmployeeIds(scheduleDTO.getEmployeeIds());
        schedule.setPetIds(scheduleDTO.getPetIds());

        scheduleService.save(schedule);
        return scheduleDTO;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleDTO> liste = new ArrayList<ScheduleDTO>();
        for (Schedule schedule :
                scheduleService.getAll()) {
            ScheduleDTO scheduleDto = new ScheduleDTO();
            scheduleDto.setActivities(schedule.getActivities());
            scheduleDto.setDate(schedule.getDate());
            scheduleDto.setEmployeeIds(schedule.getEmployeeIds());
            scheduleDto.setPetIds(schedule.getPetIds());
            liste.add(scheduleDto);
        }
        return liste;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<ScheduleDTO> liste = new ArrayList<ScheduleDTO>();
        for (Schedule schedule :
                scheduleService.getAll()) {
            if(schedule.getPetIds().contains(petId)) {
                ScheduleDTO scheduleDto = new ScheduleDTO();
                scheduleDto.setActivities(schedule.getActivities());
                scheduleDto.setDate(schedule.getDate());
                scheduleDto.setEmployeeIds(schedule.getEmployeeIds());
                scheduleDto.setPetIds(schedule.getPetIds());
                liste.add(scheduleDto);
            }
        }
        return liste;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<ScheduleDTO> liste = new ArrayList<ScheduleDTO>();
        for (Schedule schedule :
                scheduleService.getAll()) {
            if(schedule.getEmployeeIds().contains(employeeId)) {
                ScheduleDTO scheduleDto = new ScheduleDTO();
                scheduleDto.setActivities(schedule.getActivities());
                scheduleDto.setDate(schedule.getDate());
                scheduleDto.setEmployeeIds(schedule.getEmployeeIds());
                scheduleDto.setPetIds(schedule.getPetIds());
                liste.add(scheduleDto);
            }
        }
        return liste;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<ScheduleDTO> liste = new ArrayList<ScheduleDTO>();
        for (Schedule schedule :
                scheduleService.getAll()) {
            if(schedule.getEmployeeIds().contains(customerId)) {
                ScheduleDTO scheduleDto = new ScheduleDTO();
                scheduleDto.setActivities(schedule.getActivities());
                scheduleDto.setDate(schedule.getDate());
                scheduleDto.setEmployeeIds(schedule.getEmployeeIds());
                scheduleDto.setPetIds(schedule.getPetIds());
                liste.add(scheduleDto);
            }
        }
        return liste;
    }
}
