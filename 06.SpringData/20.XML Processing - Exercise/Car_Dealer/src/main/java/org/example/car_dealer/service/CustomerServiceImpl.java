package org.example.car_dealer.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.transaction.Transactional;
import org.example.car_dealer.dtos.customerDto.CustomerInputDto;
import org.example.car_dealer.dtos.customerDto.CustomerOutputDto;
import org.example.car_dealer.entities.Customer;
import org.example.car_dealer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final XmlMapper xmlMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, XmlMapper xmlMapper, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.xmlMapper = xmlMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/customers.xml");
        List<String> xml = Files.readAllLines(path);
        CustomerInputDto[] customerInputDtos = xmlMapper.readValue(String.join("", xml), CustomerInputDto[].class);
        for (CustomerInputDto customerInput : customerInputDtos) {
            Customer customer = modelMapper.map(customerInput, Customer.class);
            customerRepository.save(customer);
        }
    }

    @Override
    public Customer getRandomCustomer() {
        Long count = customerRepository.count();
        Random random = new Random();
        Long customerId = random.nextLong(1, count);
        return customerRepository.getCustomersById(customerId);
    }

    @Override
    @Transactional
    public void getXmlForAllCustomers() throws IOException {
        List<Customer> customers = customerRepository.getAllCustomersOrderByBirthDate();
        List<CustomerOutputDto> customerOutputDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerOutputDto customerOutputDto = modelMapper.map(customer, CustomerOutputDto.class);
            customerOutputDtos.add(customerOutputDto);
        }

//        Path path = Path.of("src/main/resources/answers/allCustomers.xml");
        String xml = "";
        String s = xmlMapper.writeValueAsString(customerOutputDtos);
        System.out.println(s);
    }
}
