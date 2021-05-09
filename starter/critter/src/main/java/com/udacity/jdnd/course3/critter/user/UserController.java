package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.PetData;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PetService petService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = new Customer(customerDTO.getId(),
                customerDTO.getName(), customerDTO.getNotes(), customerDTO.getPetIds(), customerDTO.getPhoneNumber());
        customerService.save(customer);
        return customerDTO;
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> liste = new ArrayList<CustomerDTO>();
        for (Customer customer :
                customerService.getAll()) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setNotes(customer.getNotes());
            customerDTO.setPetIds(customer.getPetIds());
            customerDTO.setPhoneNumber(customer.getPhoneNumber());
            liste.add(customerDTO);
        }
        return liste;
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        CustomerDTO customerDTO = new CustomerDTO();
        PetData petData = petService.findById(petId);
        if(petData != null){
            Customer customer = customerService.findById(petData.getOwnerId());
            if(customer != null){
                customerDTO.setId(customer.getId());
                customerDTO.setName(customer.getName());
                customerDTO.setNotes(customer.getNotes());
                customerDTO.setPetIds(customer.getPetIds());
                customerDTO.setPhoneNumber(customer.getPhoneNumber());
            }
        }
        return customerDTO;
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getId(), employeeDTO.getName(),
                employeeDTO.getSkills(), employeeDTO.getDaysAvailable());
        employeeService.save(employee);
        return employeeDTO;
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        EmployeeDTO employeeDTO = null;
        if(employee != null){
            employeeDTO.setId(employeeId);
            employeeDTO.setName(employee.getName());
            employeeDTO.setSkills(employee.getSkills());
            employeeDTO.setDaysAvailable(employee.getDaysAvailable());
        }
        return employeeDTO;
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeeService.save(employee);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        List<EmployeeDTO> liste = new ArrayList<EmployeeDTO>();
        for (Employee employee : employeeService.getAll()) {
            System.out.println(employee.getName());
            if (employee.getDaysAvailable().contains(employeeDTO.getDate())) {
                EmployeeDTO eDTO = null;
                if(employee != null){
                    eDTO.setId(employee.getId());
                    eDTO.setName(employee.getName());
                    eDTO.setSkills(employee.getSkills());
                    eDTO.setDaysAvailable(employee.getDaysAvailable());
                    liste.add(eDTO);
                }
            }
        }
        return  liste;
    }

}
