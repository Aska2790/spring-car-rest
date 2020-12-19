package com.aska.development.carrestapi.services;

import com.aska.development.carrestapi.exceptions.NotFoundException;
import com.aska.development.carrestapi.services.dto.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceImplTest {


    //region Fields

    @Autowired
    private WebApplicationContext mContext;
    private CarService mCarService;

    //endregion

    //region Constructors

    @Before
    public void setUp() throws Exception {
        mCarService = mContext.getBean(CarService.class);
        assertThat(mCarService).isNotNull();
    }

    @After
    public void tearDown() throws Exception {
    }

    //endregion

    //region Positive tests

    @Test
    public void ifInsertACarIsTheIdentifierReturnedCorrectly() {
        Long expectedCarId =  5L;
        Car car = new Car()
                .setManufacture("Manufacture")
                .setModel("Model")
                .setType("Small")
                .setCountry("USA")
                .setCreateDate(new Date());

        mCarService.insert(car);

        assertThat(car.getId()).isEqualTo(expectedCarId);
    }

    @Test
    public void whenUpdatingAreAllFieldsSet() {
        long id = 3L;
        Car expectedCar = new Car()
                .setId(id)
                .setManufacture("Manufacture")
                .setModel("Model")
                .setType("Small")
                .setCountry("USA")
                .setCreateDate(new Date());

        mCarService.update(expectedCar);

        Car actualCar = mCarService.findById(id);
        assertThat(actualCar.getModel()).isEqualTo(expectedCar.getModel());
        assertThat(actualCar.getManufacture()).isEqualTo(expectedCar.getManufacture());
        assertThat(actualCar.getType()).isEqualTo(expectedCar.getType());
        assertThat(actualCar.getCountry()).isEqualTo(expectedCar.getCountry());

    }

    @Test(expected = NotFoundException.class)
    public void ifRequestingNonExistentCarWillExceptionBeThrow() {
        mCarService.findById(35L);
    }

    @Test(expected = NotFoundException.class)
    public void ifUpdatingNonExistentCarWillExceptionBeThrow() {
        long id = 25L;
        Car expectedCar = new Car()
                .setId(id)
                .setManufacture("Manufacture")
                .setModel("Model")
                .setType("Small")
                .setCountry("USA")
                .setCreateDate(new Date());

        mCarService.update(expectedCar);

    }

    @Test(expected = NotFoundException.class)
    public void ifDeletingNonExistentCarWillExceptionBeThrow() {
        long id = 45L;
        mCarService.delete(id);

    }

    @Test
    public void insert() {
        //region Preparation


        //endregion

        //region Action


        //endregion

        //region Verification


        //endregion
    }

    //endregion

    //region Negative tests


    //endregion
}