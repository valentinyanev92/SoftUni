package org.example.springdataautomappingobjects.service;

import org.example.springdataautomappingobjects.dtos.EmployeeDto;
import org.example.springdataautomappingobjects.entities.Address;
import org.example.springdataautomappingobjects.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final ModelMapper mapper;

    public EmployeeService(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public EmployeeDto findOne() {
        Address address = new Address("BG", "Ruse");
        Employee employee = new Employee("Pesho", "Goshov", BigDecimal.TEN, address);

        return mapper.map(employee, EmployeeDto.class);
    }

    public List<EmployeeDto> findAll() {
        List<Employee> dbAll = new ArrayList<>();
        Address address = new Address("BG", "Ruse");
        dbAll.add(new Employee("Pesho", "Goshov", BigDecimal.TEN, address));
        dbAll.add(new Employee("Pesho2", "Goshov4", BigDecimal.ONE, address));
        dbAll.add(new Employee("Pesho3", "Goshov5", BigDecimal.ZERO, address));

        EmployeeDto[] employeeDtos = mapper.map(dbAll, EmployeeDto[].class);
//        List<EmployeeDto> employeeDtos = new ArrayList<>();
//        for (Employee employee : dbAll) {
//            employeeDtos.add(mapper.map(employee, EmployeeDto.class));
//        }
        return List.of(employeeDtos);
    }
}