package com.aska.development.carrestapi.auxiliary.util;

import com.aska.development.carrestapi.services.dto.Car;
import com.aska.development.carrestapi.services.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Objects;

@Service
public class DbInitializeUtil {
    //region Fields

    private CarService mCarService;

    //endregion

    //region Properties
    //endregion

    //region Constructors

    public DbInitializeUtil(CarService carService) {
        mCarService = carService;
        Objects.requireNonNull(mCarService);
    }

    //endregion

    //region Methods

    @PostConstruct
    public void initialize(){
        mCarService.insert(new Car()
                .setManufacture("Buick")
                .setModel("Roadmaster")
                .setType("Large")
                .setCountry("USA")
                .setCreateDate(new Date())
        );
        mCarService.insert(new Car()
                .setManufacture("Buick")
                .setModel("LeSabre")
                .setType("Large")
                .setCountry("USA")
                .setCreateDate(new Date())
        );

        mCarService.insert(new Car()
                .setManufacture("Chrysler")
                .setModel("Imperial")
                .setType("Large")
                .setCountry("USA")
                .setCreateDate(new Date())
        );

        mCarService.insert(new Car()
                .setManufacture("Cadillac")
                .setModel("DeVille")
                .setType("Large")
                .setCountry("USA")
                .setCreateDate(new Date())
        );

    }

    //endregion

    //region Nested
    //endregion
}
