package com.aska.development.carrestapi.services.filter;

import com.aska.development.carrestapi.services.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class CarManufactureParamFilter extends BaseCarFilter {

    public CarManufactureParamFilter() {
        super("manufacture");
    }

    public boolean test(Car item, String param) {
        return (param == null) || param.equals(item.getManufacture());
    }

}
