package com.aska.development.carrestapi.services.filter;

import com.aska.development.carrestapi.services.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class CarModelParamFilter extends BaseCarFilter {

    public CarModelParamFilter() {
        super("model");
    }

    public boolean test(Car item, String param) {
        return (param == null) || param.equals(item.getModel());
    }

}
