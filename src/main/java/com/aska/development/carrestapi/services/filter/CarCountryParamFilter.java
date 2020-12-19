package com.aska.development.carrestapi.services.filter;

import com.aska.development.carrestapi.services.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class CarCountryParamFilter extends BaseCarFilter {

    public CarCountryParamFilter() {
        super("country");
    }

    public boolean test(Car item, String param) {
        return (param == null) || param.equals(item.getCountry());
    }

}
