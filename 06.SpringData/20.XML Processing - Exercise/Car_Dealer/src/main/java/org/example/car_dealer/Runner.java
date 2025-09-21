package org.example.car_dealer;

import org.example.car_dealer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;

    @Autowired
    public Runner(CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {
//        supplierService.importData();
//        partService.importData();
//        carService.importData();
//        customerService.importData();
//        saleService.importData();

        customerService.getXmlForAllCustomers();
    }
}
