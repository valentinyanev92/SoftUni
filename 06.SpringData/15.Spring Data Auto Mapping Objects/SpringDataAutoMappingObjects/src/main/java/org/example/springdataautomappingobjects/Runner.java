package org.example.springdataautomappingobjects;

import org.example.springdataautomappingobjects.dtos.ManagerDto;
import org.example.springdataautomappingobjects.service.EmployeeService;
import org.example.springdataautomappingobjects.service.ManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final ManagerService managerService;
    private final ModelMapper modelMapper;

    @Autowired
    public Runner(EmployeeService employeeService, ManagerService managerService) {
        this.employeeService = employeeService;
        this.managerService = managerService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        //01.
//        EmployeeDto one = employeeService.findOne();
//        System.out.println(one);

        //02.
        ManagerDto ceo = managerService.findCeo();
        System.out.printf("%s %s| Employees: %d%n", ceo.getFirstName(), ceo.getLastName(), ceo.getTeam().size());

        ceo.getTeam().forEach(team -> {
            System.out.printf("\t%s %s $%s%n", team.getFirstName(), team.getLastName(), team.getSalary());
        });

        //03.
//        List<EmployeeDto> all = employeeService.findAll();
//        for (EmployeeDto employee : all) {
//            System.out.println(employee);
//        }
    }
}