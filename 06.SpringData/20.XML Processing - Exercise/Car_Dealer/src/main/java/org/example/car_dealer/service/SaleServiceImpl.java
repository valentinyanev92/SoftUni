package org.example.car_dealer.service;

import org.example.car_dealer.entities.Car;
import org.example.car_dealer.entities.Customer;
import org.example.car_dealer.entities.Sale;
import org.example.car_dealer.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    public void importData() {
//        Random random = new Random();
//        List<BigDecimal> discounts = List.of(new BigDecimal("0.05"),
//                new BigDecimal("0.10"),
//                new BigDecimal("0.15"),
//                new BigDecimal("0.20"),
//                new BigDecimal("0.30"),
//                new BigDecimal("0.40"),
//                new BigDecimal("0.50"));
//
//        for (int i = 0; i < 100; i++) {
//            Car car = carService.getRandomCar();
//            Customer customer = customerService.getRandomCustomer();
//            BigDecimal discount = discounts.get(random.nextInt(discounts.size()));
//
//            if (customer.getYoungDriver()){
//                discount.add(new BigDecimal("0.05"));
//            }
//
//            Sale sale = new Sale();
//            sale.setCar(car);
//            sale.setCustomer(customer);
//            sale.setDiscount(discount);
//
//            saleRepository.save(sale);
//        }

        // Позволените базови отстъпки (включително 0%)
        List<BigDecimal> baseDiscounts = List.of(
                new BigDecimal("0.00"),
                new BigDecimal("0.05"),
                new BigDecimal("0.10"),
                new BigDecimal("0.15"),
                new BigDecimal("0.20"),
                new BigDecimal("0.30"),
                new BigDecimal("0.40"),
                new BigDecimal("0.50")
        );

        Random rnd = new Random();
        int targetCount = 100; // искаш да напълниш базата с ~100 продажби

        // За да избегнем повторни продажби в рамките на този импорт
        // (освен проверката към БД) държим set от вече използвани коли в този рън:
        java.util.Set<Long> usedCarIdsInThisRun = new java.util.HashSet<>();

        int created = 0;
        int safety = 0; // предпазен брояч, за да не влезем в безкраен цикъл ако колите са свършили

        while (created < targetCount && safety < targetCount * 5) {
            safety++;

            Car car = carService.getRandomCar();
            if (car == null || car.getId() == null) {
                continue;
            }

            // прескачаме ако колата вече е продадена (в БД) или я „ползваме“ вече в този рън
            if (usedCarIdsInThisRun.contains(car.getId()) || saleRepository.existsByCar_Id(car.getId())) {
                continue;
            }

            Customer customer = customerService.getRandomCustomer();
            if (customer == null) {
                continue;
            }

            // Вземи базова отстъпка
            BigDecimal discount = baseDiscounts.get(rnd.nextInt(baseDiscounts.size()));

            // +5% ако е млад шофьор (Boolean-safe проверка)
            if (Boolean.TRUE.equals(customer.getYoungDriver())) {
                discount = discount.add(new BigDecimal("0.05"));
                // safety cap: не повече от 100%
                if (discount.compareTo(BigDecimal.ONE) > 0) {
                    discount = BigDecimal.ONE;
                }
            }

            Sale sale = new Sale();
            sale.setCar(car);
            sale.setCustomer(customer);
            sale.setDiscount(discount);

            saleRepository.save(sale);

            usedCarIdsInThisRun.add(car.getId());
            created++;
        }
    }
}
