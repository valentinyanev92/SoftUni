package org.example.springdataautomappingobjects.service;

import org.example.springdataautomappingobjects.dtos.ManagerDto;
import org.example.springdataautomappingobjects.entities.Address;
import org.example.springdataautomappingobjects.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    private final ModelMapper mapper;

    public ManagerService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ManagerDto findCeo() {
        List<Employee> team = new ArrayList<>();
        Address address = new Address("BG", "Ruse");
        team.add(new Employee("Pesho", "Goshov", BigDecimal.TEN, address));
        team.add(new Employee("Pesho2", "Goshov4", BigDecimal.ONE, address));
        team.add(new Employee("Pesho3", "Goshov5", BigDecimal.ZERO, address));
        team.add(new Employee("Pesho4", "Goshov6", BigDecimal.ZERO, address));

        Employee manager = new Employee("Manager", "Goshov",
                BigDecimal.TEN, "birthday", false, null, team, address);


        ManagerDto map = mapper.map(manager, ManagerDto.class);
        return map;
    }
}
