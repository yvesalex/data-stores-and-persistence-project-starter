package com.udacity.jdnd.course3.critter.user;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Employee{
    @Id
    private long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<EmployeeSkill> skills;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<DayOfWeek> daysAvailable;

    public Employee() {
    }

    public Employee(long id, String name, Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.daysAvailable = daysAvailable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
}
