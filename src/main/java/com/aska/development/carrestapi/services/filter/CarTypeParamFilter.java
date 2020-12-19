package com.aska.development.carrestapi.services.filter;

import com.aska.development.carrestapi.services.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class CarTypeParamFilter extends BaseCarFilter {

    public CarTypeParamFilter() {
        super("type");
    }

    public boolean test(Car item, String param) {
        return (param == null) || param.equals(item.getType());
    }
}
